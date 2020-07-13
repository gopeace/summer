package com.season.entity;

import java.io.Serializable;

/**
 * @decription:
 * @author: season
 * @date: 2020/7/13 9:49
 */
public class UserInfoAO implements Serializable {
    private String userName;
    private String password;
    private String loginType;
    private Boolean rememberLogin;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public Boolean getRememberLogin() {
        return rememberLogin;
    }

    public void setRememberLogin(Boolean rememberLogin) {
        this.rememberLogin = rememberLogin;
    }
}
