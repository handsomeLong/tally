package com.tally.api.inputDto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public  class ProductSpecInputDto {

    private Integer specId;

    private String specName;

    private String specImages;

    private String specSerial;

    private Integer specStorage;

    private Integer number;

    private BigDecimal specCostPrice;

    private BigDecimal specPrice;

    private BigDecimal specStockPrice;

    private  String  specUnit;

    private  String remark;

}
