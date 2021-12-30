package com.tally.dao.tallyworkorderproduct.model;

import lombok.Data;

/**
 * 任务单
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyWorkOrderProduct {

    private Integer id;

    private Integer workOrderId;

    private Integer productId;

    private String  productName;

    private Integer productSpecId;

    private String  productSpecName;

    private Integer productSpecNum;

}