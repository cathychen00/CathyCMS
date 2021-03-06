package com.data.mapper;

import com.data.pojo.CmsChannel;
import com.data.pojo.CmsChannelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CmsChannelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_channel
     *
     * @mbg.generated
     */
    long countByExample(CmsChannelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_channel
     *
     * @mbg.generated
     */
    int deleteByExample(CmsChannelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_channel
     *
     * @mbg.generated
     */
    void insert(CmsChannel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_channel
     *
     * @mbg.generated
     */
    int insertSelective(CmsChannel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_channel
     *
     * @mbg.generated
     */
    List<CmsChannel> selectByExampleWithRowbounds(CmsChannelCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_channel
     *
     * @mbg.generated
     */
    List<CmsChannel> selectByExample(CmsChannelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_channel
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CmsChannel record, @Param("example") CmsChannelCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_channel
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CmsChannel record, @Param("example") CmsChannelCriteria example);

    int updateByPrimaryKey(@Param("record") CmsChannel channel);
}