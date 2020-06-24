package com.season.model;

import java.util.Date;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/24 15:02
 */
public class QueryEventRecordCondition extends BasePageCondition {
    private Integer userId;
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
}
