package com.sz.controller;


import com.sz.common.vo.JsonResult;
import com.sz.pojo.Dept;
import com.sz.service.DeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/doDeptList")
    public String doDeptList(){
        return "dept";
    }
    @RequestMapping("/doLoadUI")
    public String doLoadUI(){
        return "deptUI";
    }
    /**
     * 新增部门信息
     * @param entity
     * @return
     */
    @RequestMapping("/doSaveObject")
    @ResponseBody
    public JsonResult doSaveObject(Dept entity){
        deptService.saveObject(entity);
        return new JsonResult("保存成功!");
    }

    /**
     * 修改部门信息
     * @param entity
     * @return
     */
    @RequestMapping("/doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(Dept entity){
        deptService.updateObject(entity);
        return new JsonResult("修改成功!");
    }

    /**
     * 删除部门信息
     * @param id
     * @return
     */
    @RequestMapping("/doDeleteObejct")
    @ResponseBody
    public JsonResult doDeleteObject(Integer id){
        deptService.deleteObject(id);
        return new JsonResult("删除成功!");
    }

    @RequestMapping("/doFindObjects")
    @ResponseBody
    public JsonResult doFindObjects(){
        return new JsonResult(deptService.findObjects());
    }

    @RequestMapping("/doFindZTreeNodes")
    @ResponseBody
    public JsonResult doFindZTreeNodes(){
        return new JsonResult(deptService.findZTreeNodes());
    }

    @RequestMapping("/doFindObject")
    @ResponseBody
    public JsonResult doFindObject(Integer id){
        return new JsonResult(deptService.doFindObject(id));
    }
}
