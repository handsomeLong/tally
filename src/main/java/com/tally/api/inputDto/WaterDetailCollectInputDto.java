package com.tally.api.inputDto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 账户流水明细
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@Data
public class WaterDetailCollectInputDto {

    private Integer userId;

    private String accountTypeCode;

}