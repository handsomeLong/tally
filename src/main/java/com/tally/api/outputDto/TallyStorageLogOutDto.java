package com.tally.api.outputDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tally.dao.tallystoragelog.model.TallyStorageLog;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 库存变动日志
 * @author 131****2893
 * @date 2021/01/19 14:24
 */
@Data
public class TallyStorageLogOutDto extends TallyStorageLog {

    private String specName;

    private String specImages;

    private String specSerial;

    private  String  specUnit;

    private Integer specStorage;

    private Integer specStorageFreeze;

    private BigDecimal specPrice;

    private BigDecimal specStockPrice;

    private BigDecimal specCostPrice;

}