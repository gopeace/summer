package com.season.dao;

import com.season.model.EventCheckin;

public interface EventCheckinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EventCheckin record);

    int insertSelective(EventCheckin record);

    EventCheckin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EventCheckin record);

    int updateByPrimaryKey(EventCheckin record);
}