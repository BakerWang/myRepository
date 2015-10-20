package com.runlion.shop.entity;

import java.util.ArrayList;
import java.util.List;

public class BspRegionpriecedefunitsExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    public BspRegionpriecedefunitsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
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

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andKeyidIsNull() {
            addCriterion("keyid is null");
            return (Criteria) this;
        }

        public Criteria andKeyidIsNotNull() {
            addCriterion("keyid is not null");
            return (Criteria) this;
        }

        public Criteria andKeyidEqualTo(Integer value) {
            addCriterion("keyid =", value, "keyid");
            return (Criteria) this;
        }

        public Criteria andKeyidNotEqualTo(Integer value) {
            addCriterion("keyid <>", value, "keyid");
            return (Criteria) this;
        }

        public Criteria andKeyidGreaterThan(Integer value) {
            addCriterion("keyid >", value, "keyid");
            return (Criteria) this;
        }

        public Criteria andKeyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("keyid >=", value, "keyid");
            return (Criteria) this;
        }

        public Criteria andKeyidLessThan(Integer value) {
            addCriterion("keyid <", value, "keyid");
            return (Criteria) this;
        }

        public Criteria andKeyidLessThanOrEqualTo(Integer value) {
            addCriterion("keyid <=", value, "keyid");
            return (Criteria) this;
        }

        public Criteria andKeyidIn(List<Integer> values) {
            addCriterion("keyid in", values, "keyid");
            return (Criteria) this;
        }

        public Criteria andKeyidNotIn(List<Integer> values) {
            addCriterion("keyid not in", values, "keyid");
            return (Criteria) this;
        }

        public Criteria andKeyidBetween(Integer value1, Integer value2) {
            addCriterion("keyid between", value1, value2, "keyid");
            return (Criteria) this;
        }

        public Criteria andKeyidNotBetween(Integer value1, Integer value2) {
            addCriterion("keyid not between", value1, value2, "keyid");
            return (Criteria) this;
        }

        public Criteria andUnitidIsNull() {
            addCriterion("unitid is null");
            return (Criteria) this;
        }

        public Criteria andUnitidIsNotNull() {
            addCriterion("unitid is not null");
            return (Criteria) this;
        }

        public Criteria andUnitidEqualTo(Integer value) {
            addCriterion("unitid =", value, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidNotEqualTo(Integer value) {
            addCriterion("unitid <>", value, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidGreaterThan(Integer value) {
            addCriterion("unitid >", value, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidGreaterThanOrEqualTo(Integer value) {
            addCriterion("unitid >=", value, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidLessThan(Integer value) {
            addCriterion("unitid <", value, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidLessThanOrEqualTo(Integer value) {
            addCriterion("unitid <=", value, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidIn(List<Integer> values) {
            addCriterion("unitid in", values, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidNotIn(List<Integer> values) {
            addCriterion("unitid not in", values, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidBetween(Integer value1, Integer value2) {
            addCriterion("unitid between", value1, value2, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidNotBetween(Integer value1, Integer value2) {
            addCriterion("unitid not between", value1, value2, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitnameIsNull() {
            addCriterion("unitname is null");
            return (Criteria) this;
        }

        public Criteria andUnitnameIsNotNull() {
            addCriterion("unitname is not null");
            return (Criteria) this;
        }

        public Criteria andUnitnameEqualTo(String value) {
            addCriterion("unitname =", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameNotEqualTo(String value) {
            addCriterion("unitname <>", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameGreaterThan(String value) {
            addCriterion("unitname >", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameGreaterThanOrEqualTo(String value) {
            addCriterion("unitname >=", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameLessThan(String value) {
            addCriterion("unitname <", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameLessThanOrEqualTo(String value) {
            addCriterion("unitname <=", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameLike(String value) {
            addCriterion("unitname like", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameNotLike(String value) {
            addCriterion("unitname not like", value, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameIn(List<String> values) {
            addCriterion("unitname in", values, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameNotIn(List<String> values) {
            addCriterion("unitname not in", values, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameBetween(String value1, String value2) {
            addCriterion("unitname between", value1, value2, "unitname");
            return (Criteria) this;
        }

        public Criteria andUnitnameNotBetween(String value1, String value2) {
            addCriterion("unitname not between", value1, value2, "unitname");
            return (Criteria) this;
        }

        public Criteria andRegionpriceidIsNull() {
            addCriterion("regionpriceid is null");
            return (Criteria) this;
        }

        public Criteria andRegionpriceidIsNotNull() {
            addCriterion("regionpriceid is not null");
            return (Criteria) this;
        }

        public Criteria andRegionpriceidEqualTo(Integer value) {
            addCriterion("regionpriceid =", value, "regionpriceid");
            return (Criteria) this;
        }

        public Criteria andRegionpriceidNotEqualTo(Integer value) {
            addCriterion("regionpriceid <>", value, "regionpriceid");
            return (Criteria) this;
        }

        public Criteria andRegionpriceidGreaterThan(Integer value) {
            addCriterion("regionpriceid >", value, "regionpriceid");
            return (Criteria) this;
        }

        public Criteria andRegionpriceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("regionpriceid >=", value, "regionpriceid");
            return (Criteria) this;
        }

        public Criteria andRegionpriceidLessThan(Integer value) {
            addCriterion("regionpriceid <", value, "regionpriceid");
            return (Criteria) this;
        }

        public Criteria andRegionpriceidLessThanOrEqualTo(Integer value) {
            addCriterion("regionpriceid <=", value, "regionpriceid");
            return (Criteria) this;
        }

        public Criteria andRegionpriceidIn(List<Integer> values) {
            addCriterion("regionpriceid in", values, "regionpriceid");
            return (Criteria) this;
        }

        public Criteria andRegionpriceidNotIn(List<Integer> values) {
            addCriterion("regionpriceid not in", values, "regionpriceid");
            return (Criteria) this;
        }

        public Criteria andRegionpriceidBetween(Integer value1, Integer value2) {
            addCriterion("regionpriceid between", value1, value2, "regionpriceid");
            return (Criteria) this;
        }

        public Criteria andRegionpriceidNotBetween(Integer value1, Integer value2) {
            addCriterion("regionpriceid not between", value1, value2, "regionpriceid");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andPricetypeIsNull() {
            addCriterion("pricetype is null");
            return (Criteria) this;
        }

        public Criteria andPricetypeIsNotNull() {
            addCriterion("pricetype is not null");
            return (Criteria) this;
        }

        public Criteria andPricetypeEqualTo(String value) {
            addCriterion("pricetype =", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeNotEqualTo(String value) {
            addCriterion("pricetype <>", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeGreaterThan(String value) {
            addCriterion("pricetype >", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeGreaterThanOrEqualTo(String value) {
            addCriterion("pricetype >=", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeLessThan(String value) {
            addCriterion("pricetype <", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeLessThanOrEqualTo(String value) {
            addCriterion("pricetype <=", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeLike(String value) {
            addCriterion("pricetype like", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeNotLike(String value) {
            addCriterion("pricetype not like", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeIn(List<String> values) {
            addCriterion("pricetype in", values, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeNotIn(List<String> values) {
            addCriterion("pricetype not in", values, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeBetween(String value1, String value2) {
            addCriterion("pricetype between", value1, value2, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeNotBetween(String value1, String value2) {
            addCriterion("pricetype not between", value1, value2, "pricetype");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated do_not_delete_during_merge Thu Jul 30 14:30:03 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bsp_regionpriecedefunits
     *
     * @mbggenerated Thu Jul 30 14:30:03 CST 2015
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

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
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