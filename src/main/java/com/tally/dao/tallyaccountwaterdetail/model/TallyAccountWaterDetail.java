package com.tally.dao.tallyaccountwaterdetail.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 账户流水明细
 * @author 131****2893
 * @date 2021/01/08 14:39
 */
@Data
public class TallyAccountWaterDetail {

    private Integer id;

    private Integer waterId;

    private Integer billDetailId;

    private Integer inOutTypeId;

    private Integer inOutType;

    private String inOutTypeName;

    private String  dealTime;

    private BigDecimal perPrice;

    private Integer number;

    private BigDecimal amount;

    private Integer productId;

    private Integer productSpecId;

    private String productSpecName;

    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;


    private Integer userId;

    private Integer type;

    private Integer accountId;
}