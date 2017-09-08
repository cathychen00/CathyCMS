package com.data.pojo;

import java.io.Serializable;
import java.util.Date;

public class CmsRole implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_role.role_id
     *
     * @mbg.generated
     */
    private Integer roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_role.audit_flag
     *
     * @mbg.generated
     */
    private String auditFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_role.create_date
     *
     * @mbg.generated
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_role.delete_flag
     *
     * @mbg.generated
     */
    private String deleteFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_role.update_date
     *
     * @mbg.generated
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_role.code
     *
     * @mbg.generated
     */
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_role.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_role.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_role.no
     *
     * @mbg.generated
     */
    private Integer no;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_role.role_name
     *
     * @mbg.generated
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_role.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cms_role
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_role.role_id
     *
     * @return the value of cms_role.role_id
     *
     * @mbg.generated
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_role.role_id
     *
     * @param roleId the value for cms_role.role_id
     *
     * @mbg.generated
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_role.audit_flag
     *
     * @return the value of cms_role.audit_flag
     *
     * @mbg.generated
     */
    public String getAuditFlag() {
        return auditFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_role.audit_flag
     *
     * @param auditFlag the value for cms_role.audit_flag
     *
     * @mbg.generated
     */
    public void setAuditFlag(String auditFlag) {
        this.auditFlag = auditFlag == null ? null : auditFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_role.create_date
     *
     * @return the value of cms_role.create_date
     *
     * @mbg.generated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_role.create_date
     *
     * @param createDate the value for cms_role.create_date
     *
     * @mbg.generated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_role.delete_flag
     *
     * @return the value of cms_role.delete_flag
     *
     * @mbg.generated
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_role.delete_flag
     *
     * @param deleteFlag the value for cms_role.delete_flag
     *
     * @mbg.generated
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_role.update_date
     *
     * @return the value of cms_role.update_date
     *
     * @mbg.generated
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_role.update_date
     *
     * @param updateDate the value for cms_role.update_date
     *
     * @mbg.generated
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_role.code
     *
     * @return the value of cms_role.code
     *
     * @mbg.generated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_role.code
     *
     * @param code the value for cms_role.code
     *
     * @mbg.generated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_role.description
     *
     * @return the value of cms_role.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_role.description
     *
     * @param description the value for cms_role.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_role.name
     *
     * @return the value of cms_role.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_role.name
     *
     * @param name the value for cms_role.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_role.no
     *
     * @return the value of cms_role.no
     *
     * @mbg.generated
     */
    public Integer getNo() {
        return no;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_role.no
     *
     * @param no the value for cms_role.no
     *
     * @mbg.generated
     */
    public void setNo(Integer no) {
        this.no = no;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_role.role_name
     *
     * @return the value of cms_role.role_name
     *
     * @mbg.generated
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_role.role_name
     *
     * @param roleName the value for cms_role.role_name
     *
     * @mbg.generated
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_role.status
     *
     * @return the value of cms_role.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_role.status
     *
     * @param status the value for cms_role.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", auditFlag=").append(auditFlag);
        sb.append(", createDate=").append(createDate);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", code=").append(code);
        sb.append(", description=").append(description);
        sb.append(", name=").append(name);
        sb.append(", no=").append(no);
        sb.append(", roleName=").append(roleName);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}