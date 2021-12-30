package com.tally.dao.tallymsg.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 消息
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Data
public class TallyMsg {

    private Integer id;

    private String title;

    private String content;

    private Integer userId;

    private Integer isNew;

    private String createTime;

    private String updateTime;

    private Integer msgType;

    private String link;

    private String imageUrl;

}