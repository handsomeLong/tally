package com.tally.api.outputDto;

import com.tally.dao.tallyproductspec.model.TallyProductSpec;
import lombok.Data;

import java.util.List;

/**
 * 出入库审核表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyStorageAuitOutputDto {

    private Integer id;

    private Integer orderId;

    private Integer applyUserId;

    private Integer auitUserId;

    private String orderNo;

    private Integer productId;

    private String productName;

    private String productNo;

    private String productSpecIds;

    private String productSpecNum;

    private Integer productNum;

    private Integer type;

    private Integer status;

    private String createTime;

    private String updateTime;

    private List<TallyProductSpec> list;

}