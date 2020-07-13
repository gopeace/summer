package com.season.entity;

import java.io.Serializable;

/**
 * @decription:
 * @author: zhixian.lin@luckincoffee.com
 * @date: 2020/7/13 13:48
 */
public class SubclassAO implements Serializable {

    private static final long serialVersionUID = 678846675480279756L;

    private Integer id;

    private Integer catagoryId;
    private String name;
    private String desc;
    private Float credit;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(Integer catagoryId) {
        this.catagoryId = catagoryId;
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

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SubclassAO{" +
                "id=" + id +
                ", catagoryId=" + catagoryId +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", credit=" + credit +
                ", userId=" + userId +
                '}';
    }
}
