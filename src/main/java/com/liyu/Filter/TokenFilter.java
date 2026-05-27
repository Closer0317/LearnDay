package com.liyu.Filter;

import com.liyu.Utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取请求路径
        String requestURI = request.getRequestURI();
        //判断路径是否包括登录和注册
        if (requestURI.contains("/user/login") || requestURI.contains("/user/register")){
            filterChain.doFilter(request, response);
            return;
        }
        //获取token
        String token = request.getHeader("token");

        //判断token是否为空
        if(token == null || token.isEmpty()){
            log.info("token为空");
            response.setStatus(401);
            return;
        }
        //解析token
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("令牌非法");
            response.setStatus(401);
            return; //拦截
        }
        //放行
        log.info("令牌合法");
        filterChain.doFilter(request, response);
    }
}
