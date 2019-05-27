package com.sz.controller;

import com.sz.common.vo.JsonResult;
import com.sz.common.vo.PageObject;
import com.sz.pojo.Supplier;
import com.sz.pojo.User;
import com.sz.service.SupplierService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @RequestMapping("/doSupplierList")
    public String doSupplierList() {
        return "supplier";
    }

    @RequestMapping("/doSupplierEditUI")
    public String doSupplierEditUI() {
        return "supplierEditUI";
    }

    /**
     * 分页查询供应商信息
     * @param sname
     * @param type
     * @param sstatus
     * @param pageCurrent
     * @return
     */
    @RequestMapping("/doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String sname, Integer type, Integer sstatus, Integer pageCurrent) {
        PageObject<Supplier> pageObjects = supplierService.findPageObjects(sname, type, sstatus, pageCurrent);
        return new JsonResult(pageObjects);
    }

    /**
     * 新增供应商信息
     * @param entity 保存对象
     * @return
     */
    @RequestMapping("/doAddObject")
    @ResponseBody
    public JsonResult doAddObject(Supplier entity) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        entity.setCreateduser(user.getUserrealname());
        supplierService.addObject(entity);
        return new JsonResult("供应商新增成功");
    }

    /**
     * 修改供应商信息
     * @param entity 修改对象
     * @return
     */
    @RequestMapping("/doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(Supplier entity) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        entity.setModifieduser(user.getUserrealname());
        supplierService.updateObject(entity);
        return new JsonResult("供应商信息修改成功");
    }

    /**
     * 供应商状态修改成功
     * @param ids 供应商id
     * @param status 供应商状态
     * @return
     */
    @RequestMapping("/doStatusById")
    @ResponseBody
    public JsonResult doStatusById(Integer status,Integer... ids) {
        supplierService.statusById(status, ids);
        return new JsonResult("状态修改成功");
    }

    /**
     * 删除供应商对象(批量)
     * @param ids 供应商id集合
     * @return
     */
    @RequestMapping("/doDeleteObjects")
    @ResponseBody
    public JsonResult doDeleteObjects(Integer... ids) {
        supplierService.deleteObjects(ids);
        return new JsonResult("删除供应商信息成功");
    }

}
