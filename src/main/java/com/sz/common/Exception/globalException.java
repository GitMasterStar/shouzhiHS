package com.sz.common.Exception;

import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class globalException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        System.out.println("==========异常开始==========");
        //如果是shiro无权限操作，因为shiro在操作auno等一部分不进行转发至无权限url
        if(e instanceof UnauthenticatedException){
            ModelAndView mv = new ModelAndView("403");
            return mv;
        }
        e.printStackTrace();
        System.out.println("============异常结束=============");
        ModelAndView mv = new ModelAndView("403");
        mv.addObject("exception",e.toString().replaceAll("\n","<br/>"));
        return null;
    }
}
