package com.tally.dao.tallyproductspec.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 产品规格表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TallyProductSpec {

    private Integer id;

    private Integer productId;

    private String specName;

    private String specImages;

    private String specSerial;

    private  String  specUnit;

    private Integer specStorage;

    private Integer specStorageFreeze;

    private BigDecimal specPrice;

    private BigDecimal specStockPrice;

    private BigDecimal specCostPrice;

    private  String remark;

    private Integer isDel;

}