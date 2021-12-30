package com.tally.api.outputDto;

import lombok.Data;

/**
 * 用户好友关系表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyUserFriendsOutDto {

    private Integer id;

    private Integer userId;

    private Integer type;

    private Integer friendsId;

    private String mobile;

    private String nickName;

    private String headImage;

    private String createTime;

    private String name;

    private String companyName;

    private String contact;

    private String address;

    private Integer settleWay;

}