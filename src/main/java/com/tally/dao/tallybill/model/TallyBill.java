package com.tally.dao.tallybill.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;

/**
 * 账单表
 * @author 131****2893
 * @date 2021/04/12 13:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TallyBill implements Comparator {

    private Integer id;

    private Integer btypeUserId;

    private String btypeUserName;

    private String btypeMobile;

    private Integer totalNumber;

    private Integer settleNumber;

    private BigDecimal totalPrice;

    private BigDecimal settleAmount;


    private Integer version;

    private Integer userId;

    private String userMobile;

    private String userName;

    private Integer type;

    private Integer booksId;

    private Integer projectId;

    private Integer operator;

    private Integer auitStatus;

    private Integer status;

    private String remark;

    private String attach;


    private String  createTime;

    private String dealTime;

    private Integer isMaterial;

    @Override
    public int compare(Object o, Object t1) {
        return 0;
    }
}