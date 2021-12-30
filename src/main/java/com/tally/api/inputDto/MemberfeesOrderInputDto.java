package com.tally.api.inputDto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 会员缴费订单
 * @author 131****2893
 * @date 2020/10/31 21:47
 */
@Data
public class MemberfeesOrderInputDto {


    private Integer comboId;

    private BigDecimal amount;

    private Integer period;

    private String remark;

    private Integer payWay;
}