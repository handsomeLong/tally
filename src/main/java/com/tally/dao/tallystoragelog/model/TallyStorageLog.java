package com.tally.dao.tallystoragelog.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 库存变动日志
 * @author 131****2893
 * @date 2021/01/19 14:24
 */
@Data
public class TallyStorageLog {

    private Integer id;

    private Integer userId;

    private Integer relateId;

    private Integer operateType;

    private String operateTypeName;

    private String productName;

    private String productNo;

    private Integer productId;

    private Integer specId;

    private Integer storage;

    private Integer beforeStorage;

    private Integer afterStorage;

    private Integer operateUserId;

    private String remark;

    private Date createTime;

}