package com.tally.core.utils;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * 字符串工具类
 * 
 */
public class TallyStringUtil {

	public static final String CHARSET_NAME = "UTF-8";

	/**
	 * 根据传入的字符串生成字符串集合
	 * 
	 * @param val
	 * @return List<String>
	 */
	@SuppressWarnings("unchecked")
	public static List<String> stringToList(String val) {
		if (val != null) {
			String[] list = val.split("[ ]*,[ ]*");
			return Arrays.asList(list);
		} else {
			return Collections.EMPTY_LIST;
		}
	}
	public static String getContentByFile(File file){
		StringBuffer sb=new StringBuffer();
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			String read=null;
			while((read=br.readLine())!=null){
				sb.append(read);
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sb.toString();
	}
	public static void saveContentToFile(String content,File file){
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriterWithEncoding(file,"UTF-8",false));
			bw.write(content);
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static final String getPrice(Object price){
		if(isBlank(price)){
			return "0.00";
		}
		double real_price=Double.valueOf(price.toString());
		real_price=1.05d*real_price;
		//real_price=real_price*1.02d;
		//return String.valueOf((int)Math.ceil(real_price));
		return String.format("%.2f", real_price);
	}
	public static final String getLingDanPrice(Object price){
		if(isBlank(price)){
			return "0.00";
		}
		double real_price=Double.valueOf(price.toString());
		real_price=1.05d*real_price;
		//real_price=real_price*1.02d;
		//return String.valueOf((int)Math.ceil(real_price));
		return String.format("%.2f", real_price);
	}
	public static final String getLingDanPrice2(Object price){
		if(isBlank(price)){
			return "0.00";
		}
		double real_price=Double.valueOf(price.toString());
		real_price=1.1d*real_price+150;
		//real_price=real_price*1.02d;
		//return String.valueOf((int)Math.ceil(real_price));
		return String.format("%.2f", real_price);
	}
	public static final String getStationPrice(Object price){
		if(isBlank(price)){
			return "0.00";
		}
		double real_price=Double.valueOf(price.toString());
		real_price=1.05d*real_price;
		return String.format("%.2f", real_price);
	}
	public static final String getSharedPrice(Object price){
//		if(isBlank(price)){
//			return "0.00";
//		}
//		double real_price=Double.valueOf(price.toString());
//		real_price=0.95d*real_price;
//		return String.format("%.2f", real_price);
		if(isBlank(price)){
			return "0.00";
		}
		double real_price=Double.valueOf(price.toString());
		if(real_price<100){
			real_price=real_price-2;
		}else if(real_price>=100&&real_price<200){
			real_price=real_price-4;
		}else if(real_price>=200&&real_price<300){
			real_price=real_price-6;
		}else if(real_price>=300&&real_price<400){
			real_price=real_price-8;
		}else{
			real_price=real_price-10;
		}
		return String.format("%.2f", real_price);
	}
	public static final String getTzSharedPrice(Object price){
		if(isBlank(price)){
			return "0.00";
		}
		double real_price=Double.valueOf(price.toString());
		if(real_price<100){
			real_price=real_price-2;
		}else if(real_price>=100&&real_price<200){
			real_price=real_price-4;
		}else if(real_price>=200&&real_price<300){
			real_price=real_price-6;
		}else if(real_price>=300&&real_price<400){
			real_price=real_price-8;
		}else{
			real_price=real_price-10;
		}
		return String.format("%.2f", real_price);
	}
	public static final String getDriverPrice(Object price){
		if(isBlank(price)){
			return "0.00";
		}
		double real_price=Double.valueOf(price.toString());
		real_price=0.98d*real_price;
		return String.format("%.2f", real_price);
	}
	public static final String getLingDanDriverPrice(Object price){
		if(isBlank(price)){
			return "0.00";
		}
		double real_price=Double.valueOf(price.toString());
		real_price=0.98d*real_price;
		return String.format("%.2f", real_price);
	}
	public static final String getLingDanDriverPrice2(Object price){
		if(isBlank(price)){
			return "0.00";
		}
		double real_price=Double.valueOf(price.toString());
		real_price=0.93d*0.95d*real_price;
		return String.format("%.2f", real_price);
	}
	public static final String getStationDriverPrice(Object price){
		if(isBlank(price)){
			return "0.00";
		}
		double real_price=Double.valueOf(price.toString());
		real_price=0.98d*real_price;
		return String.format("%.2f", real_price);
	}
	public static final String getSharedDriverPrice(Object price){
		if(isBlank(price)){
			return "0.00";
		}
		double real_price=Double.valueOf(price.toString());
		real_price=1.02d*real_price;
		return String.format("%.2f", real_price);
	}
	/**
	 * 转换对象为字符串,如果对象为空，返回为""
	 * 
	 * @param obj
	 *            Object
	 * @return String
	 */
	public static String nvl(Object obj) {
		if (obj == null) {
			return "";
		}
		if (obj instanceof String) {
			return (String) obj;
		}
		return obj.toString();
	}
	public static String getIpAddr(HttpServletRequest request){
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
		return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
		// 多次反向代理后会有多个IP值，第一个为真实IP。
		int index = ip.indexOf(',');
		if (index != -1) {
		return ip.substring(0, index);
		} else {
		return ip;
		}
		} else {
		return request.getRemoteAddr();
		}
		}
	/**
	 * 检查字符串是否不为空
	 * 
	 * @param obj
	 *            a string to check
	 * @return true if the string is not empty
	 */
	public static boolean isNotBlank(Object obj) {
		if (!nvl(obj).trim().equals("")) {
			return true;
		}
		return false;
	}
	public static  String genNonceStr() {
		Random random = new Random();
		return MD5.getMessageDigest(String.valueOf(random.nextInt(10000)));
	}
	/**
	 * 检查字符串是否为空
	 * 
	 * @param obj
	 *            a string to check
	 * @return true if the string is empty
	 */
	public static boolean isBlank(Object obj) {
		return !isNotBlank(obj);
	}

