package com.sz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/revenueReport")
public class revenueReportManController {

    @RequestMapping("/doRevenueReportManList")
    public String doRevenueReportManList() {
        return "revenueReportMan";
    }

}
