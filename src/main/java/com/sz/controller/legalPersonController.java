package com.sz.controller;

import com.sz.common.vo.JsonResult;
import com.sz.common.vo.PageObject;
import com.sz.pojo.Customer;
import com.sz.pojo.Legalperson;
import com.sz.service.CustomerService;
import com.sz.service.LegalPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/legalPerson")
public class legalPersonController {

    @Autowired
    private LegalPersonService legalPersonService;

    @RequestMapping("/doLegalPersonList")
    public String doLegalPersonList(){
        return "legalPerson";
    }

    @RequestMapping("/doLegalPersonEditUI")
    public String doLegalPersonEditUI(){
        return "legalPersonEditUI";
    }

    @RequestMapping("/doLegalList")
    public String doLegalList() {
        return "legal";
    }

    @RequestMapping("/doLegalEditUI")
    public String doLegalEditUI(){
        return "legalEditUI";
    }

    /**
     * 查询相应法人信息
     * @param legalId
     * @return
     */
    @RequestMapping("/doFindObjects")
    @ResponseBody
    public JsonResult doFindObjects(Integer legalId){
        Map<String, Object> map = legalPersonService.doFindObjects();
        return new JsonResult(map);
    }

    /**
     * 录入新法人信息
     * @param entity 保存对象
     * @return
     */
    @RequestMapping("/doAddObject")
    @ResponseBody
    public JsonResult doAddObject(Legalperson entity) {
        legalPersonService.addObject(entity);
        return new JsonResult("法人信息录入成功");
    }

    /**
     * 修改法人信息
     * @param entity 修改对象
     * @return
     */
    @RequestMapping("/doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(Legalperson entity) {
        legalPersonService.updateObject(entity);
        return new JsonResult("法人信息修改成功");
    }

    /**
     * 批量删除法人信息
     * @param ids 法人id集合
     * @return
     */
    @RequestMapping("/doDeleteObjects")
    @ResponseBody
    public JsonResult doDeleteObjects(Integer... ids) {
        legalPersonService.deleteObjects(ids);
        return new JsonResult("删除法人信息成功");
    }

}
