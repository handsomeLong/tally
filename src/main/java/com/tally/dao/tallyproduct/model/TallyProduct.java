package com.tally.dao.tallyproduct.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 产品表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TallyProduct {

    private Integer id;

    private String name;

    private String productNo;

    private String productImages;

    private String productDescription;

    private String remark;

    private Integer isDel;

    private String createTime;

    private Integer userId;

}