package com.data.pojo;

import java.io.Serializable;
import java.util.Date;

public class CmsResource implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_resource.resource_id
     *
     * @mbg.generated
     */
    private Integer resourceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_resource.resource_name
     *
     * @mbg.generated
     */
    private String resourceName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_resource.audit_flag
     *
     * @mbg.generated
     */
    private String auditFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_resource.create_date
     *
     * @mbg.generated
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_resource.delete_flag
     *
     * @mbg.generated
     */
    private String deleteFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_resource.update_date
     *
     * @mbg.generated
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_resource.icon
     *
     * @mbg.generated
     */
    private String icon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_resource.order_no
     *
     * @mbg.generated
     */
    private Integer orderNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_resource.type
     *
     * @mbg.generated
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_resource.url
     *
     * @mbg.generated
     */
    private String url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_resource.parent_id
     *
     * @mbg.generated
     */
    private Integer parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cms_resource
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_resource.resource_id
     *
     * @return the value of cms_resource.resource_id
     *
     * @mbg.generated
     */
    public Integer getResourceId() {
        return resourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_resource.resource_id
     *
     * @param resourceId the value for cms_resource.resource_id
     *
     * @mbg.generated
     */
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_resource.resource_name
     *
     * @return the value of cms_resource.resource_name
     *
     * @mbg.generated
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_resource.resource_name
     *
     * @param resourceName the value for cms_resource.resource_name
     *
     * @mbg.generated
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_resource.audit_flag
     *
     * @return the value of cms_resource.audit_flag
     *
     * @mbg.generated
     */
    public String getAuditFlag() {
        return auditFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_resource.audit_flag
     *
     * @param auditFlag the value for cms_resource.audit_flag
     *
     * @mbg.generated
     */
    public void setAuditFlag(String auditFlag) {
        this.auditFlag = auditFlag == null ? null : auditFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_resource.create_date
     *
     * @return the value of cms_resource.create_date
     *
     * @mbg.generated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_resource.create_date
     *
     * @param createDate the value for cms_resource.create_date
     *
     * @mbg.generated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_resource.delete_flag
     *
     * @return the value of cms_resource.delete_flag
     *
     * @mbg.generated
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_resource.delete_flag
     *
     * @param deleteFlag the value for cms_resource.delete_flag
     *
     * @mbg.generated
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_resource.update_date
     *
     * @return the value of cms_resource.update_date
     *
     * @mbg.generated
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_resource.update_date
     *
     * @param updateDate the value for cms_resource.update_date
     *
     * @mbg.generated
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_resource.icon
     *
     * @return the value of cms_resource.icon
     *
     * @mbg.generated
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_resource.icon
     *
     * @param icon the value for cms_resource.icon
     *
     * @mbg.generated
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_resource.order_no
     *
     * @return the value of cms_resource.order_no
     *
     * @mbg.generated
     */
    public Integer getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_resource.order_no
     *
     * @param orderNo the value for cms_resource.order_no
     *
     * @mbg.generated
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_resource.type
     *
     * @return the value of cms_resource.type
     *
     * @mbg.generated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_resource.type
     *
     * @param type the value for cms_resource.type
     *
     * @mbg.generated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_resource.url
     *
     * @return the value of cms_resource.url
     *
     * @mbg.generated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_resource.url
     *
     * @param url the value for cms_resource.url
     *
     * @mbg.generated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_resource.parent_id
     *
     * @return the value of cms_resource.parent_id
     *
     * @mbg.generated
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_resource.parent_id
     *
     * @param parentId the value for cms_resource.parent_id
     *
     * @mbg.generated
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_resource
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resourceId=").append(resourceId);
        sb.append(", resourceName=").append(resourceName);
        sb.append(", auditFlag=").append(auditFlag);
        sb.append(", createDate=").append(createDate);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", icon=").append(icon);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", type=").append(type);
        sb.append(", url=").append(url);
        sb.append(", parentId=").append(parentId);
        sb.append("]");
        return sb.toString();
    }
}