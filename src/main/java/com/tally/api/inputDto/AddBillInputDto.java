package com.tally.api.inputDto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 新增账单
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class AddBillInputDto {

    private  Integer  btypeUserId;

    private  String btypeUserName;

    private  String btypeMobile;

    private Integer userId;

    private BigDecimal totalPrice;

    private Integer totalNumber;

    private BigDecimal totalSettleAmount;//结算金额

    private  String  dealTime;

    private  Integer  type;

    private  String remark;

    private  Integer isMaterial;

    private List<BillDetailInputDto> productSpecList;

}
