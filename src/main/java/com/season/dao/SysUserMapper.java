package com.season.dao;

import com.season.model.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    long insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByUserName(String userName);

    SysUser selectByPhone(String phoneNumber);
}