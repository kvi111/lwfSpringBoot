package com.lwf.springboot.utils;

import com.lwf.springboot.model.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lwf on 2017/3/1.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        switch (response.getStatus()){
            case 404:
                modelAndView.setViewName("error/404");
                break;
            case 500:
                modelAndView.setViewName("error/500");
                break;
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        String url = request.getServletPath();
        System.out.println("post URL："+url);
        if(!url.equals("")){
            //判断是否已登录
            User loginUser = (User)request.getSession().getAttribute("user");
            if(loginUser != null){
                //无session则是未登录状态
                System.out.println(">>>未登录，请重新登录<<<");
                response.sendRedirect("user/login");
                return false;
            }
        }
        return true;
    }
}
