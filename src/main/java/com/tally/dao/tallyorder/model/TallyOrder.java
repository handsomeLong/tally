package com.tally.dao.tallyorder.model;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 订单表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyOrder {

    private Integer id;

    private String orderNo;

    private BigDecimal totalPrice;

    private BigDecimal amount;

    private BigDecimal discout;

    private BigDecimal successAmount;

    private Integer payWay;

    private Integer userId;

    private  String buyerName;

    private Integer buyerId;

    private String remark;

    private Integer status;

    private  Integer settleAccountId;//结算账户

    private  Integer orderType;

    private String createTime;

}