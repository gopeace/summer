package com.season.common;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/24 14:33
 */
public interface IPageReq {
    /**
     * 起始条数（从0开始），与页码选填其一
     *
     * @return 起始条数
     */
    Integer getOffset();

    /**
     * 页码（从1开始），与起始条数选填其一
     *
     * @return 页码
     */
    Integer getPageNo();

    /**
     * 每页多少条（页大小）（必填）
     *
     * @return 页大小
     */
    Integer getPageSize();
}
