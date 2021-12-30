package com.tally.core.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.File;

public class AccessToken {

	public static String getTicket(File file) throws Exception {
		if(System.currentTimeMillis()-file.lastModified()>7200000){
			TallyStringUtil.saveContentToFile("", file);
		}
		String ticket=TallyStringUtil.getContentByFile(file);
		if(TallyStringUtil.isNotBlank(ticket)){
			return ticket;
		}
		String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx685641a1b6ba3120&secret=38fbfd8bfbde2f83a6704cb9eda8c370";
//		String response=HttpConnectionUtil.getHttp(url);
		String response=HttpUtils.httpGet(url);
		JSONObject access_token_json=JSONObject.parseObject(response);
		String access_token=access_token_json.getString("access_token");
		url="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+access_token+"&type=jsapi";
		response=HttpUtils.httpGet(url);
		access_token_json=JSONObject.parseObject(response);
		int errcode=access_token_json.getIntValue("errcode");
		if(errcode==0){
			String ticket_str=access_token_json.getString("ticket");
			TallyStringUtil.saveContentToFile(ticket_str, file);
			return ticket_str;
		}
		return null;
	}

	/**
	 * 获取微信小程序token
	 * @param file
	 * @return
	 */
	public static String getWxmini(File file){
		try {
			if(System.currentTimeMillis()-file.lastModified()>7200000){
				TallyStringUtil.saveContentToFile("", file);
			}
			String ticket=TallyStringUtil.getContentByFile(file);
			if(TallyStringUtil.isNotBlank(ticket)){
				return ticket;
			}
			String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx0f28cfa055324bb8&secret=46ab57215f8e455c24a7f00894afda96";
			String response=HttpUtils.httpsGet(url);
			JSONObject access_token_json = JSONObject.parseObject(response);
			String access_token=access_token_json.getString("access_token");
			if(TallyStringUtil.isNotBlank(access_token)){
				TallyStringUtil.saveContentToFile(access_token, file);
				return access_token;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
