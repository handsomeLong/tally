package com.tally.dao.tallyrolemenu.model;

import lombok.Data;

/**
 * 角色菜单关系表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyRoleMenu {

    private Integer id;

    private Integer roleId;

    private Integer menuId;

}