package com.tally.dao.tallyworkorder.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 生产单
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyWorkOrder {

    private Integer id;

    private Integer orderId;

    private String orderNo;

    private String name;

    private String principal;

    private String initiator;

    private Integer workDay;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date beginTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    private Integer status;

    private Integer auitStatus;

    private Integer currentAuitId;

    private String createTime;

    private String remark;

     private String  updateTime;

    private Integer version;

}