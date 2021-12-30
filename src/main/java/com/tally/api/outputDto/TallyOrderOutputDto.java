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
public class TallyOrderOutputDto {

    private Integer id;

    private String orderNo;

    private BigDecimal totalPrice;

    private BigDecimal amount;

    private BigDecimal discout;

    private BigDecimal successAmount;

    private Integer payWay;

    private Integer userId;

    private Integer buyerId;

    private  String buyerName;

    private String remark;

    private Integer status;

    private String createTime;

    private List<TallyOrderProductOutputDto>  orderProductList;

}