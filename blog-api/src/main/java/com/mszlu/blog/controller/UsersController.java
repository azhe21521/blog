package com.mszlu.blog.controller;


import com.mszlu.blog.service.SysUserService;
import com.mszlu.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("currentUser")
    public Result currentUser(@RequestHeader("") String token) {
        return sysUserService.findUserByToken(token);
    }

}
