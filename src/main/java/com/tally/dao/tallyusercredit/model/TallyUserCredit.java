package com.tally.dao.tallyusercredit.model;

import lombok.Data;

/**
 * 用户信誉表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyUserCredit {

    private Integer id;

    private Integer userId;

    private Integer creditNum;

    private Integer version;

}