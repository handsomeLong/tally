package com.tally.dao.tallyaccountwaterdetail.model;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class TallyAccountWaterDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TallyAccountWaterDetailExample() {
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

        public Criteria andWaterIdIsNull() {
            addCriterion("water_id is null");
            return (Criteria) this;
        }

        public Criteria andWaterIdIsNotNull() {
            addCriterion("water_id is not null");
            return (Criteria) this;
        }

        public Criteria andWaterIdEqualTo(Integer value) {
            addCriterion("water_id =", value, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdNotEqualTo(Integer value) {
            addCriterion("water_id <>", value, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdGreaterThan(Integer value) {
            addCriterion("water_id >", value, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("water_id >=", value, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdLessThan(Integer value) {
            addCriterion("water_id <", value, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdLessThanOrEqualTo(Integer value) {
            addCriterion("water_id <=", value, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdIn(List<Integer> values) {
            addCriterion("water_id in", values, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdNotIn(List<Integer> values) {
            addCriterion("water_id not in", values, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdBetween(Integer value1, Integer value2) {
            addCriterion("water_id between", value1, value2, "waterId");
            return (Criteria) this;
        }

        public Criteria andWaterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("water_id not between", value1, value2, "waterId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdIsNull() {
            addCriterion("w.btype_user_id is null");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdIsNotNull() {
            addCriterion("w.btype_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdEqualTo(Integer value) {
            addCriterion("w.btype_user_id =", value, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdNotEqualTo(Integer value) {
            addCriterion("w.btype_user_id <>", value, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdGreaterThan(Integer value) {
            addCriterion("w.btype_user_id >", value, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("w.btype_user_id >=", value, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdLessThan(Integer value) {
            addCriterion("w.btype_user_id <", value, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("w.btype_user_id <=", value, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdIn(List<Integer> values) {
            addCriterion("w.btype_user_id in", values, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdNotIn(List<Integer> values) {
            addCriterion("w.btype_user_id not in", values, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdBetween(Integer value1, Integer value2) {
            addCriterion("w.btype_user_id between", value1, value2, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("w.btype_user_id not between", value1, value2, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameIsNull() {
            addCriterion("w.btype_user_name is null");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameIsNotNull() {
            addCriterion("w.btype_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameEqualTo(String value) {
            addCriterion("w.btype_user_name =", value, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameNotEqualTo(String value) {
            addCriterion("w.btype_user_name <>", value, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameGreaterThan(String value) {
            addCriterion("w.btype_user_name >", value, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("w.btype_user_name >=", value, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameLessThan(String value) {
            addCriterion("w.btype_user_name <", value, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameLessThanOrEqualTo(String value) {
            addCriterion("w.btype_user_name <=", value, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameLike(String value) {
            addCriterion("w.btype_user_name like", value, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameNotLike(String value) {
            addCriterion("w.btype_user_name not like", value, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameIn(List<String> values) {
            addCriterion("w.btype_user_name in", values, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameNotIn(List<String> values) {
            addCriterion("w.btype_user_name not in", values, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameBetween(String value1, String value2) {
            addCriterion("w.btype_user_name between", value1, value2, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameNotBetween(String value1, String value2) {
            addCriterion("w.btype_user_name not between", value1, value2, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("w.account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("w.account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Integer value) {
            addCriterion("w.account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Integer value) {
            addCriterion("w.account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Integer value) {
            addCriterion("w.account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("w.account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Integer value) {
            addCriterion("w.account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("w.account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Integer> values) {
            addCriterion("w.account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Integer> values) {
            addCriterion("w.account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("w.account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("w.account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("w.type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("w.type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("w.type_id =", value, "w.typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("w.type_id <>", value, "w.typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("w.type_id >", value, "w.typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("w.type_id >=", value, "w.typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("w.type_id <", value, "w.typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("w.type_id <=", value, "w.typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("w.type_id in", values, "w.typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("w.type_id not in", values, "w.typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("w.type_id between", value1, value2, "w.typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("w.type_id not between", value1, value2, "w.typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("w.type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("w.type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("w.type =", value, "w.type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("w.type <>", value, "w.type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("w.type >", value, "w.type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("w.type >=", value, "w.type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("w.type <", value, "w.type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("w.type <=", value, "w.type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("w.type in", values, "w.type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("w.type not in", values, "w.type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("w.type between", value1, value2, "w.type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("w.type not between", value1, value2, "w.type");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("w.user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("w.user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("w.user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("w.user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("w.user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("w.user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("w.user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("w.user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("w.user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("w.user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("w.user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("w.user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIdIsNull() {
            addCriterion("in_out_type_id is null");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIdIsNotNull() {
            addCriterion("in_out_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIdEqualTo(Integer value) {
            addCriterion("in_out_type_id =", value, "inOutTypeId");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIdNotEqualTo(Integer value) {
            addCriterion("in_out_type_id <>", value, "inOutTypeId");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIdGreaterThan(Integer value) {
            addCriterion("in_out_type_id >", value, "inOutTypeId");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_out_type_id >=", value, "inOutTypeId");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIdLessThan(Integer value) {
            addCriterion("in_out_type_id <", value, "inOutTypeId");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("in_out_type_id <=", value, "inOutTypeId");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIdIn(List<Integer> values) {
            addCriterion("in_out_type_id in", values, "inOutTypeId");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIdNotIn(List<Integer> values) {
            addCriterion("in_out_type_id not in", values, "inOutTypeId");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("in_out_type_id between", value1, value2, "inOutTypeId");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("in_out_type_id not between", value1, value2, "inOutTypeId");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIsNull() {
            addCriterion("in_out_type is null");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIsNotNull() {
            addCriterion("in_out_type is not null");
            return (Criteria) this;
        }

        public Criteria andInOutTypeEqualTo(Integer value) {
            addCriterion("in_out_type =", value, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNotEqualTo(Integer value) {
            addCriterion("in_out_type <>", value, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeGreaterThan(Integer value) {
            addCriterion("in_out_type >", value, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_out_type >=", value, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeLessThan(Integer value) {
            addCriterion("in_out_type <", value, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeLessThanOrEqualTo(Integer value) {
            addCriterion("in_out_type <=", value, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeIn(List<Integer> values) {
            addCriterion("in_out_type in", values, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNotIn(List<Integer> values) {
            addCriterion("in_out_type not in", values, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeBetween(Integer value1, Integer value2) {
            addCriterion("in_out_type between", value1, value2, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("in_out_type not between", value1, value2, "inOutType");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNameIsNull() {
            addCriterion("in_out_type_name is null");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNameIsNotNull() {
            addCriterion("in_out_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNameEqualTo(String value) {
            addCriterion("in_out_type_name =", value, "inOutTypeName");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNameNotEqualTo(String value) {
            addCriterion("in_out_type_name <>", value, "inOutTypeName");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNameGreaterThan(String value) {
            addCriterion("in_out_type_name >", value, "inOutTypeName");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("in_out_type_name >=", value, "inOutTypeName");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNameLessThan(String value) {
            addCriterion("in_out_type_name <", value, "inOutTypeName");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNameLessThanOrEqualTo(String value) {
            addCriterion("in_out_type_name <=", value, "inOutTypeName");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNameLike(String value) {
            addCriterion("in_out_type_name like", value, "inOutTypeName");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNameNotLike(String value) {
            addCriterion("in_out_type_name not like", value, "inOutTypeName");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNameIn(List<String> values) {
            addCriterion("in_out_type_name in", values, "inOutTypeName");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNameNotIn(List<String> values) {
            addCriterion("in_out_type_name not in", values, "inOutTypeName");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNameBetween(String value1, String value2) {
            addCriterion("in_out_type_name between", value1, value2, "inOutTypeName");
            return (Criteria) this;
        }

        public Criteria andInOutTypeNameNotBetween(String value1, String value2) {
            addCriterion("in_out_type_name not between", value1, value2, "inOutTypeName");
            return (Criteria) this;
        }

        public Criteria andPerPriceIsNull() {
            addCriterion("per_price is null");
            return (Criteria) this;
        }

        public Criteria andPerPriceIsNotNull() {
            addCriterion("per_price is not null");
            return (Criteria) this;
        }

        public Criteria andPerPriceEqualTo(BigDecimal value) {
            addCriterion("per_price =", value, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceNotEqualTo(BigDecimal value) {
            addCriterion("per_price <>", value, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceGreaterThan(BigDecimal value) {
            addCriterion("per_price >", value, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("per_price >=", value, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceLessThan(BigDecimal value) {
            addCriterion("per_price <", value, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("per_price <=", value, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceIn(List<BigDecimal> values) {
            addCriterion("per_price in", values, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceNotIn(List<BigDecimal> values) {
            addCriterion("per_price not in", values, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("per_price between", value1, value2, "perPrice");
            return (Criteria) this;
        }

        public Criteria andPerPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("per_price not between", value1, value2, "perPrice");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
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

        public Criteria andProductSpecNameIsNull() {
            addCriterion("product_spec_name is null");
            return (Criteria) this;
        }

        public Criteria andProductSpecNameIsNotNull() {
            addCriterion("product_spec_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductSpecNameEqualTo(String value) {
            addCriterion("product_spec_name =", value, "productSpecName");
            return (Criteria) this;
        }

        public Criteria andProductSpecNameNotEqualTo(String value) {
            addCriterion("product_spec_name <>", value, "productSpecName");
            return (Criteria) this;
        }

        public Criteria andProductSpecNameGreaterThan(String value) {
            addCriterion("product_spec_name >", value, "productSpecName");
            return (Criteria) this;
        }

        public Criteria andProductSpecNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_spec_name >=", value, "productSpecName");
            return (Criteria) this;
        }

        public Criteria andProductSpecNameLessThan(String value) {
            addCriterion("product_spec_name <", value, "productSpecName");
            return (Criteria) this;
        }

        public Criteria andProductSpecNameLessThanOrEqualTo(String value) {
            addCriterion("product_spec_name <=", value, "productSpecName");
            return (Criteria) this;
        }

        public Criteria andProductSpecNameLike(String value) {
            addCriterion("product_spec_name like", value, "productSpecName");
            return (Criteria) this;
        }

        public Criteria andProductSpecNameNotLike(String value) {
            addCriterion("product_spec_name not like", value, "productSpecName");
            return (Criteria) this;
        }

        public Criteria andProductSpecNameIn(List<String> values) {
            addCriterion("product_spec_name in", values, "productSpecName");
            return (Criteria) this;
        }

        public Criteria andProductSpecNameNotIn(List<String> values) {
            addCriterion("product_spec_name not in", values, "productSpecName");
            return (Criteria) this;
        }

        public Criteria andProductSpecNameBetween(String value1, String value2) {
            addCriterion("product_spec_name between", value1, value2, "productSpecName");
            return (Criteria) this;
        }

        public Criteria andProductSpecNameNotBetween(String value1, String value2) {
            addCriterion("product_spec_name not between", value1, value2, "productSpecName");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("w.create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("w.create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("w.create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("w.create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("w.create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("w.create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("w.create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("w.create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("w.create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("w.create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("w.create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("w.create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }


        public Criteria andDealTimeIsNull() {
            addCriterion("w.deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("w.deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(Date value) {
            addCriterion("w.deal_time =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(Date value) {
            addCriterion("w.deal_time <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(Date value) {
            addCriterion("w.deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("w.deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(Date value) {
            addCriterion("w.deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(Date value) {
            addCriterion("w.deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<Date> values) {
            addCriterion("w.deal_time in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<Date> values) {
            addCriterion("w.deal_time not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(Date value1, Date value2) {
            addCriterion("w.deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(Date value1, Date value2) {
            addCriterion("w.deal_time not between", value1, value2, "dealTime");
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