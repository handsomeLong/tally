package com.tally.dao.tallybillreceivable.model;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 应收账单
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyBillReceivable {

    private Integer id;

    private Integer userId;

    private Integer debtorId;

    private BigDecimal amount;

    private BigDecimal successAmount;

    private Integer status;

    private Integer orderId;

    private String orderNo;

    private String createTime;

}