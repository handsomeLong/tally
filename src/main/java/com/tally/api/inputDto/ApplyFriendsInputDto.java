package com.tally.api.inputDto;

import lombok.Data;

/**
 * 请求添加好友
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class ApplyFriendsInputDto {

    private Integer applyUserId;

    private String friendsUserName;

    private Integer userId;

    private Integer applyType;

    private String remark;

}