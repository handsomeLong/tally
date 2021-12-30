package com.tally.api.inputDto;

import lombok.Data;

/**
 * 账户流水报表
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@Data
public class BillReportInputDto {

  private   Integer  interval;

  private   String accountTypeCode;

  private   Integer userId;

  private   int page;

  private   int capacity;

  private Integer accountId;

  private  String startDate;

  private String  endDate;

  public int getCapacity () {
        return capacity <= 0 ? 10 : capacity;
    }

    public int getPage () {
        return page <= 0 ? 1 : page;
    }
}