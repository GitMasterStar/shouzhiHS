package com.sz.controller;

import com.sz.common.vo.JsonResult;
import com.sz.common.vo.PageObject;
import com.sz.pojo.Insurance;
import com.sz.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping("/doInsuranceList")
    public String doInsuranceList() {
        return "insurance";
    }

    /**
     * 分页查询六金配置信息
     * @param pageCurrent 页码
     * @return
     */
    @RequestMapping("/doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(Integer pageCurrent) {
        PageObject<Insurance> pageObjects = insuranceService.findPageObjects(pageCurrent);
        return new JsonResult(pageObjects);
    }

}
