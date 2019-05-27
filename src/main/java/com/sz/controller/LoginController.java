package com.sz.controller;


import com.sz.common.vo.JsonResult;
import org.apache.shiro.web.servlet.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping("index")
    public String Index(){
        return  "index";
    }
    @RequestMapping("doLoginUI")
    public String doLoginUI(){
        return  "login";
    }
    @RequestMapping("doSession")
    public String doSession(){return "SessionTimeOut";}

}
