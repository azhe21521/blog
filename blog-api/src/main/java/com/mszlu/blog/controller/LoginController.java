package com.mszlu.blog.controller;

import com.mszlu.blog.service.LoginService;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

//    @Autowired
//    private SysUserService sysUserService;
//    不建议,每个Service都有单独的业务

    @Autowired
    private LoginService loginService;

    @RequestMapping
    public Result login(@RequestBody LoginParam loginParam){
        //登陆验证用户 访问用户表
        return loginService.login(loginParam);

    }

}

