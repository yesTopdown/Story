package com.example.test6day.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         String requestURI = request.getRequestURI();
         HttpSession session = request.getSession();
         Object login = session.getAttribute("login");
         if(login!=null||requestURI.contains("/register")){
             return true;
         }else {
             request.setAttribute("msg","请先登录");
             request.getRequestDispatcher("/").forward(request,response);
             return false;
         }
    }
}
