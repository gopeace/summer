package com.season.model;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/24 15:02
 */
public class BasePageCondition {
    /**
     * 起始条数（从0开始），与页码选填其一
     */
    private Integer offset;
    /**
     * 每页多少条（页大小）（必填）
     */
    private Integer pageSize;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
