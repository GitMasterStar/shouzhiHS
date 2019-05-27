package com.sz.controller;

import com.sz.common.vo.JsonResult;
import com.sz.common.vo.PageObject;
import com.sz.pojo.Customer;
import com.sz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/doCustomerList")
    public String doCustomerList(){
        return "customer";
    }

    @RequestMapping("/doCustomerEditUI")
    public String doCustomerEditUI(){
        return "customerEditUI";
    }

    /**
     * 分页查询客户信息
     * @param cname 客户名称
     * @param pageCurrent 页数
     * @return
     */
    @RequestMapping("/doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String cname,Integer pageCurrent) {
        PageObject<Customer> pageObject = customerService.findPageObjects(cname,pageCurrent);
        return new JsonResult(pageObject);
    }

    /**
     * 录入新客户信息
     * @param entity 录入对象
     * @return
     */
    @RequestMapping("/doAddObject")
    @ResponseBody
    public JsonResult doAddObject(Customer entity) {
        customerService.addObject(entity);
        return new JsonResult("新客户录入成功");
    }

    /**
     * 编辑客户信息
     * @param entity 编辑对象
     * @return
     */
    @RequestMapping("/doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(Customer entity) {
        customerService.updateObject(entity);
        return new JsonResult("客户信息编辑成功");
    }

    /**
     * 批量删除客户信息
     * @param ids 客户id集合
     * @return
     */
    @RequestMapping("/doDeleteObjects")
    @ResponseBody
    public JsonResult doDeleteObjects(Integer... ids) {
        customerService.deleteObjects(ids);
        return new JsonResult("删除客户信息成功");
    }

    /**
     * 修改客户状态
     * @param id 对象id
     * @param status 修改状态
     * @return
     */
    @RequestMapping("/doStatusById")
    @ResponseBody
    public JsonResult doStatusById(Integer id, Integer status) {
        customerService.statusById(id,status);
        return new JsonResult("客户状态修改成功");
    }

}
