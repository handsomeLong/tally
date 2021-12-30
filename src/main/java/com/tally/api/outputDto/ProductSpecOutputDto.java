package com.tally.api.outputDto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public  class ProductSpecOutputDto {

    private String productName;

    private String productNo;

    private Integer productId;

    private String specName;

    private String specImages;

    private String specId;

    private String specSerial;

    private Integer specStorage;

    private BigDecimal specCostPrice;

    private BigDecimal specStockPrice;

    private BigDecimal specPrice;

    private  String  specUnit;


}
