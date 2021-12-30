package com.tally.api.inputDto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 流水表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class AddWaterInputDto {

    private  Integer  btypeUserId;

    private  String btypeUserName;

    private  Integer accountId;

    private Integer userId;

    private BigDecimal amout;

    private  String  dealTime;

    private  Integer  type;

    private  Integer  subClassType;

    private  String remark;

    private List<WaterDetailInputDto> waterDetailList;

    private Integer inOutTypeId;

    private Integer inOutType;

    private String inOutTypeName;

}
