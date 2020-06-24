package com.season.service;

import com.season.common.Result;
import com.season.entity.LoginForm;
import com.season.entity.RegisterInfoAO;
import com.season.entity.dto.UserInfoDTO;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/23 17:50
 */
public interface UserService {
    /**
     * 用户注册服务
     * @param registerInfoAO
     * @return
     */
    Result<UserInfoDTO> register(RegisterInfoAO registerInfoAO);

    /**
     * 登录认证
     * @param loginForm
     * @return
     */
    Result<UserInfoDTO> loginAuth(LoginForm loginForm);
}
