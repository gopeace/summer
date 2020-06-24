package com.season.dao;

import com.season.model.EventRecord;
import com.season.model.QueryEventRecordCondition;

import java.util.List;

public interface EventRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EventRecord record);

    int insertSelective(EventRecord record);

    EventRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EventRecord record);

    int updateByPrimaryKey(EventRecord record);

    List<EventRecord> queryListByCondition(QueryEventRecordCondition queryEventRecordCondition);

    int getTotalByCondition(QueryEventRecordCondition queryEventRecordCondition);
}