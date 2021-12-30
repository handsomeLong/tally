package com.tally.api.outputDto;

import com.tally.dao.tallybilldetail.model.TallyBillDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 账单表 outputdto
 * @author 131****2893
 * @date 2021/04/12 13:43
 */
@Data
public class TallyBillOutputDto {

    private Integer id;

    private Integer btypeUserId;

    private String btypeUserName;

    private BigDecimal totalPrice;

    private BigDecimal settleAmount;

    private Integer userId;

    private String userMobile;

    private String userName;

    private Integer type;

    private Integer auitStatus;

    private Integer status;

    private String remark;

    private String dealTime;

    private Integer isMaterial;

    private  String operator;

    private Integer totalNumber;

    private Integer settleNumber;

    private  String createTime;

    private List<TallyBillDetail> detailList;

}