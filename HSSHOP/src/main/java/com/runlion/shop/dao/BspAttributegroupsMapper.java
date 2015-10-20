package com.runlion.shop.dao;

import com.runlion.shop.entity.BspAttributegroups;
import com.runlion.shop.entity.BspAttributegroupsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BspAttributegroupsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_attributegroups
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int countByExample(BspAttributegroupsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_attributegroups
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int deleteByExample(BspAttributegroupsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_attributegroups
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int deleteByPrimaryKey(Short attrgroupid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_attributegroups
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int insert(BspAttributegroups record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_attributegroups
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int insertSelective(BspAttributegroups record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_attributegroups
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    List<BspAttributegroups> selectByExample(BspAttributegroupsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_attributegroups
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    BspAttributegroups selectByPrimaryKey(Short attrgroupid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_attributegroups
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int updateByExampleSelective(@Param("record") BspAttributegroups record, @Param("example") BspAttributegroupsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_attributegroups
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int updateByExample(@Param("record") BspAttributegroups record, @Param("example") BspAttributegroupsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_attributegroups
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int updateByPrimaryKeySelective(BspAttributegroups record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_attributegroups
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int updateByPrimaryKey(BspAttributegroups record);

	List<BspAttributegroups> getAttributegrouplist(Short cateid);

	BspAttributegroups getAttributegroup(Short id);

	int deleteAttributegroup(Short id);
}