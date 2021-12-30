package com.tally.dao.tallyinouttype.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 收支类型
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@Data
public class TallyInOutType {

    private Integer id;

    private Integer type;

    private String typeName;

    private Integer userId;

    private Integer booksId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

}