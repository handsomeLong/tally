package com.tally.dao.tallybilldetail.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 账单明细
 * @author 131****2893
 * @date 2021/04/13 19:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TallyBillDetail {

    private Integer id;

    private Integer billId;

    private Integer inOutTypeId;

    private Integer inOutType;

    private String inOutTypeName;

    private BigDecimal perPrice;

    private Integer number;

    private BigDecimal amount;

    private BigDecimal settleAmount;

    private Integer settleNumber;

    private Integer productId;

    private Integer productSpecId;

    private String productSpecName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

}