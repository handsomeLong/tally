package com.tally.dao.tallyuserpergrant.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 用户权限授权表
 * @author 我是传奇
 * @date 2021/07/21 10:16
 */
@Data
public class TallyUserPerGrant {

    private Integer id;

    private Integer useId;

    private Integer grantUserId;

    private String grantUserMobile;

    private Integer permissonId;

    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

}
