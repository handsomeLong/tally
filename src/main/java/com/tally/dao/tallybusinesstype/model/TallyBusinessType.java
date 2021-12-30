package com.tally.dao.tallybusinesstype.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 业务类型表
 * @author 131****2893
 * @date 2021/03/27 19:02
 */
@Data
public class TallyBusinessType {

    private Integer id;

    private Integer type;

    private Integer subClassType;

    private String typeName;

    private String typeCode;

    private Integer userId;

    private Integer booksId;

    private Integer isEnable;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

}