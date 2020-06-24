package com.season.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/23 17:44
 */
public class RegisterInfoAO implements Serializable {
    @NotNull
    private String loginName;

    @NotNull
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
        return "RegisterInfoAO{" +
                "loginName='" + loginName + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
