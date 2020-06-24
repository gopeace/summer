package com.season.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/24 10:52
 */
public class LoginForm implements Serializable {
    private String loginName;
    private String phone;

    @NotNull
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "loginName='" + loginName + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
