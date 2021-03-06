package com.runlion.shop.entity;

import java.math.BigDecimal;

public class BspProductsregionsprice implements
		Comparable<BspProductsregionsprice>, Cloneable {

	public BspProductsregionsprice() {

	}

	public BspProductsregionsprice(int productregionsid, String pricetype,
			double price) {
		this.productregionsid = productregionsid;
		this.price = BigDecimal.valueOf(price);
		this.pricetype = pricetype;
	}

	public BspProductsregionsprice(int id, double price) {
		this.id = id;
		this.price = BigDecimal.valueOf(price);
	}

	public BspProductsregionsprice(int id, int productregionsid,
			String pricetype, double price) {
		this.id = id;
		this.productregionsid = productregionsid;
		this.price = BigDecimal.valueOf(price);
		this.pricetype = pricetype;
	}

	@Override
	public BspProductsregionsprice clone() {
		try {
			return (BspProductsregionsprice) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int compareTo(BspProductsregionsprice o) {
		return this.getBuyminquan().compareTo(o.getBuyminquan());
	}

	private String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column bsp_productsregionsprice.id
	 *
	 * @mbggenerated Thu Jul 02 10:49:04 CST 2015
	 */
	private Integer id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column bsp_productsregionsprice.productregionsId
	 *
	 * @mbggenerated Thu Jul 02 10:49:04 CST 2015
	 */
	private Integer productregionsid;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column bsp_productsregionsprice.type
	 *
	 * @mbggenerated Thu Jul 02 10:49:04 CST 2015
	 */
	private String type;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column bsp_productsregionsprice.price
	 *
	 * @mbggenerated Thu Jul 02 10:49:04 CST 2015
	 */
	private BigDecimal price;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column bsp_productsregionsprice.priceType
	 *
	 * @mbggenerated Thu Jul 02 10:49:04 CST 2015
	 */
	private String pricetype;
	/**
	 * 该段的最小购买量
	 */
	private Double buyminquan;

	private Integer modeltype;

	public Integer getModeltype() {
		return modeltype;
	}

	public void setModeltype(Integer modeltype) {
		this.modeltype = modeltype;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column bsp_productsregionsprice.id
	 *
	 * @return the value of bsp_productsregionsprice.id
	 *
	 * @mbggenerated Thu Jul 02 10:49:04 CST 2015
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column bsp_productsregionsprice.id
	 *
	 * @param id
	 *            the value for bsp_productsregionsprice.id
	 *
	 * @mbggenerated Thu Jul 02 10:49:04 CST 2015
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column bsp_productsregionsprice.productregionsId
	 *
	 * @return the value of bsp_productsregionsprice.productregionsId
	 *
	 * @mbggenerated Thu Jul 02 10:49:04 CST 2015
	 */
	public Integer getProductregionsid() {
		return productregionsid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column bsp_productsregionsprice.productregionsId
	 *
	 * @param productregionsid
	 *            the value for bsp_productsregionsprice.productregionsId
	 *
	 * @mbggenerated Thu Jul 02 10:49:04 CST 2015
	 */
	public void setProductregionsid(Integer productregionsid) {
		this.productregionsid = productregionsid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column bsp_productsregionsprice.type
	 *
	 * @return the value of bsp_productsregionsprice.type
	 *
	 * @mbggenerated Thu Jul 02 10:49:04 CST 2015
	 */
	public String getType() {
		return type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column bsp_productsregionsprice.type
	 *
	 * @param type
	 *            the value for bsp_productsregionsprice.type
	 *
	 * @mbggenerated Thu Jul 02 10:49:04 CST 2015
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column bsp_productsregionsprice.price
	 *
	 * @return the value of bsp_productsregionsprice.price
	 *
	 * @mbggenerated Thu Jul 02 10:49:04 CST 2015
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column bsp_productsregionsprice.price
	 *
	 * @param price
	 *            the value for bsp_productsregionsprice.price
	 *
	 * @mbggenerated Thu Jul 02 10:49:04 CST 2015
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column bsp_productsregionsprice.priceType
	 *
	 * @return the value of bsp_productsregionsprice.priceType
	 *
	 * @mbggenerated Thu Jul 02 10:49:04 CST 2015
	 */
	public String getPricetype() {
		return pricetype;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column bsp_productsregionsprice.priceType
	 *
	 * @param pricetype
	 *            the value for bsp_productsregionsprice.priceType
	 *
	 * @mbggenerated Thu Jul 02 10:49:04 CST 2015
	 */
	public void setPricetype(String pricetype) {
		this.pricetype = pricetype;
	}

	public Double getBuyminquan() {
		return buyminquan;
	}

	public void setBuyminquan(Double buyminquan) {
		this.buyminquan = buyminquan;
	}

}