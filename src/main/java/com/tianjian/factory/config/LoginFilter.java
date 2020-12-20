package com.tianjian.factory.config;

import com.tianjian.factory.cache.LoginCacheService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tianjian on 2020/12/15.
 */
@WebFilter(urlPatterns = "/task/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    @Autowired
    private LoginCacheService loginCacheService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if(loginCacheService.getUserIdByRequest(request) == null) {
            response.setStatus(401);
            return ;
        }

        String origin = request.getHeader("Origin");

        //解决跨域的问题
        response.addHeader("Access-Control-Allow-Origin",origin);
        System.out.println(origin + "-----------");
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
