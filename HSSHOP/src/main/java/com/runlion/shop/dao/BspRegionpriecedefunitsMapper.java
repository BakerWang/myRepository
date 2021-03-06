package com.runlion.shop.dao;

import com.runlion.shop.entity.BspRegionpriecedefunits;
import com.runlion.shop.entity.BspRegionpriecedefunitsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BspRegionpriecedefunitsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    int countByExample(BspRegionpriecedefunitsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    int deleteByExample(BspRegionpriecedefunitsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    int deleteByPrimaryKey(Integer keyid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    int insert(BspRegionpriecedefunits record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    int insertSelective(BspRegionpriecedefunits record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    List<BspRegionpriecedefunits> selectByExample(BspRegionpriecedefunitsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    BspRegionpriecedefunits selectByPrimaryKey(Integer keyid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    int updateByExampleSelective(@Param("record") BspRegionpriecedefunits record, @Param("example") BspRegionpriecedefunitsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    int updateByExample(@Param("record") BspRegionpriecedefunits record, @Param("example") BspRegionpriecedefunitsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    int updateByPrimaryKeySelective(BspRegionpriecedefunits record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    int updateByPrimaryKey(BspRegionpriecedefunits record);
}