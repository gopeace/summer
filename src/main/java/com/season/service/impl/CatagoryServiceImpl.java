package com.season.service.impl;

import com.google.common.collect.Lists;
import com.season.common.CodeMsgEnum;
import com.season.common.Result;
import com.season.dao.EventCatogoryMapper;
import com.season.entity.CatagoryAO;
import com.season.entity.dto.CatagoryDTO;
import com.season.model.EventCatogory;
import com.season.service.CatagoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @decription:
 * @author: season
 * @date: 2020/7/3 10:56
 */
@Service
public class CatagoryServiceImpl implements CatagoryService {
    @Autowired
    private EventCatogoryMapper eventCatogoryMapper;

    @Override
    public Result<Integer> addCatagory(CatagoryAO catagoryAO) {
        EventCatogory eventCatogory = convert(catagoryAO, true);

        int catagoryId = eventCatogoryMapper.insertSelective(eventCatogory);
        if (catagoryId < 0) {
            return Result.error(CodeMsgEnum.ADD_RECORD_ERROR);
        }
        return Result.success(catagoryId);
    }

    @Override
    public Result<Boolean> updateCatagory(CatagoryAO catagoryAO) {
        EventCatogory eventCatogory = convert(catagoryAO, false);

        int count = eventCatogoryMapper.updateByPrimaryKeySelective(eventCatogory);
        if (count <= 0) {
            return Result.error(CodeMsgEnum.MODIFY_RECORD_ERROR);
        }
        return Result.success(true);
    }

    @Override
    public Result<Boolean> deleteCatagory(Integer catagoryId) {
        int count = eventCatogoryMapper.logicDeleteByPrimaryKey(catagoryId);
        if (count <= 0) {
            return Result.error(CodeMsgEnum.MODIFY_RECORD_ERROR);
        }
        return Result.success(true);
    }

    @Override
    public Result<List<CatagoryDTO>> listCatagory() {
        List<EventCatogory> eventCatogories = eventCatogoryMapper.queryList();

        List<CatagoryDTO> catagoryDTOList = Lists.newArrayList();
        if (eventCatogories == null || catagoryDTOList.isEmpty()) {
            return Result.error(CodeMsgEnum.QUERY_RECORD_ERROR);
        }

        for (EventCatogory eventCatogory : eventCatogories) {
            CatagoryDTO catagoryDTO = new CatagoryDTO();
            BeanUtils.copyProperties(eventCatogory, catagoryDTO);
            catagoryDTOList.add(catagoryDTO);
        }
        return Result.success(catagoryDTOList);
    }

    private EventCatogory convert(CatagoryAO catagoryAO, boolean created) {
        EventCatogory eventCatogory = new EventCatogory();

        if (catagoryAO.getId() != null && catagoryAO.getId() > 0) {
            eventCatogory.setId(catagoryAO.getId());
        }
        eventCatogory.setName(catagoryAO.getName());
        eventCatogory.setDesc(catagoryAO.getDesc());
        if (created) {
            eventCatogory.setCreateTime(new Date());
            eventCatogory.setCreateUser(catagoryAO.getUserId());
        } else {
            eventCatogory.setUpdateTime(new Date());
            eventCatogory.setUpdateUser(catagoryAO.getUserId());
        }

        return eventCatogory;
    }
}
