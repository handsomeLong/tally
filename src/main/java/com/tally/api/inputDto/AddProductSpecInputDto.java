package com.tally.api.inputDto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 产品表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public  class AddProductSpecInputDto {

    private  String productId;

    private String specName;

    private String specImages;

    private String specSerial;

    private Integer specStorage;

    private BigDecimal specCostPrice;

}
