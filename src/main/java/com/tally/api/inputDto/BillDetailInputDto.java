package com.tally.api.inputDto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 账单明细
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@Data
public class BillDetailInputDto {

    private Integer productId;

    private Integer specId;

    private String name;

    private BigDecimal specPrice;

    private Integer number;

    private BigDecimal amount;

    private BigDecimal settledAmount;

}