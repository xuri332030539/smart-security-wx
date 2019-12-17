package com.st.smartsecurity.controller;

import com.qs.common.core.response.BaseResponse;
import com.st.smartsecurity.annotation.PassToken;
import com.st.smartsecurity.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 大屏展示接口
 * @author lhm
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
    public BaseResponse login(String name,int workNumber,String openId){
        return BaseResponse.success(loginService.login(name,workNumber,openId));
    }
}
