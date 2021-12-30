package com.tally.api.outputDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 账户流水明细
 * @author 131****2893
 * @date 2021/01/08 14:39
 */
@Data
public class WaterDetailOutputDto {

    private Integer id;

    private Integer waterId;

    private Integer inOutTypeId;

    private Integer inOutType;

    private String inOutTypeName;

    private BigDecimal perPrice;

    private Integer number;

    private BigDecimal amount;

    private Integer productId;

    private Integer productSpecId;

    private String productSpecName;

    private String remark;

    private String remarks;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;


    private Integer btypeUserId;

    private String btypeUserName;

    private Integer accountId;

    private BigDecimal amout;

    private Integer typeId;

    private Integer type;

    private String typeName;

    private Integer userId;

    private Integer booksId;

    private Integer projectId;

    private Integer operator;

    private Integer auitStatus;

    private String dealTime;
}