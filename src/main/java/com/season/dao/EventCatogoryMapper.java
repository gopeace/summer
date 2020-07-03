package com.season.dao;

import com.season.model.EventCatogory;

public interface EventCatogoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EventCatogory record);

    int insertSelective(EventCatogory record);

    EventCatogory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EventCatogory record);

    int updateByPrimaryKey(EventCatogory record);
}