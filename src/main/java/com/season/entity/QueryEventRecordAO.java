package com.season.entity;

import com.season.common.BasePageReq;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/24 14:41
 */
public class QueryEventRecordAO extends BasePageReq implements Serializable {

    private static final long serialVersionUID = -2931916973532326061L;

    @NotNull
    private Integer userId;

    /**
     * 如果传入此值，则查询该时间之后的记录
     */
    private Date createTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "QueryEventRecordAO{" +
                "userId=" + userId +
                ", createTime=" + createTime +
                '}';
    }
}
