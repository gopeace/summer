package com.season.entity;

import com.season.common.ScoreEnum;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/24 14:05
 */
public class ModifyEventRecordAO implements Serializable {

    private static final long serialVersionUID = 819452558322571882L;

    @NotNull
    private Integer id;

    private String event;
    private String desc;

    private ScoreEnum score;
    private Integer modifier;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public ScoreEnum getScore() {
        return score;
    }

    public void setScore(ScoreEnum score) {
        this.score = score;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return "ModifyEventRecordAO{" +
                "id=" + id +
                ", event='" + event + '\'' +
                ", desc='" + desc + '\'' +
                ", score=" + score +
                ", modifier=" + modifier +
                '}';
    }
}
