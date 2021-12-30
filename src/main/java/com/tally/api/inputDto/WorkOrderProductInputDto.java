package com.tally.api.inputDto;

import lombok.Data;

@Data
 public  class WorkOrderProductInputDto {

    private Integer productId;

    private  String productName;

    private Integer productSpecId;

    private String  productSpecName;

    private Integer productSpecNum;

}
