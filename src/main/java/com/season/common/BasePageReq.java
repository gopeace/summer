package com.season.common;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/24 14:34
 */
public class BasePageReq implements IPageReq {
    /**
     * 起始条数（从0开始），与页码选填其一
     * 注：如果{@link BasePageReq#pageNo}和本字段均有值，则以本字段为准
     *
     * @see BasePageReq#pageNo
     */
    @Min(0)
    private Integer offset;

    /**
     * 页码（从1开始），与起始条数选填其一
     * 注：如果{@link BasePageReq#offset}和本字段均有值，则以{@link BasePageReq#offset}为准
     *
     * @see BasePageReq#offset
     */
    @Min(1)
    private Integer pageNo;

    /**
     * 每页多少条（页大小）（必填）
     */
    @NotNull
    @Min(1)
    private Integer pageSize;

    @Override
    public Integer getOffset() {
        return offset;
    }

    @Override
    public Integer getPageNo() {
        return pageNo;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
