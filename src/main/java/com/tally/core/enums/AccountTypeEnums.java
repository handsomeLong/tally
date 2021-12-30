package com.tally.core.enums;

/**
 * 账户类型
 * 现金	XJ
 * 银行(对公)	YH
 * 支付宝	ZFB
 * 微信	WX
 * 应收款	YS
 * 应付款	YF
 * 预付款	YFK
 * 预收款	YSK
 */
public enum AccountTypeEnums {

    XJ("XJ", "现金"),
    YH("YH", "银行(对公)"),
    ZFB("ZFB", "支付宝"),
    WX("WX", "微信"),
    YS("YS", "应收款"),
    YF("YF", "应付款"),
    YFK("YFK", "预付款"),
    YSK("YSK", "预收款");

    private String retCode;
    private String retMsg;

    AccountTypeEnums(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }
    public static AccountTypeEnums getEnum(String value){
        AccountTypeEnums resultEnum = null;
        AccountTypeEnums[] enumAry = AccountTypeEnums.values();
        for(int i = 0; i<enumAry.length; i++){
            if(value.equals(enumAry[i].getRetCode())){
                resultEnum = enumAry[i];
                break;
            }
        }
        return resultEnum;
    }
    public String getRetCode() {
        return retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }
    
}
