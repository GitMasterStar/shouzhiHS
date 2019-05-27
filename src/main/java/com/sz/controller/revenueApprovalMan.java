package com.sz.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/revenue")
public class revenueApprovalMan {

    @RequestMapping("/doApprovalMan")
    public String approvalMan(){
        return "revenueApprovalMan";
    }
}
