package com.st.smartsecurity.controller;

import com.qs.common.core.response.BaseResponse;
import com.st.smartsecurity.annotation.PassToken;
import com.st.smartsecurity.pojo.dto.QdUserDTO;
import com.st.smartsecurity.pojo.po.QdUser;
import com.st.smartsecurity.service.LoginService;
import com.st.smartsecurity.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录
 * @author xuri
 *@date 2019/12/18
 */
@Api(value = "login",tags = "登录",position = 1)
@RestController
@RequestMapping("login")
public class LoginController {
    @Resource
    LoginService loginService;


    @PostMapping("login")
    @ApiOperation("登录")
    @PassToken
    public BaseResponse<QdUserDTO> login(String name, Integer workNumber, String openId){
        QdUserDTO qdUserDTO = loginService.login(name, workNumber, openId);
        return BaseResponse.success(qdUserDTO);
    }




    @PostMapping("test")
    @ApiOperation("登录")
    public BaseResponse test(){
        return BaseResponse.success("2231s");
    }
}
