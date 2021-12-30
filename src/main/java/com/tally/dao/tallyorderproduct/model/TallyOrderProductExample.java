package com.tally.dao.tallyorderproduct.model;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class TallyOrderProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TallyOrderProductExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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
        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductSpecIdIsNull() {
            addCriterion("product_spec_id is null");
            return (Criteria) this;
        }

        public Criteria andProductSpecIdIsNotNull() {
            addCriterion("product_spec_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductSpecIdEqualTo(Integer value) {
            addCriterion("product_spec_id =", value, "productSpecId");
            return (Criteria) this;
        }

        public Criteria andProductSpecIdNotEqualTo(Integer value) {
            addCriterion("product_spec_id <>", value, "productSpecId");
            return (Criteria) this;
        }

        public Criteria andProductSpecIdGreaterThan(Integer value) {
            addCriterion("product_spec_id >", value, "productSpecId");
            return (Criteria) this;
        }

        public Criteria andProductSpecIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_spec_id >=", value, "productSpecId");
            return (Criteria) this;
        }

        public Criteria andProductSpecIdLessThan(Integer value) {
            addCriterion("product_spec_id <", value, "productSpecId");
            return (Criteria) this;
        }

        public Criteria andProductSpecIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_spec_id <=", value, "productSpecId");
            return (Criteria) this;
        }

        public Criteria andProductSpecIdIn(List<Integer> values) {
            addCriterion("product_spec_id in", values, "productSpecId");
            return (Criteria) this;
        }

        public Criteria andProductSpecIdNotIn(List<Integer> values) {
            addCriterion("product_spec_id not in", values, "productSpecId");
            return (Criteria) this;
        }

        public Criteria andProductSpecIdBetween(Integer value1, Integer value2) {
            addCriterion("product_spec_id between", value1, value2, "productSpecId");
            return (Criteria) this;
        }

        public Criteria andProductSpecIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_spec_id not between", value1, value2, "productSpecId");
            return (Criteria) this;
        }

        public Criteria andSpecPriceIsNull() {
            addCriterion("spec_price is null");
            return (Criteria) this;
        }

        public Criteria andSpecPriceIsNotNull() {
            addCriterion("spec_price is not null");
            return (Criteria) this;
        }

        public Criteria andSpecPriceEqualTo(BigDecimal value) {
            addCriterion("spec_price =", value, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceNotEqualTo(BigDecimal value) {
            addCriterion("spec_price <>", value, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceGreaterThan(BigDecimal value) {
            addCriterion("spec_price >", value, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("spec_price >=", value, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceLessThan(BigDecimal value) {
            addCriterion("spec_price <", value, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("spec_price <=", value, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceIn(List<BigDecimal> values) {
            addCriterion("spec_price in", values, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceNotIn(List<BigDecimal> values) {
            addCriterion("spec_price not in", values, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("spec_price between", value1, value2, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("spec_price not between", value1, value2, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecNumIsNull() {
            addCriterion("spec_num is null");
            return (Criteria) this;
        }

        public Criteria andSpecNumIsNotNull() {
            addCriterion("spec_num is not null");
            return (Criteria) this;
        }

        public Criteria andSpecNumEqualTo(Integer value) {
            addCriterion("spec_num =", value, "specNum");
            return (Criteria) this;
        }

        public Criteria andSpecNumNotEqualTo(Integer value) {
            addCriterion("spec_num <>", value, "specNum");
            return (Criteria) this;
        }

        public Criteria andSpecNumGreaterThan(Integer value) {
            addCriterion("spec_num >", value, "specNum");
            return (Criteria) this;
        }

        public Criteria andSpecNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("spec_num >=", value, "specNum");
            return (Criteria) this;
        }

        public Criteria andSpecNumLessThan(Integer value) {
            addCriterion("spec_num <", value, "specNum");
            return (Criteria) this;
        }

        public Criteria andSpecNumLessThanOrEqualTo(Integer value) {
            addCriterion("spec_num <=", value, "specNum");
            return (Criteria) this;
        }

        public Criteria andSpecNumIn(List<Integer> values) {
            addCriterion("spec_num in", values, "specNum");
            return (Criteria) this;
        }

        public Criteria andSpecNumNotIn(List<Integer> values) {
            addCriterion("spec_num not in", values, "specNum");
            return (Criteria) this;
        }

        public Criteria andSpecNumBetween(Integer value1, Integer value2) {
            addCriterion("spec_num between", value1, value2, "specNum");
            return (Criteria) this;
        }

        public Criteria andSpecNumNotBetween(Integer value1, Integer value2) {
            addCriterion("spec_num not between", value1, value2, "specNum");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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