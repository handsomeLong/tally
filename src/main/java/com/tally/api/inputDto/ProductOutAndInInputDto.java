package com.tally.api.inputDto;

import lombok.Data;

import java.util.List;

/**
 * 出入库
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class ProductOutAndInInputDto {

    private Integer orderId;

    private String orderNo;

    private Integer productId;

    private String productName;

    private String productNo;

    private Integer productNum;

    private Integer type;

    private List<ProductOutAndInDetailDto>  list;

}