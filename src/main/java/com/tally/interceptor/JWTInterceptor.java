//
//package com.tally.interceptor;
//import com.tally.core.utils.JwtTokenUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * api拦截器
// * @author Think
// */
//@Component
//public class JWTInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
//                             Object handler) throws Exception {
//        String access_token = request.getParameter("access_token");
//        if(StringUtils.isNotBlank(access_token)){
//            //解析token
//            String user_id = JwtTokenUtils.verifyToken(access_token);
//            if(StringUtils.isBlank(user_id)){
//                return false;
//            }
//            request.setAttribute("user_id",user_id);
//            request.getSession().setAttribute("user_id",user_id);
//            return  true;
//        }
//        return false;
//    }
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//                           ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
//                                Object handler, Exception ex) throws Exception {
//    }
//}