	/**
	 * 计算中文字的个数
	 * 
	 * @author tyun
	 * @since 2012/12/20
	 */
	public static int chineseCount(String word) {
		int v = 0;
		char c;
		for (int cc = 0; cc < word.length(); cc++) {
			c = word.charAt(cc);
			if (!(c >= 32 && c <= 126))
				v++;
		}
		return v;
	}

	/**
	 * 首字符前面补空格
	 * 
	 * @param val
	 *            值
	 * @param length
	 *            补足长度
	 * @return String
	 */
	public static String padLeftSpace(String val, int length) {

		return padSpace(val, length, CHARSET_NAME, true);
	}

	/**
	 * 尾数后补空格
	 * 
	 * @param val
	 *            值
	 * @param length
	 *            补足长度
	 * @return String
	 */
	public static String padRightSpace(String val, int length) {

		return padSpace(val, length, CHARSET_NAME, false);
	}

	/**
	 * 字符串添加空格
	 * 
	 * @param val
	 *            值
	 * @param length
	 *            变换int用文字数生成
	 * @param charsetName
	 *            编码格式
	 * @param isLeft
	 *            true：左边补空格（首字符前），false：右边补空格（尾数后）
	 * @return String
	 */
	public static String padSpace(String val, int length, String charsetName,
			boolean isLeft) {

		if (val == null) {
			return "";
		}

		int num = 0;
		String sRet = "";
		try {
			num = length - val.getBytes(charsetName).length;
			if (num <= 0) {
				return val;
			}

			StringBuffer result = new StringBuffer();
			for (int i = 0; i < num; i++) {
				result.append((char) 32);
			}

			if (isLeft == true) {
				sRet = result.toString() + val;
			} else {
				sRet = val + result.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sRet;
	}

	/**
	 * 首字符前面补0
	 * 
	 * @param val
	 *            值
	 * @param length
	 *            补足长度
	 * @return String
	 */
	public static String padLeftZero(String val, int length) {

		return padZero(val, length, CHARSET_NAME, true);
	}

	/**
	 * 字符串添加0
	 * 
	 * @param val
	 *            值
	 * @param length
	 *            变换int用文字数生成
	 * @param charsetName
	 *            编码格式
	 * @param isLeft
	 *            true：左边补0（首字符前），false：右边补0（尾数后）
	 * @return String
	 */
	public static String padZero(String val, int length, String charsetName,
			boolean isLeft) {

		if (val == null) {
			return "";
		}

		int num = 0;
		String sRet = "";
		try {
			num = length - val.getBytes(charsetName).length;
			if (num <= 0) {
				return val;
			}

			StringBuffer result = new StringBuffer();
			for (int i = 0; i < num; i++) {
				result.append((char) 48);
			}

			if (isLeft == true) {
				sRet = result.toString() + val;
			} else {
				sRet = val + result.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sRet;
	}

	/**
	 * 计算字符串的长度. 一个字符长度为1，一个汉字的长度为2.
	 * 
	 * @param
	 * @return int
	 */
	public static int lengthOfString(String value) {
		if (value == null)
			return 0;
		StringBuffer buff = new StringBuffer(value);
		int length = 0;
		String stmp;
		for (int i = 0; i < buff.length(); i++) {
			stmp = buff.substring(i, i + 1);
			try {
				stmp = new String(stmp.getBytes(CHARSET_NAME));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (stmp.getBytes().length > 1) {
				length += 2;
			} else {
				length += 1;
			}
		}
		return length;
	}

	/**
	 * 将字符串转为整型字符串
	 * 
	 * @param value
	 * @return
	 */
	public static String str2IntStr(String value) {

		int iRet = 0;
		try {
			value = isBlank(value) ? "0" : value;
			iRet = Integer.parseInt(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "" + iRet;
	}

	/**
	 * 判断字符串是否仅含英文或数字，不含中文
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isEnglish(String val) {
		
		if (isBlank(val)) {
			return false;
		}
		return val.getBytes().length == val.length();
	}
	
	

}
