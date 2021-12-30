package com.tally.dao.tallyuser.model;

import lombok.Data;

/**
 * 用户表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyUser {

    private Integer id;

    private String name;

    private  String email;

    private String nickName;

    private String companyName;

    private  String address;

    private String  contact;

    private String createTime;

    private String loginTime;

    private String headImage;

    private String mobile;

    private Integer userType;

    private Integer userStatus;

    private String deviceToken;

    private Integer gradeId;

}