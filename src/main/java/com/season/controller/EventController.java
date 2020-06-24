package com.season.controller;

import com.season.common.Result;
import com.season.entity.AddEventRecordAO;
import com.season.entity.ModifyEventRecordAO;
import com.season.entity.QueryEventRecordAO;
import com.season.service.EventRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/24 11:25
 */
@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventRecordService eventRecordService;

    @PostMapping("/add")
    public Result addEventRecord(@Validated @RequestBody AddEventRecordAO addEventRecordAO) {
        return eventRecordService.addEventRecord(addEventRecordAO);
    }

    @PostMapping("/update")
    public Result updateEventRecord(@Validated @RequestBody ModifyEventRecordAO modifyEventRecordAO) {
        return eventRecordService.updateEventRecord(modifyEventRecordAO);
    }

    @PostMapping("/delete")
    public Result deleteEventRecord(@NotNull Integer eventId) {
        return eventRecordService.deleteEventRecord(eventId);
    }

    @PostMapping("/list")
    public Result listEventRecord(@Validated @RequestBody QueryEventRecordAO queryEventRecordAO) {
        return eventRecordService.listEventRecord(queryEventRecordAO);
    }
}
