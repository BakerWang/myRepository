package com.runlion.shop.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.runlion.shop.entity.BspProducts;
import com.runlion.shop.entity.BspProductsExample;

public interface BspProductsMapper {

	List<BspProducts> search(@Param(value = "areaID") Integer areaID,
			@Param(value = "name") String name);

	List<BspProducts> selectByPZ(Integer id);

	List<BspProducts> selectByQD(Integer id);

	List<BspProducts> selectByPSFS(Integer id);

	List<BspProducts> selectBySCCJ(Integer id);

	List<BspProducts> selectByPP(Integer id);

	List<BspProducts> selectByBZ(Integer id);

	List<BspProducts> comboQuery(@Param(value = "pathList") Map pathList,
			@Param(value = "areaID") Integer areaID);

	List<BspProducts> comboQuery_bak(@Param(value = "bzID") Integer bzID,
			@Param(value = "pzID") Integer pzID,
			@Param(value = "qdID") Integer qdID,
			@Param(value = "psfsID") Integer psfsID,
			@Param(value = "sccjID") Integer sccjID,
			@Param(value = "ppID") Integer ppID);

	List<BspProducts> selOnProductList(String keyWord);

	List<BspProducts> selDownProductList(String keyWord);

	List<BspProducts> selectSalerProlist(Map<String, Object> par);

	int countSalerProlist(Map<String, Object> par);

	public int countNCPronum(Map<String, Object> par);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_products
	 *
	 * @mbggenerated Fri Jun 26 14:56:27 CST 2015
	 */
	int countByExample(BspProductsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_products
	 *
	 * @mbggenerated Fri Jun 26 14:56:27 CST 2015
	 */
	int deleteByExample(BspProductsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_products
	 *
	 * @mbggenerated Fri Jun 26 14:56:27 CST 2015
	 */
	int deleteByPrimaryKey(Integer pid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_products
	 *
	 * @mbggenerated Fri Jun 26 14:56:27 CST 2015
	 */
	int insert(BspProducts record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_products
	 *
	 * @mbggenerated Fri Jun 26 14:56:27 CST 2015
	 */
	int insertSelective(BspProducts record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_products
	 *
	 * @mbggenerated Fri Jun 26 14:56:27 CST 2015
	 */
	List<BspProducts> selectByExampleWithBLOBs(BspProductsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_products
	 *
	 * @mbggenerated Fri Jun 26 14:56:27 CST 2015
	 */
	List<BspProducts> selectByExample(BspProductsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_products
	 *
	 * @mbggenerated Fri Jun 26 14:56:27 CST 2015
	 */
	BspProducts selectByPrimaryKey(Integer pid);

	/**
	 * TODO(新增方法判断后台可以预览使用)
	 * 
	 * @param pid
	 *            产品
	 * @param state
	 *            默认0上架 1下架
	 * @return BspProducts 返回类型
	 */
	BspProducts selectByPrimaryKeyState(@Param(value = "pid") Integer pid,
			@Param(value = "state") Integer state,
			@Param(value = "areaId") Integer areaId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_products
	 *
	 * @mbggenerated Fri Jun 26 14:56:27 CST 2015
	 */
	int updateByExampleSelective(@Param("record") BspProducts record,
			@Param("example") BspProductsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_products
	 *
	 * @mbggenerated Fri Jun 26 14:56:27 CST 2015
	 */
	int updateByExampleWithBLOBs(@Param("record") BspProducts record,
			@Param("example") BspProductsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_products
	 *
	 * @mbggenerated Fri Jun 26 14:56:27 CST 2015
	 */
	int updateByExample(@Param("record") BspProducts record,
			@Param("example") BspProductsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_products
	 *
	 * @mbggenerated Fri Jun 26 14:56:27 CST 2015
	 */
	int updateByPrimaryKeySelective(BspProducts record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_products
	 *
	 * @mbggenerated Fri Jun 26 14:56:27 CST 2015
	 */
	int updateByPrimaryKeyWithBLOBs(BspProducts record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_products
	 *
	 * @mbggenerated Fri Jun 26 14:56:27 CST 2015
	 */
	int updateByPrimaryKey(BspProducts record);
}