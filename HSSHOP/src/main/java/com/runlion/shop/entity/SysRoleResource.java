package com.runlion.shop.entity;

public class SysRoleResource {

	public SysRoleResource() {

	}

	public SysRoleResource(Long roleid, Long resourceid) {
		this.roleid = roleid;
		this.resourceid = resourceid;
	}

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column SYS_ROLE_RESOURCE.id
	 *
	 * @mbggenerated Tue Sep 01 13:29:07 CST 2015
	 */
	private Long id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column SYS_ROLE_RESOURCE.roleId
	 *
	 * @mbggenerated Tue Sep 01 13:29:07 CST 2015
	 */
	private Long roleid;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column SYS_ROLE_RESOURCE.resourceId
	 *
	 * @mbggenerated Tue Sep 01 13:29:07 CST 2015
	 */
	private Long resourceid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column SYS_ROLE_RESOURCE.id
	 *
	 * @return the value of SYS_ROLE_RESOURCE.id
	 *
	 * @mbggenerated Tue Sep 01 13:29:07 CST 2015
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column SYS_ROLE_RESOURCE.id
	 *
	 * @param id
	 *            the value for SYS_ROLE_RESOURCE.id
	 *
	 * @mbggenerated Tue Sep 01 13:29:07 CST 2015
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column SYS_ROLE_RESOURCE.roleId
	 *
	 * @return the value of SYS_ROLE_RESOURCE.roleId
	 *
	 * @mbggenerated Tue Sep 01 13:29:07 CST 2015
	 */
	public Long getRoleid() {
		return roleid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column SYS_ROLE_RESOURCE.roleId
	 *
	 * @param roleid
	 *            the value for SYS_ROLE_RESOURCE.roleId
	 *
	 * @mbggenerated Tue Sep 01 13:29:07 CST 2015
	 */
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column SYS_ROLE_RESOURCE.resourceId
	 *
	 * @return the value of SYS_ROLE_RESOURCE.resourceId
	 *
	 * @mbggenerated Tue Sep 01 13:29:07 CST 2015
	 */
	public Long getResourceid() {
		return resourceid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column SYS_ROLE_RESOURCE.resourceId
	 *
	 * @param resourceid
	 *            the value for SYS_ROLE_RESOURCE.resourceId
	 *
	 * @mbggenerated Tue Sep 01 13:29:07 CST 2015
	 */
	public void setResourceid(Long resourceid) {
		this.resourceid = resourceid;
	}
}