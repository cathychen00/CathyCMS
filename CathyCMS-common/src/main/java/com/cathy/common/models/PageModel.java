package com.cathy.common.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 陈敬 on 17/9/21.
 */
public class PageModel<T> implements Serializable {

    private Integer totalCount; //总记录数

    private Integer pageSize = 10; //每页显示的数量

    private Integer totalPage; //总页数

    private Integer pageIndex = 1; //当前页数

    private List<T> items; //分页集合列表

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null || pageSize < 1) {
            this.pageSize = 1;
        } else {
            this.pageSize = pageSize;
        }
    }

    public Integer getTotalPage() {
        if (totalCount % pageSize == 0) {
            return totalCount / pageSize;
        } else {
            return totalCount / pageSize + 1;
        }
    }


    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        if (pageIndex == null || pageIndex < 1) {
            this.pageIndex = 1;
        } else {
            this.pageIndex = pageIndex;
        }
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}