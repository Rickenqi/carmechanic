package com.ricky.carmechanic.domain.example;

import java.util.ArrayList;
import java.util.List;

public class CarpartInfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table carpart_info
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table carpart_info
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table carpart_info
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carpart_info
     *
     * @mbggenerated
     */
    public CarpartInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carpart_info
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carpart_info
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carpart_info
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carpart_info
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carpart_info
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carpart_info
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carpart_info
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carpart_info
     *
     * @mbggenerated
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
     * This method corresponds to the database table carpart_info
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carpart_info
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table carpart_info
     *
     * @mbggenerated
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

        public Criteria andCarpartIdIsNull() {
            addCriterion("carpart_id is null");
            return (Criteria) this;
        }

        public Criteria andCarpartIdIsNotNull() {
            addCriterion("carpart_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarpartIdEqualTo(Integer value) {
            addCriterion("carpart_id =", value, "carpartId");
            return (Criteria) this;
        }

        public Criteria andCarpartIdNotEqualTo(Integer value) {
            addCriterion("carpart_id <>", value, "carpartId");
            return (Criteria) this;
        }

        public Criteria andCarpartIdGreaterThan(Integer value) {
            addCriterion("carpart_id >", value, "carpartId");
            return (Criteria) this;
        }

        public Criteria andCarpartIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("carpart_id >=", value, "carpartId");
            return (Criteria) this;
        }

        public Criteria andCarpartIdLessThan(Integer value) {
            addCriterion("carpart_id <", value, "carpartId");
            return (Criteria) this;
        }

        public Criteria andCarpartIdLessThanOrEqualTo(Integer value) {
            addCriterion("carpart_id <=", value, "carpartId");
            return (Criteria) this;
        }

        public Criteria andCarpartIdIn(List<Integer> values) {
            addCriterion("carpart_id in", values, "carpartId");
            return (Criteria) this;
        }

        public Criteria andCarpartIdNotIn(List<Integer> values) {
            addCriterion("carpart_id not in", values, "carpartId");
            return (Criteria) this;
        }

        public Criteria andCarpartIdBetween(Integer value1, Integer value2) {
            addCriterion("carpart_id between", value1, value2, "carpartId");
            return (Criteria) this;
        }

        public Criteria andCarpartIdNotBetween(Integer value1, Integer value2) {
            addCriterion("carpart_id not between", value1, value2, "carpartId");
            return (Criteria) this;
        }

        public Criteria andCarpartNameIsNull() {
            addCriterion("carpart_name is null");
            return (Criteria) this;
        }

        public Criteria andCarpartNameIsNotNull() {
            addCriterion("carpart_name is not null");
            return (Criteria) this;
        }

        public Criteria andCarpartNameEqualTo(String value) {
            addCriterion("carpart_name =", value, "carpartName");
            return (Criteria) this;
        }

        public Criteria andCarpartNameNotEqualTo(String value) {
            addCriterion("carpart_name <>", value, "carpartName");
            return (Criteria) this;
        }

        public Criteria andCarpartNameGreaterThan(String value) {
            addCriterion("carpart_name >", value, "carpartName");
            return (Criteria) this;
        }

        public Criteria andCarpartNameGreaterThanOrEqualTo(String value) {
            addCriterion("carpart_name >=", value, "carpartName");
            return (Criteria) this;
        }

        public Criteria andCarpartNameLessThan(String value) {
            addCriterion("carpart_name <", value, "carpartName");
            return (Criteria) this;
        }

        public Criteria andCarpartNameLessThanOrEqualTo(String value) {
            addCriterion("carpart_name <=", value, "carpartName");
            return (Criteria) this;
        }

        public Criteria andCarpartNameLike(String value) {
            addCriterion("carpart_name like", value, "carpartName");
            return (Criteria) this;
        }

        public Criteria andCarpartNameNotLike(String value) {
            addCriterion("carpart_name not like", value, "carpartName");
            return (Criteria) this;
        }

        public Criteria andCarpartNameIn(List<String> values) {
            addCriterion("carpart_name in", values, "carpartName");
            return (Criteria) this;
        }

        public Criteria andCarpartNameNotIn(List<String> values) {
            addCriterion("carpart_name not in", values, "carpartName");
            return (Criteria) this;
        }

        public Criteria andCarpartNameBetween(String value1, String value2) {
            addCriterion("carpart_name between", value1, value2, "carpartName");
            return (Criteria) this;
        }

        public Criteria andCarpartNameNotBetween(String value1, String value2) {
            addCriterion("carpart_name not between", value1, value2, "carpartName");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("manufacturer like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("manufacturer not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("manufacturer not between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andCarpartPriceIsNull() {
            addCriterion("carpart_price is null");
            return (Criteria) this;
        }

        public Criteria andCarpartPriceIsNotNull() {
            addCriterion("carpart_price is not null");
            return (Criteria) this;
        }

        public Criteria andCarpartPriceEqualTo(Integer value) {
            addCriterion("carpart_price =", value, "carpartPrice");
            return (Criteria) this;
        }

        public Criteria andCarpartPriceNotEqualTo(Integer value) {
            addCriterion("carpart_price <>", value, "carpartPrice");
            return (Criteria) this;
        }

        public Criteria andCarpartPriceGreaterThan(Integer value) {
            addCriterion("carpart_price >", value, "carpartPrice");
            return (Criteria) this;
        }

        public Criteria andCarpartPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("carpart_price >=", value, "carpartPrice");
            return (Criteria) this;
        }

        public Criteria andCarpartPriceLessThan(Integer value) {
            addCriterion("carpart_price <", value, "carpartPrice");
            return (Criteria) this;
        }

        public Criteria andCarpartPriceLessThanOrEqualTo(Integer value) {
            addCriterion("carpart_price <=", value, "carpartPrice");
            return (Criteria) this;
        }

        public Criteria andCarpartPriceIn(List<Integer> values) {
            addCriterion("carpart_price in", values, "carpartPrice");
            return (Criteria) this;
        }

        public Criteria andCarpartPriceNotIn(List<Integer> values) {
            addCriterion("carpart_price not in", values, "carpartPrice");
            return (Criteria) this;
        }

        public Criteria andCarpartPriceBetween(Integer value1, Integer value2) {
            addCriterion("carpart_price between", value1, value2, "carpartPrice");
            return (Criteria) this;
        }

        public Criteria andCarpartPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("carpart_price not between", value1, value2, "carpartPrice");
            return (Criteria) this;
        }

        public Criteria andReserveAmountIsNull() {
            addCriterion("reserve_amount is null");
            return (Criteria) this;
        }

        public Criteria andReserveAmountIsNotNull() {
            addCriterion("reserve_amount is not null");
            return (Criteria) this;
        }

        public Criteria andReserveAmountEqualTo(Integer value) {
            addCriterion("reserve_amount =", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountNotEqualTo(Integer value) {
            addCriterion("reserve_amount <>", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountGreaterThan(Integer value) {
            addCriterion("reserve_amount >", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("reserve_amount >=", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountLessThan(Integer value) {
            addCriterion("reserve_amount <", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountLessThanOrEqualTo(Integer value) {
            addCriterion("reserve_amount <=", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountIn(List<Integer> values) {
            addCriterion("reserve_amount in", values, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountNotIn(List<Integer> values) {
            addCriterion("reserve_amount not in", values, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountBetween(Integer value1, Integer value2) {
            addCriterion("reserve_amount between", value1, value2, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("reserve_amount not between", value1, value2, "reserveAmount");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table carpart_info
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table carpart_info
     *
     * @mbggenerated
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