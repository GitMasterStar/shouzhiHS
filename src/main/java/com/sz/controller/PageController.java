package com.sz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

    @RequestMapping("doPageUI")
    public String doPageUI(){
        return "common/page";
    }
}
