package com.runlion.shop.dao;

import com.runlion.shop.entity.SysResource;
import com.runlion.shop.entity.SysResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_RESOURCE
     *
     * @mbggenerated Tue Sep 01 13:29:07 CST 2015
     */
    int countByExample(SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_RESOURCE
     *
     * @mbggenerated Tue Sep 01 13:29:07 CST 2015
     */
    int deleteByExample(SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_RESOURCE
     *
     * @mbggenerated Tue Sep 01 13:29:07 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_RESOURCE
     *
     * @mbggenerated Tue Sep 01 13:29:07 CST 2015
     */
    int insert(SysResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_RESOURCE
     *
     * @mbggenerated Tue Sep 01 13:29:07 CST 2015
     */
    int insertSelective(SysResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_RESOURCE
     *
     * @mbggenerated Tue Sep 01 13:29:07 CST 2015
     */
    List<SysResource> selectByExample(SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_RESOURCE
     *
     * @mbggenerated Tue Sep 01 13:29:07 CST 2015
     */
    SysResource selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_RESOURCE
     *
     * @mbggenerated Tue Sep 01 13:29:07 CST 2015
     */
    int updateByExampleSelective(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_RESOURCE
     *
     * @mbggenerated Tue Sep 01 13:29:07 CST 2015
     */
    int updateByExample(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_RESOURCE
     *
     * @mbggenerated Tue Sep 01 13:29:07 CST 2015
     */
    int updateByPrimaryKeySelective(SysResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_RESOURCE
     *
     * @mbggenerated Tue Sep 01 13:29:07 CST 2015
     */
    int updateByPrimaryKey(SysResource record);
}