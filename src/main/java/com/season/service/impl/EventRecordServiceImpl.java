package com.season.service.impl;

import com.google.common.collect.Lists;
import com.season.common.CodeMsgEnum;
import com.season.common.PageResult;
import com.season.common.Result;
import com.season.dao.EventRecordMapper;
import com.season.entity.AddEventRecordAO;
import com.season.entity.ModifyEventRecordAO;
import com.season.entity.QueryEventRecordAO;
import com.season.entity.dto.EventRecordDTO;
import com.season.model.EventRecord;
import com.season.model.QueryEventRecordCondition;
import com.season.service.EventRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/24 13:47
 */
@Service
public class EventRecordServiceImpl implements EventRecordService {
    @Autowired
    private EventRecordMapper eventRecordMapper;

    @Override
    public Result<Integer> addEventRecord(AddEventRecordAO addEventRecordAO) {
        EventRecord record = convert(addEventRecordAO);

        int recordId = eventRecordMapper.insertSelective(record);
        if (recordId < 0) {
            return Result.error(CodeMsgEnum.ADD_RECORD_ERROR);
        }

        return Result.success(recordId);
    }

    @Override
    public Result<Boolean> updateEventRecord(ModifyEventRecordAO modifyEventRecordAO) {
        EventRecord record = convert(modifyEventRecordAO);

        int count = eventRecordMapper.updateByPrimaryKeySelective(record);
        if (count <= 0) {
            return Result.error(CodeMsgEnum.MODIFY_RECORD_ERROR);
        }
        return Result.success(Boolean.TRUE);
    }

    @Override
    public Result<Boolean> deleteEventRecord(Integer eventId) {
        int delete = eventRecordMapper.deleteByPrimaryKey(eventId);
        if (delete <= 0) {
            return Result.error(CodeMsgEnum.DELETE_RECORD_ERROR);
        }

        return Result.success(Boolean.TRUE);
    }

    @Override
    public Result<PageResult<EventRecordDTO>> listEventRecord(QueryEventRecordAO queryEventRecordAO) {
        QueryEventRecordCondition condition = convert(queryEventRecordAO);

        int count = eventRecordMapper.getTotalByCondition(condition);
        if (count < 0) {
            return Result.error(CodeMsgEnum.QUERY_RECORD_ERROR);
        }

        List<EventRecordDTO> recordList = Lists.newArrayList();
        PageResult<EventRecordDTO> pageRecordList = new PageResult<EventRecordDTO>();

        if (count == 0) {
            pageRecordList.setTotal(0);
            pageRecordList.setCurrentPageSize(queryEventRecordAO.getPageSize());
            pageRecordList.setList(recordList);

            return Result.success(pageRecordList);
        }

        int offset = queryEventRecordAO.getPageNo() < 1 ? 0 : (queryEventRecordAO.getPageNo() - 1) * queryEventRecordAO.getPageSize();

        condition.setOffset(offset);
        condition.setPageSize(queryEventRecordAO.getPageSize());

        List<EventRecord> eventRecords = eventRecordMapper.queryListByCondition(condition);
        if (eventRecords == null) {

        }

        for (EventRecord record : eventRecords) {
            EventRecordDTO eventRecordDTO = new EventRecordDTO();
            BeanUtils.copyProperties(record, eventRecordDTO);

            recordList.add(eventRecordDTO);
        }

        pageRecordList.setTotal(count);
        pageRecordList.setCurrentPageSize(queryEventRecordAO.getPageSize());
        pageRecordList.setList(recordList);

        return Result.success(pageRecordList);
    }

    private EventRecord convert(AddEventRecordAO addEventRecordAO) {
        EventRecord record = new EventRecord();
        record.setEvent(addEventRecordAO.getEvent());
        record.setDesc(addEventRecordAO.getDesc());
        record.setUserId(addEventRecordAO.getUserId());
        record.setScore(addEventRecordAO.getScore().getScore());
        record.setCreateTime(new Date());
        record.setCreateUser(addEventRecordAO.getUserId());

        return record;
    }

    private EventRecord convert(ModifyEventRecordAO modifyEventRecordAO) {
        EventRecord record = new EventRecord();
        record.setId(modifyEventRecordAO.getId());
        record.setEvent(modifyEventRecordAO.getEvent());
        record.setDesc(modifyEventRecordAO.getDesc());
        record.setScore(modifyEventRecordAO.getScore().getScore());
        record.setUpdateUser(modifyEventRecordAO.getModifier());
        record.setUpdateTime(new Date());

        return record;
    }

    private QueryEventRecordCondition convert(QueryEventRecordAO queryEventRecordAO) {
        QueryEventRecordCondition condition = new QueryEventRecordCondition();
        condition.setUserId(queryEventRecordAO.getUserId());
        condition.setCreateTime(queryEventRecordAO.getCreateTime());

        return condition;
    }
}
