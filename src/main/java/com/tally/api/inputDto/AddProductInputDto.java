package com.tally.api.inputDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * 产品表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddProductInputDto {

    private Integer productId;

    private String name;

    private String productNo;

    private String productImages;

    private String productDescription;

    private  String remark;

    private List<ProductSpecInputDto> specList;

}
