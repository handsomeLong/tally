package com.tally.api.inputDto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderProductInputDto {

    private Integer productId;

    private String productNo;

    private String productName;

    private Integer productSpecId;

    private String specName;

    private BigDecimal specPrice;

    private Integer specNum;

}
