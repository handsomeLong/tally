package com.tally.dao.tallyaccount.model;

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
public class TallyAccount {

    private Integer id;

    private Integer typeId;

    private BigDecimal amout;

    private Integer userId;

    private Integer booksId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private String typeName;

    private String  typeCode;

    private String  assetClass;

}