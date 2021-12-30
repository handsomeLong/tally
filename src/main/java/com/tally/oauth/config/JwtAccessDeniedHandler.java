package com.tally.oauth.config;
 
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 *访问请求处理
 */
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler, Serializable {
 
    private static final long serialVersionUID = -1846494756214482215L;
 
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException authException) throws IOException, ServletException {
        /**
         *  用户已经通过了认证，在访问一个受保护的资源，但是权限不够，那么抛出异常
         */
        response.sendError(605, authException==null?"Unauthorized":authException.getMessage());
 
    }
 
}