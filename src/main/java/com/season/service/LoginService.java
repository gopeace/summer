package com.season.service;

import com.season.entity.UserInfoAO;

/**
 * @decription: ldap登录校验服务
 * @author: season
 * @date: 2020/7/13 9:50
 */
public interface LoginService {
    /**
     * 登录校验
     * @param userInfoAO 用户信息
     * @return 校验成功返回true, 否则返回false
     */
    Boolean loginCheck(UserInfoAO userInfoAO);
}
