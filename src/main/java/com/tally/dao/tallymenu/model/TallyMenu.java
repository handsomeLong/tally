package com.tally.dao.tallymenu.model;

import lombok.Data;

/**
 * 用户菜单
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyMenu {

    private Integer id;

    private String name;

    private String url;

    private Integer parentId;

    private Integer sort;

    private Integer level;

    private String path;

    private String description;

    private String permission;

    private Integer isshow;

}