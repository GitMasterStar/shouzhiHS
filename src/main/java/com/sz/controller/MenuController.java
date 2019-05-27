package com.sz.controller;


import com.sz.common.vo.JsonResult;
import com.sz.common.vo.PageObject;
import com.sz.pojo.Menus;
import com.sz.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenusService menusService;

    @RequestMapping("/doMenuList")
    public String doMenuList(){
        return "menu";
    }

    @RequestMapping("/doMenuEditUI")
    public String doMenuEditUI() {
        return "menuEditUI";
    }

    /**
     * 新增权限资源信息
     * @param entity 保存对象
     * @return
     */
    @RequestMapping("/doSaveObject")
    @ResponseBody
    public JsonResult doSaveObject(Menus entity){
        menusService.saveObjects(entity);
        return new JsonResult("添加成功");
    }

    /**
     * 查询权限资源信息（全部）
     * @return
     */
    @RequestMapping("/doFindObjects")
    @ResponseBody
    public JsonResult doFindObjects(){
        List<Menus> Menus = menusService.findObject();
        return new JsonResult(Menus);
    }

    /**
     * 查询权限资源信息（全部）
     * @return
     */
    @RequestMapping("/dofindObjects")
    @ResponseBody
    public JsonResult dofindObjects(){
        return new JsonResult(menusService.findObjects());
    }

    /**
     * 查询上级菜单的节点信息
     * @return
     */
    @RequestMapping("/doFindZtreeMenuNodes")
    @ResponseBody
    public JsonResult doFindZtreeMenuNodes(){
        return new JsonResult(menusService.findZtreeMenuNodes());
    }

    /**
     * 分页查询权限信息
     * @param name 名称
     * @param pageCurrent 页数
     * @return
     */
    @RequestMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String name, Integer pageCurrent, Integer pageSize){
        PageObject<Menus> menusPageObject = menusService.findPageObjects(name, pageCurrent, pageSize);
        return new JsonResult(menusPageObject);
    }

    /**
     * 修改权限资源信息
     * @param entity 修改对象
     * @return
     */
    @RequestMapping("doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(Menus entity){
        menusService.updateObject(entity);
        return new JsonResult("修改权限资源信息成功");
    }

    /**
     * 删除权限资源信息
     * @param id 权限资源id
     * @return
     */
    @RequestMapping("doDeleteObject")
    @ResponseBody
    public JsonResult doDeleteObject(Integer id){
        menusService.deleteObject(id);
        return new JsonResult("删除权限资源信息成功");
    }
}
