package com.season.common;

import java.io.Serializable;
import java.util.List;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/24 14:36
 */
public class PageResult<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 5698366906831294949L;


    /**
     * 符合条件的总数
     */
    private int total;
    /**
     * 当前页面大小
     */
    private int currentPageSize;
    /**
     * 数据量
     */
    private List<T> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrentPageSize() {
        return currentPageSize;
    }

    public void setCurrentPageSize(int currentPageSize) {
        this.currentPageSize = currentPageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
