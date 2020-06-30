package com.season.entity;

import com.season.common.ScoreEnum;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/24 13:43
 */
public class AddEventRecordAO implements Serializable {

    private static final long serialVersionUID = 1290470471913209654L;

    @NotNull
    private Integer userId;
    @NotNull
    private String event;
    private String desc;
    @NotNull
    private Double score;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "AddEventRecordAO{" +
                "userId=" + userId +
                ", event='" + event + '\'' +
                ", desc='" + desc + '\'' +
                ", score=" + score +
                '}';
    }
}
