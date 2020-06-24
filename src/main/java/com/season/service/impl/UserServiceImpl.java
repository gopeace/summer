package com.season.service.impl;

import com.season.common.CodeMsgEnum;
import com.season.common.Result;
import com.season.common.UserStatusEnum;
import com.season.dao.SysUserMapper;
import com.season.entity.LoginForm;
import com.season.entity.RegisterInfoAO;
import com.season.entity.dto.UserInfoDTO;
import com.season.model.SysUser;
import com.season.service.UserService;
import com.season.util.PasswordUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/23 17:56
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public Result<UserInfoDTO> register(RegisterInfoAO registerInfoAO) {
        // step1: check if user name has been registered
        SysUser sysUser = sysUserMapper.selectByUserName(registerInfoAO.getLoginName());
        if (sysUser != null) {
            return Result.error(CodeMsgEnum.USER_REGISTERED);
        }

        // step2: check if phone number has been registerd
        sysUser = sysUserMapper.selectByPhone(registerInfoAO.getPhone());
        if (sysUser != null) {
            return Result.error(CodeMsgEnum.PHONE_REGISTERED);
        }

        // step3: register
        String salt = PasswordUtils.newSalt();
        String encryptPassword = PasswordUtils.encrypt(salt, registerInfoAO.getPassword());

        SysUser user = new SysUser();
        user.setSalt(salt);
        user.setPassword(encryptPassword);
        user.setUserName(registerInfoAO.getLoginName());
        user.setPhoneNumber(registerInfoAO.getPhone());
        user.setStatus(UserStatusEnum.NORMAL.getStatus());
        user.setCreateTime(new Date());

        long userId = sysUserMapper.insert(user);
        if (userId <= 0) {
            return Result.error(CodeMsgEnum.REGISTER_EXCEPTION);
        }

        // step4: after register
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserId(userId);
        userInfoDTO.setStatus((int)UserStatusEnum.NORMAL.getStatus());
        userInfoDTO.setPhone(registerInfoAO.getPhone());
        userInfoDTO.setUserName(registerInfoAO.getLoginName());


        return Result.success(userInfoDTO);
    }

    @Override
    public Result<UserInfoDTO> loginAuth(LoginForm loginForm) {
        if (StringUtils.isEmpty(loginForm.getLoginName()) &&
            StringUtils.isEmpty(loginForm.getPhone())) {
            return Result.error(CodeMsgEnum.EMPTY_USER_AND_PHONE);

        }

        SysUser sysUser = null;

        if (StringUtils.isNotEmpty(loginForm.getLoginName())) {
           sysUser = sysUserMapper.selectByUserName(loginForm.getLoginName());
        }

        if (sysUser == null && StringUtils.isNotEmpty(loginForm.getPhone())) {
            sysUser = sysUserMapper.selectByPhone(loginForm.getPhone());
        }

        if (sysUser == null) {
            return Result.error(CodeMsgEnum.USER_NOT_EXIST);
        }

        boolean valid = PasswordUtils.valid(sysUser.getSalt(), loginForm.getPassword(), sysUser.getPassword());
        if (!valid) {
            return Result.error(CodeMsgEnum.PASSWORD_ERROR);
        }

        if (sysUser.getStatus() == UserStatusEnum.LOGOFF.getStatus()) {
            return Result.error(CodeMsgEnum.USER_LOGOFF);
        }

        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserId((long)sysUser.getId());
        userInfoDTO.setStatus((int)UserStatusEnum.NORMAL.getStatus());
        userInfoDTO.setPhone(sysUser.getPhoneNumber());
        userInfoDTO.setUserName(sysUser.getUserName());

        return Result.success(userInfoDTO);
    }
}
