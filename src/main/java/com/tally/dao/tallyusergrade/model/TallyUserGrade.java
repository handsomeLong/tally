package com.tally.dao.tallyusergrade.model;

import lombok.Data;

/**
 * 用户等级
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyUserGrade {

    private Integer id;

    private String name;

    private String gradeImg;

    private String deadline;

    private Integer isDefault;

}