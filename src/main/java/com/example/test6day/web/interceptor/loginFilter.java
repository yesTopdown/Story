package com.example.test6day.web.interceptor;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
//@WebFilter("/*")
public class loginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取请求路径
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();
        // System.out.println(uri);
        if(uri.contains("/user/*")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            Object login = httpServletRequest.getSession().getAttribute("login");
            if (login == null) {
                servletRequest.setAttribute("msg","请先登录");
                servletRequest.getRequestDispatcher("/").forward(servletRequest, servletResponse);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }

        }
}

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
