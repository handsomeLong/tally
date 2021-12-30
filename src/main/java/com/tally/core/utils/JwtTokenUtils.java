package com.tally.core.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;

/**
 * 功能描述
 *
 * @author: zyu
 * @description:    APP登录Token的生成和解析
 * @date: 2019/3/30 15:14
 */
@Slf4j
public class JwtTokenUtils {

    /**
     * token 过期时间: 90天
     */
    public static final int calendarField = Calendar.DATE;
    public static final int calendarInterval = 720;

    /**
     * JWT生成Token.<br/>
     * <p>
     * JWT构成: header, payload, signature
     *
     * @param user_id 登录成功后用户user_id, 参数user_id不可传空
     */
//    public static String createToken(String user_id) {
//        // expire time
//        Calendar nowTime = Calendar.getInstance();
//        nowTime.add(calendarField, calendarInterval);
//        Date expiresDate = nowTime.getTime();
//        /***** 生成 token ****/
//        String token = Jwts.builder()
////        主题 放入用户名
//                .setSubject(user_id)
////        自定义属性 放入用户拥有请求权限
//                .claim("authorities","admin")
////        失效时间
//                .setExpiration(expiresDate)
////        签名算法和密钥
//                .signWith(SignatureAlgorithm.HS512, "tmax")
//                .compact();
//        return token;
//    }


    /**
     * 解密Token
//     * @param access_token
     * @return
     * @throws Exception
     */
//    public static String verifyToken(String access_token) {
//        String user_id=null;
//        try {
//            Claims claims = Jwts.parser()
//                    .setSigningKey("tmax")
//                    .parseClaimsJws(access_token)
//                    .getBody();
//             if(null!=claims){
//                 user_id=claims.getSubject();
//             }
//        } catch (ExpiredJwtException e) {
//            log.error(e.getLocalizedMessage());
//        } catch (Exception e){
//            log.error(e.getLocalizedMessage());
//        }
//        return  user_id;
//    }

    public static void main(String[] args) {
//        String  token = createToken("28");
//        System.out.println(token);
    }
}