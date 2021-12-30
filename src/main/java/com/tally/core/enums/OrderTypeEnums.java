package com.tally.core.enums;

/**
 * 订单类型
 * n100-销售出货 \r\n101-销售退货\r\n102-采购进货 \r\n103-采购退货
 */
public enum OrderTypeEnums {

    SALES(100, "销售出货"),
    SALES_RETURN(101, "销售退货"),
    PURCHASE(102, "采购进货"),
    PURCHASE_RETURN(103, "采购退货");

    private Integer retCode;
    private String retMsg;

    OrderTypeEnums(Integer retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }
    public static OrderTypeEnums getEnum(Integer value){
        OrderTypeEnums resultEnum = null;
        OrderTypeEnums[] enumAry = OrderTypeEnums.values();
        for(int i = 0; i<enumAry.length; i++){
            if(value==enumAry[i].getRetCode()){
                resultEnum = enumAry[i];
                break;
            }
        }
        return resultEnum;
    }
    public Integer getRetCode() {
        return retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }
    
}
