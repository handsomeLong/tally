package com.tally.dao.tallywxalipayaccount.model;

import lombok.Data;

/**
 * 微信支付宝账号表
 * @author 131****2893
 * @date 2020/10/28 15:18
 */
@Data
public class TallyWxAlipayAccount {

    private Integer id;

    private String accountNo;

    private String accType;

    private Integer userId;

}