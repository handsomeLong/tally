package com.tally.dao.tallybillpayable.model;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 应付账单
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyBillPayable {

    private Integer id;

    private Integer userId;

    private Integer creditorId;

    private Integer orderId;

    private String orderNo;

    private BigDecimal amount;

    private BigDecimal successAmount;

    private String createTime;

    private Integer status;

}