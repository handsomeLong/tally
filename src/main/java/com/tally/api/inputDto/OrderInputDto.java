package com.tally.api.inputDto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class OrderInputDto {

    private Integer payWay;

    private Integer userId;

    private Integer buyerId;

    private String buyerName;

    private String remark;

    private BigDecimal totalPrice;

    private BigDecimal amount;

    private  BigDecimal discout;

    private  Integer  isComplete;

    private  Integer accountId;

    private  Integer orderType;

    private List<OrderProductInputDto> list;
}
