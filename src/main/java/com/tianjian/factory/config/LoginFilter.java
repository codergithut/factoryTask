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
    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        if(loginCacheService.getUserIdByRequest((HttpServletRequest) request) == null) {
            HttpServletResponse response = (HttpServletResponse)servletResponse;
            response.setStatus(401);
            //return ;
        }
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
