package com.tally.api.inputDto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 账户流水明细
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@Data
public class WaterDetailInputDto {

    private Integer inOutTypeId;

    private Integer inOutType;

    private Integer type;

    private String inOutTypeName;

    private BigDecimal perPrice;

    private Integer number;

    private BigDecimal amout;

    private Integer productId;

    private Integer productSpecId;

    private String productSpecName;

    private String remark;

    private Integer userId;

    private Integer accountId;

}