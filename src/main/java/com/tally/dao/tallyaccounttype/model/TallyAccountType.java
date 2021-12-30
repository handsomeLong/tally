package com.tally.dao.tallyaccounttype.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 账户类型表
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@Data
public class TallyAccountType {

    private Integer id;

    private String typeName;

    private String typeCode;

    private Integer userId;

    private Integer booksId;

    private String assetClass;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

}