package com.tally.dao.tallymemberfeesorder.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员缴费订单
 * @author 131****2893
 * @date 2020/10/31 21:47
 */
@Data
public class TallyMemberfeesOrder {

    private Integer id;

    private String orderNo;

    private Integer userId;

    private Integer comboId;

    private BigDecimal amount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    private Integer period;

    private String remark;

    private Integer status;

    private String outTradeNo;

    private Integer payWay;

    private Long createTime;

}