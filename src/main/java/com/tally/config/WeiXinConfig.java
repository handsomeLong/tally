package com.tally.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "/config/weixin.properties")
//@ConfigurationProperties(prefix = "weixin")
public class WeiXinConfig {

	@Value("${weixin.app_id}")
	private   String app_id;

	@Value("${weixin.mini_app_id}")
	private   String mini_app_id;

	@Value("${weixin.mch_id}")
	public    String mch_id;

	@Value("${weixin.pay_secret}")
	public    String pay_secret;

	@Value("${weixin.mini_secret}")
	public    String mini_secret;

	@Value("${weixin.pay_url}")
	public    String pay_url;

	@Value("${weixin.get_openid_url}")
	public    String get_openid_url;

	@Value("${weixin.wxacodeunlimit_url}")
	public    String wxacodeunlimit_url;

	@Value("${weixin.refund_url}")
	public    String refund_url;

	@Value("${weixin.notify_url}")
	public    String notify_url;

	@Value("${weixin.certpath}")
	public    String certpath;

	public String getWxacodeunlimit_url() {
		return wxacodeunlimit_url;
	}

	public void setWxacodeunlimit_url(String wxacodeunlimit_url) {
		this.wxacodeunlimit_url = wxacodeunlimit_url;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getPay_secret() {
		return pay_secret;
	}

	public void setPay_secret(String pay_secret) {
		this.pay_secret = pay_secret;
	}

	public String getPay_url() {
		return pay_url;
	}

	public void setPay_url(String pay_url) {
		this.pay_url = pay_url;
	}

	public String getRefund_url() {
		return refund_url;
	}

	public void setRefund_url(String refund_url) {
		this.refund_url = refund_url;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getCertpath() {
		return certpath;
	}

	public void setCertpath(String certpath) {
		this.certpath = certpath;
	}

	public String getMini_app_id() {
		return mini_app_id;
	}

	public void setMini_app_id(String mini_app_id) {
		this.mini_app_id = mini_app_id;
	}

	public String getGet_openid_url() {
		return get_openid_url;
	}

	public void setGet_openid_url(String get_openid_url) {
		this.get_openid_url = get_openid_url;
	}

	public String getMini_secret() {
		return mini_secret;
	}

	public void setMini_secret(String mini_secret) {
		this.mini_secret = mini_secret;
	}
}
