package com.runlion.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.runlion.shop.entity.BspProductsregionsbrandplace;
import com.runlion.shop.entity.BspProductsregionsbrandplaceExample;

public interface BspProductsregionsbrandplaceMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_productsregionsbrandplace
	 *
	 * @mbggenerated Fri Aug 07 17:10:39 CST 2015
	 */
	int countByExample(BspProductsregionsbrandplaceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_productsregionsbrandplace
	 *
	 * @mbggenerated Fri Aug 07 17:10:39 CST 2015
	 */
	int deleteByExample(BspProductsregionsbrandplaceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_productsregionsbrandplace
	 *
	 * @mbggenerated Fri Aug 07 17:10:39 CST 2015
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_productsregionsbrandplace
	 *
	 * @mbggenerated Fri Aug 07 17:10:39 CST 2015
	 */
	int insert(BspProductsregionsbrandplace record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_productsregionsbrandplace
	 *
	 * @mbggenerated Fri Aug 07 17:10:39 CST 2015
	 */
	int insertSelective(BspProductsregionsbrandplace record);

	// 根据区域品牌插入区域产地
	int insertByBrand(@Param(value = "brandId") Integer brandId,
			@Param(value = "placeId") Integer placeId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_productsregionsbrandplace
	 *
	 * @mbggenerated Fri Aug 07 17:10:39 CST 2015
	 */
	List<BspProductsregionsbrandplace> selectByExample(
			BspProductsregionsbrandplaceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_productsregionsbrandplace
	 *
	 * @mbggenerated Fri Aug 07 17:10:39 CST 2015
	 */
	BspProductsregionsbrandplace selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_productsregionsbrandplace
	 *
	 * @mbggenerated Fri Aug 07 17:10:39 CST 2015
	 */
	int updateByExampleSelective(
			@Param("record") BspProductsregionsbrandplace record,
			@Param("example") BspProductsregionsbrandplaceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_productsregionsbrandplace
	 *
	 * @mbggenerated Fri Aug 07 17:10:39 CST 2015
	 */
	int updateByExample(@Param("record") BspProductsregionsbrandplace record,
			@Param("example") BspProductsregionsbrandplaceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_productsregionsbrandplace
	 *
	 * @mbggenerated Fri Aug 07 17:10:39 CST 2015
	 */
	int updateByPrimaryKeySelective(BspProductsregionsbrandplace record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_productsregionsbrandplace
	 *
	 * @mbggenerated Fri Aug 07 17:10:39 CST 2015
	 */
	int updateByPrimaryKey(BspProductsregionsbrandplace record);
}