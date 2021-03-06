package com.runlion.shop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BspAdminuserExample {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table bsp_adminuser
	 *
	 * @mbggenerated Mon Jun 29 11:41:53 CST 2015
	 */
	protected String orderByClause;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table bsp_adminuser
	 *
	 * @mbggenerated Mon Jun 29 11:41:53 CST 2015
	 */
	protected boolean distinct;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table bsp_adminuser
	 *
	 * @mbggenerated Mon Jun 29 11:41:53 CST 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_adminuser
	 *
	 * @mbggenerated Mon Jun 29 11:41:53 CST 2015
	 */
	public BspAdminuserExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_adminuser
	 *
	 * @mbggenerated Mon Jun 29 11:41:53 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_adminuser
	 *
	 * @mbggenerated Mon Jun 29 11:41:53 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_adminuser
	 *
	 * @mbggenerated Mon Jun 29 11:41:53 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_adminuser
	 *
	 * @mbggenerated Mon Jun 29 11:41:53 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_adminuser
	 *
	 * @mbggenerated Mon Jun 29 11:41:53 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_adminuser
	 *
	 * @mbggenerated Mon Jun 29 11:41:53 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_adminuser
	 *
	 * @mbggenerated Mon Jun 29 11:41:53 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_adminuser
	 *
	 * @mbggenerated Mon Jun 29 11:41:53 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_adminuser
	 *
	 * @mbggenerated Mon Jun 29 11:41:53 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table bsp_adminuser
	 *
	 * @mbggenerated Mon Jun 29 11:41:53 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table bsp_adminuser
	 *
	 * @mbggenerated Mon Jun 29 11:41:53 CST 2015
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andUidIsNull() {
			addCriterion("uid is null");
			return (Criteria) this;
		}

		public Criteria andUidIsNotNull() {
			addCriterion("uid is not null");
			return (Criteria) this;
		}

		public Criteria andUidEqualTo(Integer value) {
			addCriterion("uid =", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotEqualTo(Integer value) {
			addCriterion("uid <>", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidGreaterThan(Integer value) {
			addCriterion("uid >", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("uid >=", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidLessThan(Integer value) {
			addCriterion("uid <", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidLessThanOrEqualTo(Integer value) {
			addCriterion("uid <=", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidIn(List<Integer> values) {
			addCriterion("uid in", values, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotIn(List<Integer> values) {
			addCriterion("uid not in", values, "uid");
			return (Criteria) this;
		}

		public Criteria andUidBetween(Integer value1, Integer value2) {
			addCriterion("uid between", value1, value2, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotBetween(Integer value1, Integer value2) {
			addCriterion("uid not between", value1, value2, "uid");
			return (Criteria) this;
		}

		public Criteria andUsernameIsNull() {
			addCriterion("username is null");
			return (Criteria) this;
		}

		public Criteria andUsernameIsNotNull() {
			addCriterion("username is not null");
			return (Criteria) this;
		}

		public Criteria andUsernameEqualTo(String value) {
			addCriterion("username =", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotEqualTo(String value) {
			addCriterion("username <>", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThan(String value) {
			addCriterion("username >", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("username >=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThan(String value) {
			addCriterion("username <", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThanOrEqualTo(String value) {
			addCriterion("username <=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLike(String value) {
			addCriterion("username like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotLike(String value) {
			addCriterion("username not like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameIn(List<String> values) {
			addCriterion("username in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotIn(List<String> values) {
			addCriterion("username not in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameBetween(String value1, String value2) {
			addCriterion("username between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotBetween(String value1, String value2) {
			addCriterion("username not between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andSaltIsNull() {
			addCriterion("salt is null");
			return (Criteria) this;
		}

		public Criteria andSaltIsNotNull() {
			addCriterion("salt is not null");
			return (Criteria) this;
		}

		public Criteria andSaltEqualTo(String value) {
			addCriterion("salt =", value, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltNotEqualTo(String value) {
			addCriterion("salt <>", value, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltGreaterThan(String value) {
			addCriterion("salt >", value, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltGreaterThanOrEqualTo(String value) {
			addCriterion("salt >=", value, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltLessThan(String value) {
			addCriterion("salt <", value, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltLessThanOrEqualTo(String value) {
			addCriterion("salt <=", value, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltLike(String value) {
			addCriterion("salt like", value, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltNotLike(String value) {
			addCriterion("salt not like", value, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltIn(List<String> values) {
			addCriterion("salt in", values, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltNotIn(List<String> values) {
			addCriterion("salt not in", values, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltBetween(String value1, String value2) {
			addCriterion("salt between", value1, value2, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltNotBetween(String value1, String value2) {
			addCriterion("salt not between", value1, value2, "salt");
			return (Criteria) this;
		}

		public Criteria andRealnameIsNull() {
			addCriterion("realname is null");
			return (Criteria) this;
		}

		public Criteria andRealnameIsNotNull() {
			addCriterion("realname is not null");
			return (Criteria) this;
		}

		public Criteria andRealnameEqualTo(String value) {
			addCriterion("realname =", value, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameNotEqualTo(String value) {
			addCriterion("realname <>", value, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameGreaterThan(String value) {
			addCriterion("realname >", value, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameGreaterThanOrEqualTo(String value) {
			addCriterion("realname >=", value, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameLessThan(String value) {
			addCriterion("realname <", value, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameLessThanOrEqualTo(String value) {
			addCriterion("realname <=", value, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameLike(String value) {
			addCriterion("realname like", value, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameNotLike(String value) {
			addCriterion("realname not like", value, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameIn(List<String> values) {
			addCriterion("realname in", values, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameNotIn(List<String> values) {
			addCriterion("realname not in", values, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameBetween(String value1, String value2) {
			addCriterion("realname between", value1, value2, "realname");
			return (Criteria) this;
		}

		public Criteria andRealnameNotBetween(String value1, String value2) {
			addCriterion("realname not between", value1, value2, "realname");
			return (Criteria) this;
		}

		public Criteria andInittimeIsNull() {
			addCriterion("inittime is null");
			return (Criteria) this;
		}

		public Criteria andInittimeIsNotNull() {
			addCriterion("inittime is not null");
			return (Criteria) this;
		}

		public Criteria andInittimeEqualTo(Date value) {
			addCriterion("inittime =", value, "inittime");
			return (Criteria) this;
		}

		public Criteria andInittimeNotEqualTo(Date value) {
			addCriterion("inittime <>", value, "inittime");
			return (Criteria) this;
		}

		public Criteria andInittimeGreaterThan(Date value) {
			addCriterion("inittime >", value, "inittime");
			return (Criteria) this;
		}

		public Criteria andInittimeGreaterThanOrEqualTo(Date value) {
			addCriterion("inittime >=", value, "inittime");
			return (Criteria) this;
		}

		public Criteria andInittimeLessThan(Date value) {
			addCriterion("inittime <", value, "inittime");
			return (Criteria) this;
		}

		public Criteria andInittimeLessThanOrEqualTo(Date value) {
			addCriterion("inittime <=", value, "inittime");
			return (Criteria) this;
		}

		public Criteria andInittimeIn(List<Date> values) {
			addCriterion("inittime in", values, "inittime");
			return (Criteria) this;
		}

		public Criteria andInittimeNotIn(List<Date> values) {
			addCriterion("inittime not in", values, "inittime");
			return (Criteria) this;
		}

		public Criteria andInittimeBetween(Date value1, Date value2) {
			addCriterion("inittime between", value1, value2, "inittime");
			return (Criteria) this;
		}

		public Criteria andInittimeNotBetween(Date value1, Date value2) {
			addCriterion("inittime not between", value1, value2, "inittime");
			return (Criteria) this;
		}

		public Criteria andUptimeIsNull() {
			addCriterion("uptime is null");
			return (Criteria) this;
		}

		public Criteria andUptimeIsNotNull() {
			addCriterion("uptime is not null");
			return (Criteria) this;
		}

		public Criteria andUptimeEqualTo(Date value) {
			addCriterion("uptime =", value, "uptime");
			return (Criteria) this;
		}

		public Criteria andUptimeNotEqualTo(Date value) {
			addCriterion("uptime <>", value, "uptime");
			return (Criteria) this;
		}

		public Criteria andUptimeGreaterThan(Date value) {
			addCriterion("uptime >", value, "uptime");
			return (Criteria) this;
		}

		public Criteria andUptimeGreaterThanOrEqualTo(Date value) {
			addCriterion("uptime >=", value, "uptime");
			return (Criteria) this;
		}

		public Criteria andUptimeLessThan(Date value) {
			addCriterion("uptime <", value, "uptime");
			return (Criteria) this;
		}

		public Criteria andUptimeLessThanOrEqualTo(Date value) {
			addCriterion("uptime <=", value, "uptime");
			return (Criteria) this;
		}

		public Criteria andUptimeIn(List<Date> values) {
			addCriterion("uptime in", values, "uptime");
			return (Criteria) this;
		}

		public Criteria andUptimeNotIn(List<Date> values) {
			addCriterion("uptime not in", values, "uptime");
			return (Criteria) this;
		}

		public Criteria andUptimeBetween(Date value1, Date value2) {
			addCriterion("uptime between", value1, value2, "uptime");
			return (Criteria) this;
		}

		public Criteria andUptimeNotBetween(Date value1, Date value2) {
			addCriterion("uptime not between", value1, value2, "uptime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table bsp_adminuser
	 *
	 * @mbggenerated do_not_delete_during_merge Mon Jun 29 11:41:53 CST 2015
	 */
	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table bsp_adminuser
	 *
	 * @mbggenerated Mon Jun 29 11:41:53 CST 2015
	 */
	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}