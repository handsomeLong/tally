package com.tally.api.inputDto;

import lombok.Data;

/**
 * 销售和采购 报表
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@Data
public class SalesAndPurchaseReportInputDto {

  private   Integer  interval;

  private   Integer type;

  private   Integer userId;

  private   int page;

  private   int capacity;

  public int getCapacity () {
    return capacity <= 0 ? 10 : capacity;
  }

  public int getPage () {
    return page <= 0 ? 1 : page;
  }

}