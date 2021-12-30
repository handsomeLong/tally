package com.tally.dao.tallystoragecheck.model;

import lombok.Data;

/**
 * 库存盘点
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyStorageCheck {

    private Integer id;

    private Long createTime;

    private Integer userId;

    private String checkResults;

}