package com.st.smartsecurity.service.Impl;

import com.google.common.base.Preconditions;
import com.st.smartsecurity.constant.UserConstant;
import com.st.smartsecurity.mapper.QdUserMapper;
import com.st.smartsecurity.pojo.po.QdUser;
import com.st.smartsecurity.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    QdUserMapper qdUserMapper;

    @Override
    public QdUser login(String name, int workNumber, String openId) {
        if (StringUtils.isNotEmpty(openId)){
            Example example = new Example(QdUser.class);
            example.createCriteria().andEqualTo("openId",openId).andEqualTo("state",UserConstant.USER_STATE_NORMAL);
            List<QdUser> qdUsers = qdUserMapper.selectByExample(example);
            Preconditions.checkArgument(qdUsers.size()==1,"登录失败");
            return qdUsers.get(0);
        }
        return null;
    }
}
