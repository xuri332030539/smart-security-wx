package com.st.smartsecurity.service.impl;

import com.auth0.jwt.JWT;
import com.google.common.base.Preconditions;
import com.qs.common.core.util.BeanUtil;
import com.st.smartsecurity.constant.UserConstant;
import com.st.smartsecurity.mapper.QdUserMapper;
import com.st.smartsecurity.pojo.dto.QdUserDTO;
import com.st.smartsecurity.pojo.po.QdUser;
import com.st.smartsecurity.service.LoginService;
import com.st.smartsecurity.util.TokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 登录
 * @author xuri
 *@date 2019/12/18
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    QdUserMapper qdUserMapper;
    @Resource
    TokenUtil tokenUtil;
    @Resource
    private HttpServletRequest request;

    @Override
    public QdUserDTO login(String name, Integer workNumber, String openId) {
        //未输入姓名密码 通过openid登录
        if (StringUtils.isEmpty(name)&&StringUtils.isNotEmpty(openId)){
            Example example = new Example(QdUser.class);
            example.createCriteria().andEqualTo("openId",openId).andEqualTo("state",UserConstant.USER_STATE_NORMAL);
            List<QdUser> qdUsers = qdUserMapper.selectByExample(example);
            Preconditions.checkArgument(qdUsers.size()==1,"登录失败");
            QdUserDTO qdUserDTO = BeanUtil.copyProperties(qdUsers.get(0), QdUserDTO.class);
            //获取token
            String token = tokenUtil.getToken(qdUserDTO);
            request.getSession().setAttribute("token"+JWT.decode(token).getAudience().get(0),token);
            qdUserDTO.setToken(token);
            return qdUserDTO;
        }
        //输入了姓名密码，1：用户openid为空，进行绑定，2：用户openid不为空，进行验证
        if (StringUtils.isNotEmpty(name)){
            Example example = new Example(QdUser.class);
            example.createCriteria().andEqualTo("workNumber",workNumber).andEqualTo("name",name).andEqualTo("state",UserConstant.USER_STATE_NORMAL);
            List<QdUser> qdUsers = qdUserMapper.selectByExample(example);
            Preconditions.checkArgument(qdUsers.size()==1,"登录失败");
            if (StringUtils.isEmpty(qdUsers.get(0).getOpenId())){
                qdUsers.get(0).setOpenId(openId);
                qdUserMapper.updateByPrimaryKey(qdUsers.get(0));
            }else{
                Preconditions.checkArgument(qdUsers.get(0).getOpenId().equals(openId));
            }
            QdUserDTO qdUserDTO = BeanUtil.copyProperties(qdUsers.get(0), QdUserDTO.class);
            String token = tokenUtil.getToken(qdUserDTO);
            request.getSession().setAttribute("token"+JWT.decode(token).getAudience().get(0),token);
            qdUserDTO.setToken(token);
            return qdUserDTO;
        }
        return null;
    }
}
