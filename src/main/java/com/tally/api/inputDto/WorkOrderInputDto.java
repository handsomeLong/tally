package com.tally.api.inputDto;

import lombok.Data;

import java.util.List;

/**
 * 生产单
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class WorkOrderInputDto {

    private Integer orderId;

    private String orderNo;

    private String name;

    private String principal;

    private String  remark;

    private String  beginTime;

    private  String endTime;

    private List<WorkOrderProductInputDto> list;

}
