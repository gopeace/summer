package com.season.service.impl;

import com.google.common.collect.Lists;
import com.season.common.CodeMsgEnum;
import com.season.common.Result;
import com.season.dao.EventSubclassMapper;
import com.season.entity.SubclassAO;
import com.season.entity.dto.SubclassDTO;
import com.season.model.EventSubclass;
import com.season.service.SubclassService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * @decription:
 * @author: zhixian.lin@luckincoffee.com
 * @date: 2020/7/13 13:56
 */
@Service
public class SubclassServiceImpl implements SubclassService {
    @Autowired
    private EventSubclassMapper eventSubclassMapper;

    @Override
    public Result<Integer> addSubclass(SubclassAO subclassAO) {
        Assert.notNull(subclassAO.getCatagoryId(), "新建子类父类不能为空");
        Assert.notNull(subclassAO.getName(), "子类名称不能为空");
        Assert.isTrue(subclassAO.getCredit() != null && subclassAO.getCredit() > 0, "子类分值需要大于0");

        EventSubclass eventSubclass = convert(subclassAO, true);

        int subclassId = eventSubclassMapper.insertSelective(eventSubclass);
        if (subclassId < 0) {
            return Result.error(CodeMsgEnum.ADD_RECORD_ERROR);
        }
        return Result.success(subclassId);
    }

    @Override
    public Result<Boolean> updateSubclass(SubclassAO subclassAO) {
        EventSubclass eventCatogory = convert(subclassAO, false);

        int count = eventSubclassMapper.updateByPrimaryKeySelective(eventCatogory);
        if (count <= 0) {
            return Result.error(CodeMsgEnum.MODIFY_RECORD_ERROR);
        }
        return Result.success(true);
    }

    @Override
    public Result<Boolean> deleteSubclass(Integer subclassId) {
        int count = eventSubclassMapper.logicDeleteByPrimaryKey(subclassId);
        if (count <= 0) {
            return Result.error(CodeMsgEnum.MODIFY_RECORD_ERROR);
        }
        return Result.success(true);
    }

    @Override
    public Result<List<SubclassDTO>> listSubclasses(Integer catagoryId) {
        List<EventSubclass> eventSubclasses = eventSubclassMapper.queryListByCatagoryId(catagoryId);

        List<SubclassDTO> subclassDTOS = Lists.newArrayList();
        if (eventSubclasses == null) {
            return Result.error(CodeMsgEnum.QUERY_RECORD_ERROR);
        }

        for (EventSubclass eventSubclass : eventSubclasses) {
            SubclassDTO subclassDTO = new SubclassDTO();
            BeanUtils.copyProperties(eventSubclass, subclassDTO);
            subclassDTOS.add(subclassDTO);
        }
        return Result.success(subclassDTOS);
    }

    private EventSubclass convert(SubclassAO subclassAO, boolean created) {
        EventSubclass eventSubclass = new EventSubclass();

        if (subclassAO.getId() != null && subclassAO.getId() > 0) {
            eventSubclass.setId(subclassAO.getId());
        }
        eventSubclass.setName(subclassAO.getName());
        eventSubclass.setDescription(subclassAO.getDesc());
        eventSubclass.setCatagoryId(subclassAO.getCatagoryId());
        eventSubclass.setCredit(subclassAO.getCredit());

        if (created) {
            eventSubclass.setCreateTime(new Date());
            eventSubclass.setCreateUser(subclassAO.getUserId());
        } else {
            eventSubclass.setUpdateTime(new Date());
            eventSubclass.setUpdateUser(subclassAO.getUserId());
        }

        return eventSubclass;
    }
}
