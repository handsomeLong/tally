package com.tally.api.outputDto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 产品表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class ProductOutputDto {

    private  Integer id;

    private String name;

    private Integer userId;

    private String productNo;

    private String productImages;

    private String productDescription;

    private List<ProductSpecOutputDto> specList;

}

