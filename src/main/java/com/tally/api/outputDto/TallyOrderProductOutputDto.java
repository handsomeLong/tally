package com.tally.api.outputDto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyOrderProductOutputDto {

    private Integer id;

    private Integer orderId;

    private Integer productId;

    private String  productName;

    private String  productNo;

    private Integer productSpecId;

    private  String  productSpecName;

    private BigDecimal specPrice;

    private Integer specNumFinsh;

    private Integer specNum;

    private String createTime;

}