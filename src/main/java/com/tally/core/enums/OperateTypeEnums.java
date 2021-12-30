package com.tally.core.enums;

/**
 * 订单类型
 * 100 库存初始化
 * 101 销售出货
 * 102 销售退货
 * 103 采购进货
 * 104 采购退货
 * 105 调拨
 * 106 盘点
 */
public enum OperateTypeEnums {
    INIT(100 , "库存初始化"),
    SALES(101 , "销售出货"),
    SALES_RETURN(102 , "销售退货"),
    PURCHASE(103 , "采购进货"),
    PURCHASE_RETURN(104 , "采购退货"),
    ALLOT(105, "调拨"),
    CHECK(106, "盘点"),
    MANUAL_IN(107, "手动入库"),
    MATERIAL_OUT(109, "物料借出出库"),
    MATERIAL_IN(110, "物料借入入库"),
    MANUAL_OUT(108, "手动出库");
    private Integer retCode;
    private String retMsg;

    OperateTypeEnums(Integer retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }
    public static OperateTypeEnums getEnum(Integer value){
        OperateTypeEnums resultEnum = null;
        OperateTypeEnums[] enumAry = OperateTypeEnums.values();
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
