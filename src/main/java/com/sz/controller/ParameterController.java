package com.sz.controller;


import com.sz.common.vo.JsonResult;
import com.sz.pojo.Parameter;
import com.sz.service.DeptService;
import com.sz.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/parameter")
public class ParameterController {

    @Autowired
    private ParameterService parameterService;

    @RequestMapping("/doParameterList")
    public String doParameterList(){
        return "parameter";
    }

    /**
     * 获取数据字典的树状图
     * @return
     */
    @RequestMapping("/doFindZtreeObjects")
    @ResponseBody
    public JsonResult doFindZtreeObjects(){
        return new JsonResult(parameterService.findZtreeParameterTNodes());
    }

    /**
     * 获取第三级的数据字典
     * @param id 数据字典id
     * @return
     */
    @RequestMapping("/doFindObjects")
    @ResponseBody
    public JsonResult doFindObjects(Integer id) {
        List<Parameter> parameters = parameterService.findObjects(id);
        return new JsonResult(parameters);
    }
}
