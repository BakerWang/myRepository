package com.runlion.shop.dao;

import com.runlion.shop.entity.BspAdminuser;
import com.runlion.shop.entity.BspAdminuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BspAdminuserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_adminuser
     *
     * @mbggenerated Mon Jun 29 11:41:53 CST 2015
     */
    int countByExample(BspAdminuserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_adminuser
     *
     * @mbggenerated Mon Jun 29 11:41:53 CST 2015
     */
    int deleteByExample(BspAdminuserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_adminuser
     *
     * @mbggenerated Mon Jun 29 11:41:53 CST 2015
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_adminuser
     *
     * @mbggenerated Mon Jun 29 11:41:53 CST 2015
     */
    int insert(BspAdminuser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_adminuser
     *
     * @mbggenerated Mon Jun 29 11:41:53 CST 2015
     */
    int insertSelective(BspAdminuser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_adminuser
     *
     * @mbggenerated Mon Jun 29 11:41:53 CST 2015
     */
    List<BspAdminuser> selectByExample(BspAdminuserExample example);
    /**
     * 通过关键词进行模糊查询
     * @param keyWord
     * @return
     */
    List<BspAdminuser> selectByKeyWord(String keyWord);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_adminuser
     *
     * @mbggenerated Mon Jun 29 11:41:53 CST 2015
     */
    BspAdminuser selectByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_adminuser
     *
     * @mbggenerated Mon Jun 29 11:41:53 CST 2015
     */
    int updateByExampleSelective(@Param("record") BspAdminuser record, @Param("example") BspAdminuserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_adminuser
     *
     * @mbggenerated Mon Jun 29 11:41:53 CST 2015
     */
    int updateByExample(@Param("record") BspAdminuser record, @Param("example") BspAdminuserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_adminuser
     *
     * @mbggenerated Mon Jun 29 11:41:53 CST 2015
     */
    int updateByPrimaryKeySelective(BspAdminuser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_adminuser
     *
     * @mbggenerated Mon Jun 29 11:41:53 CST 2015
     */
    int updateByPrimaryKey(BspAdminuser record);
}