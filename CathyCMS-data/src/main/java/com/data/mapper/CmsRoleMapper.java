package com.data.mapper;

import com.data.pojo.CmsRole;
import com.data.pojo.CmsRoleCriteria;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface CmsRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated
     */
    int insert(CmsRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated
     */
    int insertSelective(CmsRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated
     */
    List<CmsRole> selectByExampleWithRowbounds(CmsRoleCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated
     */
    List<CmsRole> selectByExample(CmsRoleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated
     */
    CmsRole selectByPrimaryKey(Integer roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CmsRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CmsRole record);
}