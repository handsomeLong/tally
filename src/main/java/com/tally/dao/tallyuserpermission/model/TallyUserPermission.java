package com.tally.dao.tallyuserpermission.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 用户权限表
 * @author 我是传奇
 * @date 2021/07/21 10:16
 */
@Data
public class TallyUserPermission {

    private Long id;

    private String name;

    private String alias;

    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

}
