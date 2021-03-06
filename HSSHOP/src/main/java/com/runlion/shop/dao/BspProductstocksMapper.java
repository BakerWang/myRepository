package com.runlion.shop.dao;

import com.runlion.shop.entity.BspProductstocks;
import com.runlion.shop.entity.BspProductstocksExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BspProductstocksMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_productstocks
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int countByExample(BspProductstocksExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_productstocks
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int deleteByExample(BspProductstocksExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_productstocks
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int deleteByPrimaryKey(Integer pid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_productstocks
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int insert(BspProductstocks record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_productstocks
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int insertSelective(BspProductstocks record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_productstocks
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    List<BspProductstocks> selectByExample(BspProductstocksExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_productstocks
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    BspProductstocks selectByPrimaryKey(Integer pid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_productstocks
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int updateByExampleSelective(@Param("record") BspProductstocks record, @Param("example") BspProductstocksExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_productstocks
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int updateByExample(@Param("record") BspProductstocks record, @Param("example") BspProductstocksExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_productstocks
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int updateByPrimaryKeySelective(BspProductstocks record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_productstocks
     *
     * @mbggenerated Fri Jun 26 14:56:27 CST 2015
     */
    int updateByPrimaryKey(BspProductstocks record);
}