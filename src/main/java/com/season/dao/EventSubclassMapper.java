package com.season.dao;

import com.season.model.EventSubclass;

import java.util.List;

public interface EventSubclassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EventSubclass record);

    int insertSelective(EventSubclass record);

    EventSubclass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EventSubclass record);

    int updateByPrimaryKey(EventSubclass record);

    int logicDeleteByPrimaryKey(Integer id);

    List<EventSubclass> queryListByCatagoryId(Integer catagoryId);
}