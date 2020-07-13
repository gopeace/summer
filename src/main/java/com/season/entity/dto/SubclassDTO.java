package com.season.entity.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @decription:
 * @author: zhixian.lin@luckincoffee.com
 * @date: 2020/7/13 13:54
 */
public class SubclassDTO implements Serializable {
    private Integer id;

    private Integer catagoryId;
    private String name;
    private String desc;
    private Double credit;

    private Date createTime;
    private Integer createUser;
    private Date updateTime;
    private Integer updateUser;

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

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "SubclassDTO{" +
                "id=" + id +
                ", catagoryId=" + catagoryId +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", credit=" + credit +
                ", createTime=" + createTime +
                ", createUser=" + createUser +
                ", updateTime=" + updateTime +
                ", updateUser=" + updateUser +
                '}';
    }
}
