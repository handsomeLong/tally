package com.tally.dao.tallyuserfriends.model;

import lombok.Data;

/**
 * 用户好友关系表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyUserFriends {

    private Integer id;

    private Integer userId;

    private Integer type;

    private Integer friendsId;

    private String friendsUserName;

    private String createTime;

    private Integer settleWay;
}