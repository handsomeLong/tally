package com.tally.dao.tallyuserfriends.model;

import java.util.ArrayList;
import java.util.List;

public class TallyUserFriendsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TallyUserFriendsExample() {
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

        public Criteria andFriendsIdIsNull() {
            addCriterion("friends_id is null");
            return (Criteria) this;
        }

        public Criteria andFriendsIdIsNotNull() {
            addCriterion("friends_id is not null");
            return (Criteria) this;
        }

        public Criteria andFriendsIdEqualTo(Integer value) {
            addCriterion("friends_id =", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdNotEqualTo(Integer value) {
            addCriterion("friends_id <>", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdGreaterThan(Integer value) {
            addCriterion("friends_id >", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("friends_id >=", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdLessThan(Integer value) {
            addCriterion("friends_id <", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdLessThanOrEqualTo(Integer value) {
            addCriterion("friends_id <=", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdIn(List<Integer> values) {
            addCriterion("friends_id in", values, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdNotIn(List<Integer> values) {
            addCriterion("friends_id not in", values, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdBetween(Integer value1, Integer value2) {
            addCriterion("friends_id between", value1, value2, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("friends_id not between", value1, value2, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsNickNameIsNull() {
            addCriterion("friends_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andFriendsNickNameIsNotNull() {
            addCriterion("friends_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andFriendsNickNameEqualTo(String value) {
            addCriterion("friends_nick_name =", value, "friendsNickName");
            return (Criteria) this;
        }

        public Criteria andFriendsNickNameNotEqualTo(String value) {
            addCriterion("friends_nick_name <>", value, "friendsNickName");
            return (Criteria) this;
        }

        public Criteria andFriendsNickNameGreaterThan(String value) {
            addCriterion("friends_nick_name >", value, "friendsNickName");
            return (Criteria) this;
        }

        public Criteria andFriendsNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("friends_nick_name >=", value, "friendsNickName");
            return (Criteria) this;
        }

        public Criteria andFriendsNickNameLessThan(String value) {
            addCriterion("friends_nick_name <", value, "friendsNickName");
            return (Criteria) this;
        }

        public Criteria andFriendsNickNameLessThanOrEqualTo(String value) {
            addCriterion("friends_nick_name <=", value, "friendsNickName");
            return (Criteria) this;
        }

        public Criteria andFriendsNickNameLike(String value) {
            addCriterion("friends_nick_name like", value, "friendsNickName");
            return (Criteria) this;
        }

        public Criteria andFriendsNickNameNotLike(String value) {
            addCriterion("friends_nick_name not like", value, "friendsNickName");
            return (Criteria) this;
        }

        public Criteria andFriendsNickNameIn(List<String> values) {
            addCriterion("friends_nick_name in", values, "friendsNickName");
            return (Criteria) this;
        }

        public Criteria andFriendsNickNameNotIn(List<String> values) {
            addCriterion("friends_nick_name not in", values, "friendsNickName");
            return (Criteria) this;
        }

        public Criteria andFriendsNickNameBetween(String value1, String value2) {
            addCriterion("friends_nick_name between", value1, value2, "friendsNickName");
            return (Criteria) this;
        }

        public Criteria andFriendsNickNameNotBetween(String value1, String value2) {
            addCriterion("friends_nick_name not between", value1, value2, "friendsNickName");
            return (Criteria) this;
        }

        public Criteria andFriendsHeadImageIsNull() {
            addCriterion("friends_head_image is null");
            return (Criteria) this;
        }

        public Criteria andFriendsHeadImageIsNotNull() {
            addCriterion("friends_head_image is not null");
            return (Criteria) this;
        }

        public Criteria andFriendsHeadImageEqualTo(String value) {
            addCriterion("friends_head_image =", value, "friendsHeadImage");
            return (Criteria) this;
        }

        public Criteria andFriendsHeadImageNotEqualTo(String value) {
            addCriterion("friends_head_image <>", value, "friendsHeadImage");
            return (Criteria) this;
        }

        public Criteria andFriendsHeadImageGreaterThan(String value) {
            addCriterion("friends_head_image >", value, "friendsHeadImage");
            return (Criteria) this;
        }

        public Criteria andFriendsHeadImageGreaterThanOrEqualTo(String value) {
            addCriterion("friends_head_image >=", value, "friendsHeadImage");
            return (Criteria) this;
        }

        public Criteria andFriendsHeadImageLessThan(String value) {
            addCriterion("friends_head_image <", value, "friendsHeadImage");
            return (Criteria) this;
        }

        public Criteria andFriendsHeadImageLessThanOrEqualTo(String value) {
            addCriterion("friends_head_image <=", value, "friendsHeadImage");
            return (Criteria) this;
        }

        public Criteria andFriendsHeadImageLike(String value) {
            addCriterion("friends_head_image like", value, "friendsHeadImage");
            return (Criteria) this;
        }

        public Criteria andFriendsHeadImageNotLike(String value) {
            addCriterion("friends_head_image not like", value, "friendsHeadImage");
            return (Criteria) this;
        }

        public Criteria andFriendsHeadImageIn(List<String> values) {
            addCriterion("friends_head_image in", values, "friendsHeadImage");
            return (Criteria) this;
        }

        public Criteria andFriendsHeadImageNotIn(List<String> values) {
            addCriterion("friends_head_image not in", values, "friendsHeadImage");
            return (Criteria) this;
        }

        public Criteria andFriendsHeadImageBetween(String value1, String value2) {
            addCriterion("friends_head_image between", value1, value2, "friendsHeadImage");
            return (Criteria) this;
        }

        public Criteria andFriendsHeadImageNotBetween(String value1, String value2) {
            addCriterion("friends_head_image not between", value1, value2, "friendsHeadImage");
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