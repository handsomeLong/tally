package com.tally.dao.tallyrole.model;

import lombok.Data;

/**
 * 角色表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyRole {

    private Integer id;

    private String name;

    private String alias;

    private String description;

    private String createTime;

}