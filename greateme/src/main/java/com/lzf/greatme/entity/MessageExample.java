package com.lzf.greatme.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andMessageKeyIsNull() {
            addCriterion("message_key is null");
            return (Criteria) this;
        }

        public Criteria andMessageKeyIsNotNull() {
            addCriterion("message_key is not null");
            return (Criteria) this;
        }

        public Criteria andMessageKeyEqualTo(String value) {
            addCriterion("message_key =", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyNotEqualTo(String value) {
            addCriterion("message_key <>", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyGreaterThan(String value) {
            addCriterion("message_key >", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyGreaterThanOrEqualTo(String value) {
            addCriterion("message_key >=", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyLessThan(String value) {
            addCriterion("message_key <", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyLessThanOrEqualTo(String value) {
            addCriterion("message_key <=", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyLike(String value) {
            addCriterion("message_key like", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyNotLike(String value) {
            addCriterion("message_key not like", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyIn(List<String> values) {
            addCriterion("message_key in", values, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyNotIn(List<String> values) {
            addCriterion("message_key not in", values, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyBetween(String value1, String value2) {
            addCriterion("message_key between", value1, value2, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyNotBetween(String value1, String value2) {
            addCriterion("message_key not between", value1, value2, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageDateIsNull() {
            addCriterion("message_date is null");
            return (Criteria) this;
        }

        public Criteria andMessageDateIsNotNull() {
            addCriterion("message_date is not null");
            return (Criteria) this;
        }

        public Criteria andMessageDateEqualTo(Date value) {
            addCriterion("message_date =", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateNotEqualTo(Date value) {
            addCriterion("message_date <>", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateGreaterThan(Date value) {
            addCriterion("message_date >", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateGreaterThanOrEqualTo(Date value) {
            addCriterion("message_date >=", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateLessThan(Date value) {
            addCriterion("message_date <", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateLessThanOrEqualTo(Date value) {
            addCriterion("message_date <=", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateIn(List<Date> values) {
            addCriterion("message_date in", values, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateNotIn(List<Date> values) {
            addCriterion("message_date not in", values, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateBetween(Date value1, Date value2) {
            addCriterion("message_date between", value1, value2, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateNotBetween(Date value1, Date value2) {
            addCriterion("message_date not between", value1, value2, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageMasterIsNull() {
            addCriterion("message_master is null");
            return (Criteria) this;
        }

        public Criteria andMessageMasterIsNotNull() {
            addCriterion("message_master is not null");
            return (Criteria) this;
        }

        public Criteria andMessageMasterEqualTo(Integer value) {
            addCriterion("message_master =", value, "messageMaster");
            return (Criteria) this;
        }

        public Criteria andMessageMasterNotEqualTo(Integer value) {
            addCriterion("message_master <>", value, "messageMaster");
            return (Criteria) this;
        }

        public Criteria andMessageMasterGreaterThan(Integer value) {
            addCriterion("message_master >", value, "messageMaster");
            return (Criteria) this;
        }

        public Criteria andMessageMasterGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_master >=", value, "messageMaster");
            return (Criteria) this;
        }

        public Criteria andMessageMasterLessThan(Integer value) {
            addCriterion("message_master <", value, "messageMaster");
            return (Criteria) this;
        }

        public Criteria andMessageMasterLessThanOrEqualTo(Integer value) {
            addCriterion("message_master <=", value, "messageMaster");
            return (Criteria) this;
        }

        public Criteria andMessageMasterIn(List<Integer> values) {
            addCriterion("message_master in", values, "messageMaster");
            return (Criteria) this;
        }

        public Criteria andMessageMasterNotIn(List<Integer> values) {
            addCriterion("message_master not in", values, "messageMaster");
            return (Criteria) this;
        }

        public Criteria andMessageMasterBetween(Integer value1, Integer value2) {
            addCriterion("message_master between", value1, value2, "messageMaster");
            return (Criteria) this;
        }

        public Criteria andMessageMasterNotBetween(Integer value1, Integer value2) {
            addCriterion("message_master not between", value1, value2, "messageMaster");
            return (Criteria) this;
        }

        public Criteria andIsLockedIsNull() {
            addCriterion("is_locked is null");
            return (Criteria) this;
        }

        public Criteria andIsLockedIsNotNull() {
            addCriterion("is_locked is not null");
            return (Criteria) this;
        }

        public Criteria andIsLockedEqualTo(Integer value) {
            addCriterion("is_locked =", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedNotEqualTo(Integer value) {
            addCriterion("is_locked <>", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedGreaterThan(Integer value) {
            addCriterion("is_locked >", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_locked >=", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedLessThan(Integer value) {
            addCriterion("is_locked <", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedLessThanOrEqualTo(Integer value) {
            addCriterion("is_locked <=", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedIn(List<Integer> values) {
            addCriterion("is_locked in", values, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedNotIn(List<Integer> values) {
            addCriterion("is_locked not in", values, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedBetween(Integer value1, Integer value2) {
            addCriterion("is_locked between", value1, value2, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_locked not between", value1, value2, "isLocked");
            return (Criteria) this;
        }

        public Criteria andMessagePasswordIsNull() {
            addCriterion("message_password is null");
            return (Criteria) this;
        }

        public Criteria andMessagePasswordIsNotNull() {
            addCriterion("message_password is not null");
            return (Criteria) this;
        }

        public Criteria andMessagePasswordEqualTo(String value) {
            addCriterion("message_password =", value, "messagePassword");
            return (Criteria) this;
        }

        public Criteria andMessagePasswordNotEqualTo(String value) {
            addCriterion("message_password <>", value, "messagePassword");
            return (Criteria) this;
        }

        public Criteria andMessagePasswordGreaterThan(String value) {
            addCriterion("message_password >", value, "messagePassword");
            return (Criteria) this;
        }

        public Criteria andMessagePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("message_password >=", value, "messagePassword");
            return (Criteria) this;
        }

        public Criteria andMessagePasswordLessThan(String value) {
            addCriterion("message_password <", value, "messagePassword");
            return (Criteria) this;
        }

        public Criteria andMessagePasswordLessThanOrEqualTo(String value) {
            addCriterion("message_password <=", value, "messagePassword");
            return (Criteria) this;
        }

        public Criteria andMessagePasswordLike(String value) {
            addCriterion("message_password like", value, "messagePassword");
            return (Criteria) this;
        }

        public Criteria andMessagePasswordNotLike(String value) {
            addCriterion("message_password not like", value, "messagePassword");
            return (Criteria) this;
        }

        public Criteria andMessagePasswordIn(List<String> values) {
            addCriterion("message_password in", values, "messagePassword");
            return (Criteria) this;
        }

        public Criteria andMessagePasswordNotIn(List<String> values) {
            addCriterion("message_password not in", values, "messagePassword");
            return (Criteria) this;
        }

        public Criteria andMessagePasswordBetween(String value1, String value2) {
            addCriterion("message_password between", value1, value2, "messagePassword");
            return (Criteria) this;
        }

        public Criteria andMessagePasswordNotBetween(String value1, String value2) {
            addCriterion("message_password not between", value1, value2, "messagePassword");
            return (Criteria) this;
        }

        public Criteria andMasterNameIsNull() {
            addCriterion("master_name is null");
            return (Criteria) this;
        }

        public Criteria andMasterNameIsNotNull() {
            addCriterion("master_name is not null");
            return (Criteria) this;
        }

        public Criteria andMasterNameEqualTo(String value) {
            addCriterion("master_name =", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameNotEqualTo(String value) {
            addCriterion("master_name <>", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameGreaterThan(String value) {
            addCriterion("master_name >", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameGreaterThanOrEqualTo(String value) {
            addCriterion("master_name >=", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameLessThan(String value) {
            addCriterion("master_name <", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameLessThanOrEqualTo(String value) {
            addCriterion("master_name <=", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameLike(String value) {
            addCriterion("master_name like", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameNotLike(String value) {
            addCriterion("master_name not like", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameIn(List<String> values) {
            addCriterion("master_name in", values, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameNotIn(List<String> values) {
            addCriterion("master_name not in", values, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameBetween(String value1, String value2) {
            addCriterion("master_name between", value1, value2, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameNotBetween(String value1, String value2) {
            addCriterion("master_name not between", value1, value2, "masterName");
            return (Criteria) this;
        }

        public Criteria andIsPublicIsNull() {
            addCriterion("is_public is null");
            return (Criteria) this;
        }

        public Criteria andIsPublicIsNotNull() {
            addCriterion("is_public is not null");
            return (Criteria) this;
        }

        public Criteria andIsPublicEqualTo(Integer value) {
            addCriterion("is_public =", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicNotEqualTo(Integer value) {
            addCriterion("is_public <>", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicGreaterThan(Integer value) {
            addCriterion("is_public >", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_public >=", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicLessThan(Integer value) {
            addCriterion("is_public <", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicLessThanOrEqualTo(Integer value) {
            addCriterion("is_public <=", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicIn(List<Integer> values) {
            addCriterion("is_public in", values, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicNotIn(List<Integer> values) {
            addCriterion("is_public not in", values, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicBetween(Integer value1, Integer value2) {
            addCriterion("is_public between", value1, value2, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicNotBetween(Integer value1, Integer value2) {
            addCriterion("is_public not between", value1, value2, "isPublic");
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