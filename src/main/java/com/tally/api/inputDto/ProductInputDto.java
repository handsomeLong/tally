package com.tally.api.inputDto;

import lombok.Data;

/**
 * 产品
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class ProductInputDto {

    private Integer orderId;

    private String orderNo;

    private Integer productId;

    private String productName;

    private String productNo;

    private String productSpecIds;

    private String productSpecNum;

    private Integer productNum;

    private Integer type;

    private Integer userId;

}