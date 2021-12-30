package com.tally.api.inputDto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 产品出入库明细
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@Data
public class ProductOutAndInDetailDto {

    private Integer productId;

    private String specId;

    private String number;

}