package com.tally.dao.tallyproductspec.model;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class TallyProductSpecExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TallyProductSpecExample() {
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

        public Criteria andSpecNameIsNull() {
            addCriterion("spec_name is null");
            return (Criteria) this;
        }

        public Criteria andSpecNameIsNotNull() {
            addCriterion("spec_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpecNameEqualTo(String value) {
            addCriterion("spec_name =", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameNotEqualTo(String value) {
            addCriterion("spec_name <>", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameGreaterThan(String value) {
            addCriterion("spec_name >", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameGreaterThanOrEqualTo(String value) {
            addCriterion("spec_name >=", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameLessThan(String value) {
            addCriterion("spec_name <", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameLessThanOrEqualTo(String value) {
            addCriterion("spec_name <=", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameLike(String value) {
            addCriterion("spec_name like", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameNotLike(String value) {
            addCriterion("spec_name not like", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameIn(List<String> values) {
            addCriterion("spec_name in", values, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameNotIn(List<String> values) {
            addCriterion("spec_name not in", values, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameBetween(String value1, String value2) {
            addCriterion("spec_name between", value1, value2, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameNotBetween(String value1, String value2) {
            addCriterion("spec_name not between", value1, value2, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecSerialIsNull() {
            addCriterion("spec_serial is null");
            return (Criteria) this;
        }

        public Criteria andSpecSerialIsNotNull() {
            addCriterion("spec_serial is not null");
            return (Criteria) this;
        }

        public Criteria andSpecSerialEqualTo(String value) {
            addCriterion("spec_serial =", value, "specSerial");
            return (Criteria) this;
        }

        public Criteria andSpecSerialNotEqualTo(String value) {
            addCriterion("spec_serial <>", value, "specSerial");
            return (Criteria) this;
        }

        public Criteria andSpecSerialGreaterThan(String value) {
            addCriterion("spec_serial >", value, "specSerial");
            return (Criteria) this;
        }

        public Criteria andSpecSerialGreaterThanOrEqualTo(String value) {
            addCriterion("spec_serial >=", value, "specSerial");
            return (Criteria) this;
        }

        public Criteria andSpecSerialLessThan(String value) {
            addCriterion("spec_serial <", value, "specSerial");
            return (Criteria) this;
        }

        public Criteria andSpecSerialLessThanOrEqualTo(String value) {
            addCriterion("spec_serial <=", value, "specSerial");
            return (Criteria) this;
        }

        public Criteria andSpecSerialLike(String value) {
            addCriterion("spec_serial like", value, "specSerial");
            return (Criteria) this;
        }

        public Criteria andSpecSerialNotLike(String value) {
            addCriterion("spec_serial not like", value, "specSerial");
            return (Criteria) this;
        }

        public Criteria andSpecSerialIn(List<String> values) {
            addCriterion("spec_serial in", values, "specSerial");
            return (Criteria) this;
        }

        public Criteria andSpecSerialNotIn(List<String> values) {
            addCriterion("spec_serial not in", values, "specSerial");
            return (Criteria) this;
        }

        public Criteria andSpecSerialBetween(String value1, String value2) {
            addCriterion("spec_serial between", value1, value2, "specSerial");
            return (Criteria) this;
        }

        public Criteria andSpecSerialNotBetween(String value1, String value2) {
            addCriterion("spec_serial not between", value1, value2, "specSerial");
            return (Criteria) this;
        }

        public Criteria andSpecStorageIsNull() {
            addCriterion("spec_storage is null");
            return (Criteria) this;
        }

        public Criteria andSpecStorageIsNotNull() {
            addCriterion("spec_storage is not null");
            return (Criteria) this;
        }

        public Criteria andSpecStorageEqualTo(Integer value) {
            addCriterion("spec_storage =", value, "specStorage");
            return (Criteria) this;
        }

        public Criteria andSpecStorageNotEqualTo(Integer value) {
            addCriterion("spec_storage <>", value, "specStorage");
            return (Criteria) this;
        }

        public Criteria andSpecStorageGreaterThan(Integer value) {
            addCriterion("spec_storage >", value, "specStorage");
            return (Criteria) this;
        }

        public Criteria andSpecStorageGreaterThanOrEqualTo(Integer value) {
            addCriterion("spec_storage >=", value, "specStorage");
            return (Criteria) this;
        }

        public Criteria andSpecStorageLessThan(Integer value) {
            addCriterion("spec_storage <", value, "specStorage");
            return (Criteria) this;
        }

        public Criteria andSpecStorageLessThanOrEqualTo(Integer value) {
            addCriterion("spec_storage <=", value, "specStorage");
            return (Criteria) this;
        }

        public Criteria andSpecStorageIn(List<Integer> values) {
            addCriterion("spec_storage in", values, "specStorage");
            return (Criteria) this;
        }

        public Criteria andSpecStorageNotIn(List<Integer> values) {
            addCriterion("spec_storage not in", values, "specStorage");
            return (Criteria) this;
        }

        public Criteria andSpecStorageBetween(Integer value1, Integer value2) {
            addCriterion("spec_storage between", value1, value2, "specStorage");
            return (Criteria) this;
        }

        public Criteria andSpecStorageNotBetween(Integer value1, Integer value2) {
            addCriterion("spec_storage not between", value1, value2, "specStorage");
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

        public Criteria andSpecCostPriceIsNull() {
            addCriterion("spec_cost_price is null");
            return (Criteria) this;
        }

        public Criteria andSpecCostPriceIsNotNull() {
            addCriterion("spec_cost_price is not null");
            return (Criteria) this;
        }

        public Criteria andSpecCostPriceEqualTo(BigDecimal value) {
            addCriterion("spec_cost_price =", value, "specCostPrice");
            return (Criteria) this;
        }

        public Criteria andSpecCostPriceNotEqualTo(BigDecimal value) {
            addCriterion("spec_cost_price <>", value, "specCostPrice");
            return (Criteria) this;
        }

        public Criteria andSpecCostPriceGreaterThan(BigDecimal value) {
            addCriterion("spec_cost_price >", value, "specCostPrice");
            return (Criteria) this;
        }

        public Criteria andSpecCostPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("spec_cost_price >=", value, "specCostPrice");
            return (Criteria) this;
        }

        public Criteria andSpecCostPriceLessThan(BigDecimal value) {
            addCriterion("spec_cost_price <", value, "specCostPrice");
            return (Criteria) this;
        }

        public Criteria andSpecCostPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("spec_cost_price <=", value, "specCostPrice");
            return (Criteria) this;
        }

        public Criteria andSpecCostPriceIn(List<BigDecimal> values) {
            addCriterion("spec_cost_price in", values, "specCostPrice");
            return (Criteria) this;
        }

        public Criteria andSpecCostPriceNotIn(List<BigDecimal> values) {
            addCriterion("spec_cost_price not in", values, "specCostPrice");
            return (Criteria) this;
        }

        public Criteria andSpecCostPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("spec_cost_price between", value1, value2, "specCostPrice");
            return (Criteria) this;
        }

        public Criteria andSpecCostPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("spec_cost_price not between", value1, value2, "specCostPrice");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Integer value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Integer value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Integer value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Integer value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Integer value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Integer> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Integer> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Integer value1, Integer value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
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