package com.tally.api.inputDto;

import lombok.Data;

@Data
public class WxAuthLoginInputDto {

    private  String session_key;

    private  String openid;

    private  String encryptedData;

    private  String iv;

    private String inviteUserId;
}
