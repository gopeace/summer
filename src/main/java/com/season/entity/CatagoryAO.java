package com.season.entity;

import java.io.Serializable;

/**
 * @decription:
 * @author: season
 * @date: 2020/7/3 10:46
 */
public class CatagoryAO implements Serializable {

    private static final long serialVersionUID = -7308464870307153321L;

    private Integer id;

    private String name;
    private String desc;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CatagoryAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", userId=" + userId +
                '}';
    }
}
