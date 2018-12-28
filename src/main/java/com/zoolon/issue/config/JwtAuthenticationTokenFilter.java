package com.zoolon.issue.config;

import com.zoolon.issue.domain.auth.UserDetail;
import com.zoolon.issue.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private JwtUtils jwtUtils;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.authTokenStart}")
    private String authTokenStart;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        //获取token
        String auth_token = request.getHeader(this.tokenHeader);
        logger.info(String.format("token : %s.", auth_token));
        //非空切符合标准的token
        if (StringUtils.isNotEmpty(auth_token) && auth_token.startsWith(this.authTokenStart)) {
            //去掉头
            auth_token = auth_token.substring(this.authTokenStart.length());
            //获取用户名
            String username = jwtUtils.getUsernameFromToken(auth_token);
            logger.info(String.format("Checking authentication for userDetail %s.", username));
            if (username != null //有用户名
                    && jwtUtils.containToken(username, auth_token)//有缓存
                    && SecurityContextHolder.getContext().getAuthentication() == null) {//获取当前用户
                //构造回userDetail
                UserDetail userDetail = jwtUtils.getUserFromToken(auth_token);
                if (jwtUtils.validateToken(auth_token, userDetail)) {
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    //重新加回上下文
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    logger.info(String.format("Authenticated userDetail %s, setting security context", username));
                }
            }
        }
        //可能是匿名用户不带token的，需要进入过滤连接
        chain.doFilter(request, response);
    }
}
