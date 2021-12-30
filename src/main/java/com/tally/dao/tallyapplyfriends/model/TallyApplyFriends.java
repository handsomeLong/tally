package com.tally.dao.tallyapplyfriends.model;

import lombok.Data;

/**
 * 请求添加好友
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyApplyFriends {

    private Integer id;

    private Integer userId;

    private Integer applyUserId;

    private Integer applyType;

    private String remark;

    private Integer status;

    private String createTime;

}