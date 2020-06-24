package com.season.controller;

import com.season.common.Result;
import com.season.entity.LoginForm;
import com.season.entity.RegisterInfoAO;
import com.season.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/23 17:25
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result userRegister(@Validated @RequestBody RegisterInfoAO registerInfoAO) {
        return userService.register(registerInfoAO);
    }

    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginForm loginForm) {
        return userService.loginAuth(loginForm);
    }

}
