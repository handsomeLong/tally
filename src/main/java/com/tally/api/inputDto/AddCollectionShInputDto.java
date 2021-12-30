package com.tally.api.inputDto;

import io.swagger.models.auth.In;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 收付款
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class AddCollectionShInputDto {

    private BigDecimal amount;

    private Integer number;

    private  String  dealTime;

    private  Integer  type;

    private  String remark;

    private Integer userId;

    private Integer btypeUserId;

    private String  btypeUserName;

    private Integer isMaterial;

    private Integer productId;

    private Integer productSpecId;

    private String productSpecName;

}
