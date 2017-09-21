package com.data.model;

/**
 * Created by 陈敬 on 17/9/21.
 */
public class UserQueryDTO {
    private Integer pageIndex=1;
    private Integer pageSize=10;
    private String username;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
