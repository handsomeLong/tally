package com.tally.dao.tallyuserinvite.model;

import lombok.Data;

/**
 * 用户邀请好友表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyUserInvite {

    private Integer id;

    private Integer userId;

    private String mobile;

    private String headerImage;

    private Integer inviteId;

    private Integer teamId;

    private Integer departId;

    private Integer isTop;

    private Integer isPartner;

    private String createTime;

}