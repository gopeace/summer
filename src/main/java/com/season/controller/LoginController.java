package com.season.controller;

import com.season.common.CodeMsgEnum;
import com.season.common.Result;
import com.season.entity.UserInfoAO;
import com.season.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @decription:
 * @author: season
 * @date: 2020/7/13 9:59
 */
@RequestMapping("/verify/")
@Controller
public class LoginController {
    private static final String  USER_SESSION_NAME= "user";

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public Result loginCheck(HttpServletRequest request, HttpServletResponse response, UserInfoAO user){
        try {
            if(loginService.loginCheck(user)){
               //TODO: 保存会话、cookie等
            }else {
                throw new RuntimeException("账户或者密码有误!");
            }
        }catch (Exception e){
            System.out.println("登录错误:" + e.getMessage());
            return Result.error(CodeMsgEnum.LOGIN_ERROR);
        }
        return Result.success();
    }

    @RequestMapping(value = "/loginOut")
    @ResponseBody
    public Result loginOut(HttpServletRequest request,HttpServletResponse response){
        try {
            //TODO：清空cookie, 使会话失效
            return Result.success();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Result.error(CodeMsgEnum.LOGOUT_ERROR);
        }
    }

    private void saveSession(UserInfoAO user, HttpServletRequest request){
        request.getSession().setAttribute(USER_SESSION_NAME, user);
    }

    private void invalidateSession(HttpServletRequest request){
        request.getSession().invalidate();
    }

}
