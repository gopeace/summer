package com.season.service;

import com.season.common.PageResult;
import com.season.common.Result;
import com.season.entity.AddEventRecordAO;
import com.season.entity.ModifyEventRecordAO;
import com.season.entity.QueryEventRecordAO;
import com.season.entity.dto.EventRecordDTO;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/24 11:26
 */
@Deprecated
public interface EventRecordService {
    /**
     * 新增记录
     * @param addEventRecordAO
     * @return
     */
    Result<Integer> addEventRecord(AddEventRecordAO addEventRecordAO);

    /**
     * 修改记录
     * @param modifyEventRecordAO
     * @return
     */
    Result<Boolean> updateEventRecord(ModifyEventRecordAO modifyEventRecordAO);

    /**
     * 删除记录
     * @param eventId
     * @return
     */
    Result<Boolean> deleteEventRecord(Integer eventId);

    /**
     * 查询记录列表
     * @param queryEventRecordAO
     * @return
     */
    Result<PageResult<EventRecordDTO>> listEventRecord(QueryEventRecordAO queryEventRecordAO);
}
