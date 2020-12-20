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

        //解决跨域的问题
        response.addHeader("Access-Control-Allow-Origin","*");
        //response.addHeader("Access-Control-Allow-Credentials","true");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With,X-App-Id, X-Token");
        response.addHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
        response.addHeader("Access-Control-Max-Age", "3600");
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
