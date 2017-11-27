package com.cathy.cms.dto;

/**
 * Created by 陈敬 on 17/10/13.
 */
public class ArticleQueryDTO {
    private Boolean isAudit;
    private Boolean isDelete;
    private Boolean isTop;
    private Integer channel1;
    private Integer channel2;
    private String publishTimeStart;
    private String publishTimeEnd;
    private String publisher;
    private Integer adminId;
    private String title;
    private Integer pageSize;
    private Integer pageIndex;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Boolean getAudit() {
        return isAudit;
    }

    public void setAudit(Boolean audit) {
        isAudit = audit;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Boolean getTop() {
        return isTop;
    }

    public void setTop(Boolean top) {
        isTop = top;
    }

    public Integer getChannel1() {
        return channel1;
    }

    public void setChannel1(Integer channel1) {
        this.channel1 = channel1;
    }

    public Integer getChannel2() {
        return channel2;
    }

    public void setChannel2(Integer channel2) {
        this.channel2 = channel2;
    }

    public String getPublishTimeStart() {
        return publishTimeStart;
    }

    public void setPublishTimeStart(String publishTimeStart) {
        this.publishTimeStart = publishTimeStart;
    }

    public String getPublishTimeEnd() {
        return publishTimeEnd;
    }

    public void setPublishTimeEnd(String publishTimeEnd) {
        this.publishTimeEnd = publishTimeEnd;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
