package com.tally.api.outputDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 生产单
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyWorkOrderOutputDto {

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

     private String  updateTime;

     private String remark;

    private Integer version;

    private List<TallyWorkOrderProductOutDto> list;

}