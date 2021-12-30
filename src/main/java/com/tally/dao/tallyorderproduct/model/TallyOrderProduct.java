package com.tally.dao.tallyorderproduct.model;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 订单产品规格关系表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyOrderProduct {

    private Integer id;

    private Integer orderId;

    private Integer productId;

    private String productName;

    private String productNo;

    private Integer productSpecId;

    private String productSpecName;

    private BigDecimal specPrice;

    private Integer specNum;

    private String createTime;

}