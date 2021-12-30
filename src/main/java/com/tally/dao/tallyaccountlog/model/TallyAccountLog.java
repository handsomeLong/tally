package com.tally.dao.tallyaccountlog.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 账户变动日志
 * @author 131****2893
 * @date 2021/01/18 20:49
 */
@Data
public class TallyAccountLog {

    private Integer id;

    private Integer accountId;

    private Integer type;

    private String typeName;

    private Integer waterId;

    private BigDecimal amount;

    private Integer userId;

    private Integer booksId;

    private BigDecimal beforeAmount;

    private BigDecimal afterAmount;

    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

}