package com.mszlu.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.mszlu.blog.dao.pojo.SysUser;
import com.mszlu.blog.service.LoginService;
import com.mszlu.blog.service.SysUserService;
import com.mszlu.blog.utils.JWTUtils;
import com.mszlu.blog.vo.ErrorCode;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.LoginParam;
import com.qiniu.util.Json;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class LoginServiceImp implements LoginService {
    private static final String salt = "lum!@#";

    @Autowired
    private SysUserService sysUserService;

    @Override
    public Result login(LoginParam loginParam) {
        String account = loginParam.getAccount();
        String password = loginParam.getPassword();
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            return Result.Fail(ErrorCode.ACCOUNT_PWD_NOT_EXIST.getCode(), ErrorCode.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }
        password = DigestUtils.md5Hex(password + salt);
        SysUser sysUser = sysUserService.findUser(account, password);
        if (sysUser == null) {
            return Result.Fail(ErrorCode.ACCOUNT_PWD_NOT_EXIST.getCode(), ErrorCode.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }
        String token = JWTUtils.createToken(sysUser.getId());

        return Result.success(token);

    }

    @Override
    public SysUser checkToken(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        if (stringObjectMap == null) {
            return null;
        }

        return null;
    }

    @Override
    public Result register(LoginParam loginParam) {
        String account = loginParam.getAccount();
        String nickname = loginParam.getNickname();
        String password = loginParam.getPassword();
        if(StringUtils.isBlank(account)||StringUtils.isBlank(nickname)||StringUtils.isBlank(password)){
            return Result.Fail(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMsg());
        }
       SysUser sysUser= sysUserService.findUserByAccount(account);
        if (sysUser != null) {
            return Result.Fail(ErrorCode.ACCOUNT_EXIST.getCode(), "账号已经被用了欧");
        }
        sysUser=new SysUser();
        sysUser.setAccount(account);
        sysUser.setNickname(nickname);
        sysUser.setPassword(DigestUtils.md5Hex(password+salt));
        sysUser.setCreateDate(System.currentTimeMillis());              //创建时间
        sysUser.setLastLogin(System.currentTimeMillis());               //最后登录时间
        sysUser.setAvatar("/static/img/logo.b3a48c0.png");              //头像
        sysUser.setAdmin(1);                                             //管理员权限
        sysUser.setDeleted(0);                                             //假删除
        sysUser.setSalt("");                                                //盐
        sysUser.setStatus("");                                              //状态
        sysUser.setEmail("");
        this.sysUserService.save(sysUser);
        String token = JWTUtils.createToken(sysUser.getId());

        return Result.success(token);
    }
}








