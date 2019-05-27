package com.sz.common.util;

import com.sun.tools.internal.xjc.util.CodeModelClassFactory;
import com.sz.pojo.User;
import org.springframework.cache.config.CacheManagementConfigUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionInterceptor implements HandlerInterceptor {
    /*private static final String LoginUrl="/doSession.do";*/
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        HttpSession session = httpServletRequest.getSession(true);
        String name = (String) session.getAttribute("username");
        System.out.println(name);
        if( session.getAttribute("username")==null||"".equals( session.getAttribute("username").toString())){
            httpServletResponse.sendRedirect("/doLoginUI.do");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
