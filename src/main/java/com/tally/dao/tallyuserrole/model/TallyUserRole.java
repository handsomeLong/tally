package com.tally.dao.tallyuserrole.model;

import lombok.Data;

/**
 * 用户角色关系表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyUserRole {

    private Integer id;

    private Integer userId;

    private Integer roleId;

}