package com.tally.dao.tallyaccountwater.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 账户流水
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@Data
public class TallyAccountWater {

    private Integer id;

    private Integer btypeUserId;

    private String btypeUserName;

    private Integer accountId;

    private BigDecimal amount;

    private Integer typeId;

    private Integer type;

    private String typeName;

    private Integer userId;

    private Integer booksId;

    private Integer projectId;

    private Integer billId;

    private Integer operator;

    private Integer auitStatus;

    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;


    private String dealTime;

}