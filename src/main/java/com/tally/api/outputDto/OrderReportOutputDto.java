package com.tally.api.outputDto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单统计
 * @author 131****2893
 * @date 2021/01/08 14:39
 */
@Data
public class OrderReportOutputDto {

    private BigDecimal amount;

    private  Integer productNum;

    private  String  productName;

    private String  buyerName;

    private Integer  buyerId;

    private String  userName;

    private String sellerName;

    private Integer sort;

}