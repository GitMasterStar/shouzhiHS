package com.sz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sixGlodDetail")
public class SixGlodDetailController {

    @RequestMapping("/doSixGlodDetailList")
    public String doSixGlodDetailList() {
        return "sixGoldDetail";
    }

}
