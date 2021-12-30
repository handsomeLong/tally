package com.tally.core.utils;
import com.github.pagehelper.util.StringUtil;
//import libs.httpclient.org.apache.http.HttpEntity;
//import libs.httpclient.org.apache.http.HttpVersion;
//import libs.httpclient.org.apache.http.NameValuePair;
//import libs.httpclient.org.apache.http.client.entity.UrlEncodedFormEntity;
//import libs.httpclient.org.apache.http.client.methods.CloseableHttpResponse;
//import libs.httpclient.org.apache.http.client.methods.HttpGet;
//import libs.httpclient.org.apache.http.client.methods.HttpPost;
//import libs.httpclient.org.apache.http.client.protocol.HttpClientContext;
//import libs.httpclient.org.apache.http.config.Registry;
//import libs.httpclient.org.apache.http.config.RegistryBuilder;
//import libs.httpclient.org.apache.http.conn.socket.ConnectionSocketFactory;
//import libs.httpclient.org.apache.http.conn.socket.LayeredConnectionSocketFactory;
//import libs.httpclient.org.apache.http.conn.socket.PlainConnectionSocketFactory;
//import libs.httpclient.org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import libs.httpclient.org.apache.http.conn.ssl.SSLContexts;
//import libs.httpclient.org.apache.http.entity.StringEntity;
//import libs.httpclient.org.apache.http.impl.client.CloseableHttpClient;
//import libs.httpclient.org.apache.http.impl.client.HttpClients;
//import libs.httpclient.org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import libs.httpclient.org.apache.http.message.BasicNameValuePair;
//import libs.httpclient.org.apache.http.util.EntityUtils;
import org.apache.commons.lang3.StringUtils;
import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpConnectionUtil {
//    private static PoolingHttpClientConnectionManager manager; //连接池管理类
//   static{
//	   LayeredConnectionSocketFactory sslsf = null;
//	   try {
//		   sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
//		   Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
//				   .register("https", sslsf)
//				   .register("http", new PlainConnectionSocketFactory())
//				   .build();
//		   manager =new PoolingHttpClientConnectionManager(socketFactoryRegistry);
//		   manager.setMaxTotal(200);
//		   manager.setDefaultMaxPerRoute(20);
//	} catch (Exception e) {
//		// TODO: handle exception
//	}
//
//   }
//   private static CloseableHttpClient getHttpClient() {
//	   CloseableHttpClient httpClient = HttpClients.custom()
//			   .setConnectionManager(manager)
//			   .build();
//	   return httpClient;
//   }
//
//
//
//
//	public static String getHttp(String url) {
//		CloseableHttpResponse response=null;
//		CloseableHttpClient client=null;
//		HttpGet get=new HttpGet(url);
//		try {
//			get.setProtocolVersion(HttpVersion.HTTP_1_1);
//			client=getHttpClient();
//			response=client.execute(get,HttpClientContext.create());
//			HttpEntity entity=response.getEntity();
//			if(entity!=null){
//				return EntityUtils.toString(entity, "utf-8");
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}finally{
//			try {
//				if(response!=null){
//					EntityUtils.consume(response.getEntity());
//					response.close();
//				}
//				get.releaseConnection();
//			} catch (Exception e2) {
//				// TODO: handle exception
//				e2.printStackTrace();
//			}
//		}
//		return null;
//	}
//
//	public static String post_bank(Map<String, String> parmas){
//		CloseableHttpResponse response=null;
//		try {
//			String host = "https://aliyun-bankcard3-verify.apistore.cn";
//		    String path = "/bank3";
//		    String url=buildUrl(host, path, parmas);
//			HttpGet post=new HttpGet(url);
//			post.setProtocolVersion(HttpVersion.HTTP_1_1);
//			post.addHeader("Authorization", "APPCODE 028313541aa148038ab0bb6931cd8235");
//			post.addHeader("Content-Type", "application/json; charset=UTF-8");
//			response=getHttpClient().execute(post,HttpClientContext.create());
//			HttpEntity entity=response.getEntity();
//			if(entity!=null){
//				return EntityUtils.toString(entity,"utf-8");
//			}
//	            //第五步：从相应对象当中取出数据，放到entity当中
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally{
//			try {
//				if(response!=null){
//					EntityUtils.consume(response.getEntity());
//					response.close();
//				}
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//
//		return null;
//	}
//	public static String buildUrl(String host, String path, Map<String, String> querys) throws UnsupportedEncodingException {
//    	StringBuilder sbUrl = new StringBuilder();
//    	sbUrl.append(host);
//    	if (!StringUtil.isEmpty(path)) {
//    		sbUrl.append(path);
//        }
//    	if (null != querys) {
//    		StringBuilder sbQuery = new StringBuilder();
//        	for (Map.Entry<String, String> query : querys.entrySet()) {
//        		if (0 < sbQuery.length()) {
//        			sbQuery.append("&");
//        		}
//        		if (StringUtil.isEmpty(query.getKey()) && !StringUtil.isEmpty(query.getValue())) {
//        			sbQuery.append(query.getValue());
//                }
//        		if (!StringUtil.isEmpty(query.getKey())) {
//        			sbQuery.append(query.getKey());
//        			if (!StringUtil.isEmpty(query.getValue())) {
//        				sbQuery.append("=");
//        				sbQuery.append(URLEncoder.encode(query.getValue(), "utf-8"));
//        			}
//                }
//        	}
//        	if (0 < sbQuery.length()) {
//        		sbUrl.append("?").append(sbQuery);
//        	}
//        }
//
//    	return sbUrl.toString();
//    }
//	/**
//	 * 发送HttpPost请求
//	 *
//	 * @param strURL
//	 *            服务地址
//	 * @param
//	 *
//	 * @return 成功:返回json字符串<br/>
//	 */
//	public static String post(String strURL, String parmas) throws Exception{
//			CloseableHttpResponse response=null;
//		try {
//			HttpPost post=new HttpPost(strURL);
//			post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.75 Safari/537.36");
//			post.setProtocolVersion(HttpVersion.HTTP_1_1);
//			StringEntity entity=new StringEntity(parmas, "UTF-8");
//			entity.setContentType("application/json");
//			entity.setContentEncoding("UTF-8");
//			post.setEntity(entity);
//			response=getHttpClient().execute(post,HttpClientContext.create());
//			HttpEntity hentity=response.getEntity();
//			if(hentity!=null){
//				return EntityUtils.toString(hentity, "utf-8");
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally{
//			try {
//				if(response!=null){
//					EntityUtils.consume(response.getEntity());
//					response.close();
//				}
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//
//		return null;
//	}
//	/**
//	 * 发送HttpPost请求
//	 *
//	 * @param strURL
//	 *            服务地址
//	 * @param params
//	 *
//	 * @return 成功:返回json字符串<br/>
//	 */
//	public static String postmultipart(String strURL,Map<String,String> params){
//		CloseableHttpResponse response=null;
//		CloseableHttpClient client=null;
//		HttpPost post=new HttpPost(strURL);
//		try {
//			post.setProtocolVersion(HttpVersion.HTTP_1_1);
//			List<NameValuePair> pairs=new ArrayList<NameValuePair>();
//			for(Map.Entry<String,String> param:params.entrySet()){
//				pairs.add(new BasicNameValuePair(param.getKey(), param.getValue()));
//			}
//			StringEntity entity=new UrlEncodedFormEntity(pairs,"utf-8");
//			entity.setContentType("application/x-www-form-urlencoded");
//			post.setEntity(entity);
//			client=getHttpClient();
//			response=client.execute(post,HttpClientContext.create());
//			HttpEntity en=response.getEntity();
//			if(en!=null){
//				return EntityUtils.toString(en,"utf-8");
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}finally{
//			try {
//				if(response!=null){
//					EntityUtils.consume(response.getEntity());
//					response.close();
//				}
//				post.releaseConnection();
//			} catch (Exception e2) {
//				// TODO: handle exception
//				e2.printStackTrace();
//			}
//		}
//		return null;
//	}
//	public static String httpspost(String strURL, String parmas) throws Exception{
//		CloseableHttpResponse response=null;
//		try {
//			HttpPost httpPost = new HttpPost(strURL);
//			httpPost.setEntity(new StringEntity(parmas));
//			httpPost.setHeader("Accept", "application/json");
//			httpPost.setHeader("Content-type", "application/json");
//			response = getHttpClient().execute(httpPost,HttpClientContext.create());
//			HttpEntity entity=response.getEntity();
//			if(entity!=null){
//				return EntityUtils.toString(entity,"utf-8");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}finally{
//			try {
//				if(response!=null){
//					EntityUtils.consume(response.getEntity());
//					response.close();
//				}
//			} catch (Exception e2) {
//				// TODO: handle exception
//				e2.printStackTrace();
//			}
//		}
//		return null;
//	}
//	public static byte[] httpspostbackBytes(String strURL, String parmas) throws Exception{
//		CloseableHttpResponse response=null;
//		try {
//			HttpPost httpPost = new HttpPost(strURL);
//			httpPost.setEntity(new StringEntity(parmas));
//			httpPost.setHeader("Accept", "application/json");
//			httpPost.setHeader("Content-type", "application/json");
//			response = getHttpClient().execute(httpPost,HttpClientContext.create());
//			HttpEntity entity=response.getEntity();
//			if(entity!=null){
//				return EntityUtils.toByteArray(entity);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}finally{
//			try {
//				if(response!=null){
//					EntityUtils.consume(response.getEntity());
//					response.close();
//				}
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return null;
//	}
//	public static String httpscertpost(String strURL, String parmas,String certPath,String mchid) throws Exception{
//		CloseableHttpResponse response=null;
//		CloseableHttpClient httpClient=null;
//		HttpPost httpPost = new HttpPost(strURL);
//		try {
//			String PKCS12 = "";//WxDaifuUtil.mchid;
//			if(StringUtils.isNotBlank(mchid)){
//			    PKCS12=mchid;
//            }
//			String fileRoute = "/mnt/cert/apiclient_cert.p12";
//			if(StringUtils.isNotBlank(certPath)){
//				fileRoute=certPath+"/apiclient_cert.p12";
//			}
//			KeyStore keyStore = KeyStore.getInstance("PKCS12");
//			FileInputStream instream = new FileInputStream(new File(fileRoute));
//			keyStore.load(instream, PKCS12.toCharArray());
//			instream.close();
//			SSLContext sslcontext = SSLContexts.custom()
//	                .loadKeyMaterial(keyStore, PKCS12.toCharArray())
//	                .build();
//			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
//	                sslcontext,
//	                new String[]{"TLSv1"},
//	                null,
//	                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
//	        httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
//			httpPost.setEntity(new StringEntity(parmas,"UTF-8"));
//			httpPost.addHeader("Connection", "keep-alive");
//			httpPost.addHeader("Accept", "*/*");
//			httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//			httpPost.addHeader("Host", "api.mch.weixin.qq.com");
//			httpPost.addHeader("X-Requested-With", "XMLHttpRequest");
//			httpPost.addHeader("Cache-Control", "max-age=0");
//			httpPost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
//			response = httpClient.execute(httpPost);
//			HttpEntity entity=response.getEntity();
//			if(entity!=null){
//				return EntityUtils.toString(entity,"utf-8");
//			}
//		} catch (Exception e) {
//			return null;
//		}finally{
//			try {
//				if(response!=null){
//					EntityUtils.consume(response.getEntity());
//					response.close();
//				}
//				httpPost.releaseConnection();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		return null;
//	}
//	public static String httpsredpost(String strURL, String parmas) throws Exception{
//		CloseableHttpResponse response=null;
//		CloseableHttpClient httpClient=null;
//		HttpPost httpPost = new HttpPost(strURL);
//		try {
//			String PKCS12 = "1526097341";
//			String fileRoute = "/mnt/cert/apiclient_cert_mp.p12";
//			KeyStore keyStore = KeyStore.getInstance("PKCS12");
//			FileInputStream instream = new FileInputStream(new File(fileRoute));
//			keyStore.load(instream, PKCS12.toCharArray());
//			instream.close();
//			SSLContext sslcontext = SSLContexts.custom()
//	                .loadKeyMaterial(keyStore, PKCS12.toCharArray())
//	                .build();
//			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
//	                sslcontext,
//	                new String[]{"TLSv1"},
//	                null,
//	                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
//	        httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
//			httpPost.setEntity(new StringEntity(parmas,"UTF-8"));
//			httpPost.addHeader("Connection", "keep-alive");
//			httpPost.addHeader("Accept", "*/*");
//			httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//			httpPost.addHeader("Host", "api.mch.weixin.qq.com");
//			httpPost.addHeader("X-Requested-With", "XMLHttpRequest");
//			httpPost.addHeader("Cache-Control", "max-age=0");
//			httpPost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
//			response = httpClient.execute(httpPost);
//			HttpEntity entity=response.getEntity();
//			if(entity!=null){
//				return EntityUtils.toString(entity,"utf-8");
//			}
//		} catch (Exception e) {
//			return null;
//		}finally{
//			try {
//				if(response!=null){
//					EntityUtils.consume(response.getEntity());
//					response.close();
//				}
//				httpPost.releaseConnection();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		return null;
//	}

}
