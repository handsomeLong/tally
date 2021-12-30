package com.tally.dao.tallybill.model;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

public class TallyBillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TallyBillExample() {
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

        public Criteria andBtypeUserIdIsNull() {
            addCriterion("btype_user_id is null");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdIsNotNull() {
            addCriterion("btype_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdEqualTo(Integer value) {
            addCriterion("btype_user_id =", value, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdNotEqualTo(Integer value) {
            addCriterion("btype_user_id <>", value, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdGreaterThan(Integer value) {
            addCriterion("btype_user_id >", value, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("btype_user_id >=", value, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdLessThan(Integer value) {
            addCriterion("btype_user_id <", value, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("btype_user_id <=", value, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdIn(List<Integer> values) {
            addCriterion("btype_user_id in", values, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdNotIn(List<Integer> values) {
            addCriterion("btype_user_id not in", values, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdBetween(Integer value1, Integer value2) {
            addCriterion("btype_user_id between", value1, value2, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("btype_user_id not between", value1, value2, "btypeUserId");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameIsNull() {
            addCriterion("btype_user_name is null");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameIsNotNull() {
            addCriterion("btype_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameEqualTo(String value) {
            addCriterion("btype_user_name =", value, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameNotEqualTo(String value) {
            addCriterion("btype_user_name <>", value, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameGreaterThan(String value) {
            addCriterion("btype_user_name >", value, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("btype_user_name >=", value, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameLessThan(String value) {
            addCriterion("btype_user_name <", value, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameLessThanOrEqualTo(String value) {
            addCriterion("btype_user_name <=", value, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameLike(String value) {
            addCriterion("btype_user_name like", value, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameNotLike(String value) {
            addCriterion("btype_user_name not like", value, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameIn(List<String> values) {
            addCriterion("btype_user_name in", values, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameNotIn(List<String> values) {
            addCriterion("btype_user_name not in", values, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameBetween(String value1, String value2) {
            addCriterion("btype_user_name between", value1, value2, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeUserNameNotBetween(String value1, String value2) {
            addCriterion("btype_user_name not between", value1, value2, "btypeUserName");
            return (Criteria) this;
        }

        public Criteria andBtypeMobileIsNull() {
            addCriterion("btype_mobile is null");
            return (Criteria) this;
        }

        public Criteria andBtypeMobileIsNotNull() {
            addCriterion("btype_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andBtypeMobileEqualTo(String value) {
            addCriterion("btype_mobile =", value, "btypeMobile");
            return (Criteria) this;
        }

        public Criteria andBtypeMobileNotEqualTo(String value) {
            addCriterion("btype_mobile <>", value, "btypeMobile");
            return (Criteria) this;
        }

        public Criteria andBtypeMobileGreaterThan(String value) {
            addCriterion("btype_mobile >", value, "btypeMobile");
            return (Criteria) this;
        }

        public Criteria andBtypeMobileGreaterThanOrEqualTo(String value) {
            addCriterion("btype_mobile >=", value, "btypeMobile");
            return (Criteria) this;
        }

        public Criteria andBtypeMobileLessThan(String value) {
            addCriterion("btype_mobile <", value, "btypeMobile");
            return (Criteria) this;
        }

        public Criteria andBtypeMobileLessThanOrEqualTo(String value) {
            addCriterion("btype_mobile <=", value, "btypeMobile");
            return (Criteria) this;
        }

        public Criteria andBtypeMobileLike(String value) {
            addCriterion("btype_mobile like", value, "btypeMobile");
            return (Criteria) this;
        }

        public Criteria andBtypeMobileNotLike(String value) {
            addCriterion("btype_mobile not like", value, "btypeMobile");
            return (Criteria) this;
        }

        public Criteria andBtypeMobileIn(List<String> values) {
            addCriterion("btype_mobile in", values, "btypeMobile");
            return (Criteria) this;
        }

        public Criteria andBtypeMobileNotIn(List<String> values) {
            addCriterion("btype_mobile not in", values, "btypeMobile");
            return (Criteria) this;
        }

        public Criteria andBtypeMobileBetween(String value1, String value2) {
            addCriterion("btype_mobile between", value1, value2, "btypeMobile");
            return (Criteria) this;
        }

        public Criteria andBtypeMobileNotBetween(String value1, String value2) {
            addCriterion("btype_mobile not between", value1, value2, "btypeMobile");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(BigDecimal value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(BigDecimal value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<BigDecimal> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andSettleAmountIsNull() {
            addCriterion("settle_amount is null");
            return (Criteria) this;
        }

        public Criteria andSettleAmountIsNotNull() {
            addCriterion("settle_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSettleAmountEqualTo(BigDecimal value) {
            addCriterion("settle_amount =", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotEqualTo(BigDecimal value) {
            addCriterion("settle_amount <>", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountGreaterThan(BigDecimal value) {
            addCriterion("settle_amount >", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("settle_amount >=", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountLessThan(BigDecimal value) {
            addCriterion("settle_amount <", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("settle_amount <=", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountIn(List<BigDecimal> values) {
            addCriterion("settle_amount in", values, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotIn(List<BigDecimal> values) {
            addCriterion("settle_amount not in", values, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settle_amount between", value1, value2, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settle_amount not between", value1, value2, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andTotalNumberIsNull() {
            addCriterion("total_number is null");
            return (Criteria) this;
        }

        public Criteria andTotalNumberIsNotNull() {
            addCriterion("total_number is not null");
            return (Criteria) this;
        }

        public Criteria andTotalNumberEqualTo(Integer value) {
            addCriterion("total_number =", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberNotEqualTo(Integer value) {
            addCriterion("total_number <>", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberGreaterThan(Integer value) {
            addCriterion("total_number >", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_number >=", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberLessThan(Integer value) {
            addCriterion("total_number <", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberLessThanOrEqualTo(Integer value) {
            addCriterion("total_number <=", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberIn(List<Integer> values) {
            addCriterion("total_number in", values, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberNotIn(List<Integer> values) {
            addCriterion("total_number not in", values, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberBetween(Integer value1, Integer value2) {
            addCriterion("total_number between", value1, value2, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("total_number not between", value1, value2, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andSettleNumberIsNull() {
            addCriterion("settle_number is null");
            return (Criteria) this;
        }

        public Criteria andSettleNumberIsNotNull() {
            addCriterion("settle_number is not null");
            return (Criteria) this;
        }

        public Criteria andSettleNumberEqualTo(Integer value) {
            addCriterion("settle_number =", value, "settleNumber");
            return (Criteria) this;
        }

        public Criteria andSettleNumberNotEqualTo(Integer value) {
            addCriterion("settle_number <>", value, "settleNumber");
            return (Criteria) this;
        }

        public Criteria andSettleNumberGreaterThan(Integer value) {
            addCriterion("settle_number >", value, "settleNumber");
            return (Criteria) this;
        }

        public Criteria andSettleNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("settle_number >=", value, "settleNumber");
            return (Criteria) this;
        }

        public Criteria andSettleNumberLessThan(Integer value) {
            addCriterion("settle_number <", value, "settleNumber");
            return (Criteria) this;
        }

        public Criteria andSettleNumberLessThanOrEqualTo(Integer value) {
            addCriterion("settle_number <=", value, "settleNumber");
            return (Criteria) this;
        }

        public Criteria andSettleNumberIn(List<Integer> values) {
            addCriterion("settle_number in", values, "settleNumber");
            return (Criteria) this;
        }

        public Criteria andSettleNumberNotIn(List<Integer> values) {
            addCriterion("settle_number not in", values, "settleNumber");
            return (Criteria) this;
        }

        public Criteria andSettleNumberBetween(Integer value1, Integer value2) {
            addCriterion("settle_number between", value1, value2, "settleNumber");
            return (Criteria) this;
        }

        public Criteria andSettleNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("settle_number not between", value1, value2, "settleNumber");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNull() {
            addCriterion("user_mobile is null");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNotNull() {
            addCriterion("user_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andUserMobileEqualTo(String value) {
            addCriterion("user_mobile =", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotEqualTo(String value) {
            addCriterion("user_mobile <>", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThan(String value) {
            addCriterion("user_mobile >", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThanOrEqualTo(String value) {
            addCriterion("user_mobile >=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThan(String value) {
            addCriterion("user_mobile <", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThanOrEqualTo(String value) {
            addCriterion("user_mobile <=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLike(String value) {
            addCriterion("user_mobile like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotLike(String value) {
            addCriterion("user_mobile not like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileIn(List<String> values) {
            addCriterion("user_mobile in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotIn(List<String> values) {
            addCriterion("user_mobile not in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileBetween(String value1, String value2) {
            addCriterion("user_mobile between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotBetween(String value1, String value2) {
            addCriterion("user_mobile not between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andBooksIdIsNull() {
            addCriterion("books_id is null");
            return (Criteria) this;
        }

        public Criteria andBooksIdIsNotNull() {
            addCriterion("books_id is not null");
            return (Criteria) this;
        }

        public Criteria andBooksIdEqualTo(Integer value) {
            addCriterion("books_id =", value, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdNotEqualTo(Integer value) {
            addCriterion("books_id <>", value, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdGreaterThan(Integer value) {
            addCriterion("books_id >", value, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("books_id >=", value, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdLessThan(Integer value) {
            addCriterion("books_id <", value, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdLessThanOrEqualTo(Integer value) {
            addCriterion("books_id <=", value, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdIn(List<Integer> values) {
            addCriterion("books_id in", values, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdNotIn(List<Integer> values) {
            addCriterion("books_id not in", values, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdBetween(Integer value1, Integer value2) {
            addCriterion("books_id between", value1, value2, "booksId");
            return (Criteria) this;
        }

        public Criteria andBooksIdNotBetween(Integer value1, Integer value2) {
            addCriterion("books_id not between", value1, value2, "booksId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(Integer value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(Integer value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(Integer value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(Integer value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(Integer value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<Integer> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<Integer> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(Integer value1, Integer value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(Integer value1, Integer value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andAuitStatusIsNull() {
            addCriterion("auit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuitStatusIsNotNull() {
            addCriterion("auit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuitStatusEqualTo(Integer value) {
            addCriterion("auit_status =", value, "auitStatus");
            return (Criteria) this;
        }

        public Criteria andAuitStatusNotEqualTo(Integer value) {
            addCriterion("auit_status <>", value, "auitStatus");
            return (Criteria) this;
        }

        public Criteria andAuitStatusGreaterThan(Integer value) {
            addCriterion("auit_status >", value, "auitStatus");
            return (Criteria) this;
        }

        public Criteria andAuitStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("auit_status >=", value, "auitStatus");
            return (Criteria) this;
        }

        public Criteria andAuitStatusLessThan(Integer value) {
            addCriterion("auit_status <", value, "auitStatus");
            return (Criteria) this;
        }

        public Criteria andAuitStatusLessThanOrEqualTo(Integer value) {
            addCriterion("auit_status <=", value, "auitStatus");
            return (Criteria) this;
        }

        public Criteria andAuitStatusIn(List<Integer> values) {
            addCriterion("auit_status in", values, "auitStatus");
            return (Criteria) this;
        }

        public Criteria andAuitStatusNotIn(List<Integer> values) {
            addCriterion("auit_status not in", values, "auitStatus");
            return (Criteria) this;
        }

        public Criteria andAuitStatusBetween(Integer value1, Integer value2) {
            addCriterion("auit_status between", value1, value2, "auitStatus");
            return (Criteria) this;
        }

        public Criteria andAuitStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("auit_status not between", value1, value2, "auitStatus");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andAttachIsNull() {
            addCriterion("attach is null");
            return (Criteria) this;
        }

        public Criteria andAttachIsNotNull() {
            addCriterion("attach is not null");
            return (Criteria) this;
        }

        public Criteria andAttachEqualTo(String value) {
            addCriterion("attach =", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachNotEqualTo(String value) {
            addCriterion("attach <>", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachGreaterThan(String value) {
            addCriterion("attach >", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachGreaterThanOrEqualTo(String value) {
            addCriterion("attach >=", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachLessThan(String value) {
            addCriterion("attach <", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachLessThanOrEqualTo(String value) {
            addCriterion("attach <=", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachLike(String value) {
            addCriterion("attach like", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachNotLike(String value) {
            addCriterion("attach not like", value, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachIn(List<String> values) {
            addCriterion("attach in", values, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachNotIn(List<String> values) {
            addCriterion("attach not in", values, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachBetween(String value1, String value2) {
            addCriterion("attach between", value1, value2, "attach");
            return (Criteria) this;
        }

        public Criteria andAttachNotBetween(String value1, String value2) {
            addCriterion("attach not between", value1, value2, "attach");
            return (Criteria) this;
        }

        public Criteria andIsMaterialIsNull() {
            addCriterion("is_material is null");
            return (Criteria) this;
        }

        public Criteria andIsMaterialIsNotNull() {
            addCriterion("is_material is not null");
            return (Criteria) this;
        }

        public Criteria andIsMaterialEqualTo(Integer value) {
            addCriterion("is_material =", value, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialNotEqualTo(Integer value) {
            addCriterion("is_material <>", value, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialGreaterThan(Integer value) {
            addCriterion("is_material >", value, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_material >=", value, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialLessThan(Integer value) {
            addCriterion("is_material <", value, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialLessThanOrEqualTo(Integer value) {
            addCriterion("is_material <=", value, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialIn(List<Integer> values) {
            addCriterion("is_material in", values, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialNotIn(List<Integer> values) {
            addCriterion("is_material not in", values, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialBetween(Integer value1, Integer value2) {
            addCriterion("is_material between", value1, value2, "isMaterial");
            return (Criteria) this;
        }

        public Criteria andIsMaterialNotBetween(Integer value1, Integer value2) {
            addCriterion("is_material not between", value1, value2, "isMaterial");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(String value) {
            addCriterion("deal_time =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(String value) {
            addCriterion("deal_time <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(String value) {
            addCriterion("deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(String value) {
            addCriterion("deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(String value) {
            addCriterion("deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(String value) {
            addCriterion("deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLike(String value) {
            addCriterion("deal_time like", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotLike(String value) {
            addCriterion("deal_time not like", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<String> values) {
            addCriterion("deal_time in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<String> values) {
            addCriterion("deal_time not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(String value1, String value2) {
            addCriterion("deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(String value1, String value2) {
            addCriterion("deal_time not between", value1, value2, "dealTime");
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