package com.tally.dao.tallyproductcomponent.model;

import lombok.Data;

/**
 * 产品组成表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyProductComponent {

    private Integer id;

    private Integer productId;

    private Integer componentProductId;

    private Integer userId;

    private String createTime;

}