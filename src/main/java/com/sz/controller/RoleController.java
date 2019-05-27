package com.sz.controller;


import com.sz.common.vo.JsonResult;
import com.sz.common.vo.PageObject;
import com.sz.pojo.Role;
import com.sz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/doRoleList")
    public String doRoleList(){
        return "role";
    }

    @RequestMapping("/doRoleEditUI")
    public String doRoleEditUI() {
        return "roleEditUI";
    }

    @RequestMapping("/doFindObjects")
    @ResponseBody
    public JsonResult doFindObjects(){
        return new JsonResult(roleService.findObjects());
    }

    /**
     * 基于角色id查询角色信息
     * @param id 角色id
     * @return
     */
    @RequestMapping("/doFindObjectById")
    @ResponseBody
    public JsonResult doFindObjectById(Integer id){
        Map<String, Object> map = roleService.findObjectById(id);
        return new JsonResult(map);
    }

    /**
     * 分页查询角色信息
     * @param name 角色名称
     * @param pageCurrent 页数
     * @return
     */
    @RequestMapping("/doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String name,Integer pageCurrent){
        PageObject<Role> pageObject = roleService.findPageObjects(name, pageCurrent);
        PageObject<Map<String, Object>> pageObjects = roleService.findObject(name, pageCurrent);
        return new JsonResult(pageObjects);
    }

    /**
     * 添加角色信息及与菜单权限的关系数据
     * @param entity 保存对象
     * @return
     */
    @RequestMapping("/doAddObject")
    @ResponseBody
    public JsonResult doAddObject(Role entity, Integer[] menuIds){
        roleService.addObject(entity,menuIds);
        return new JsonResult("角色添加成功");
    }

    /**
     * 修改角色信息及与菜单权限的关系数据
     * @param entity 修改对象
     * @param menuIds 权限id
     * @return
     */
    @RequestMapping("/doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(Role entity, Integer[] menuIds){
        roleService.updateObject(entity, menuIds);
        return new JsonResult("角色信息修改成功");
    }

    /**
     * 删除角色信息及相关的权限数据
     * @param id 角色id
     * @return
     */
    @RequestMapping("doDeleteObjectById")
    @ResponseBody
    public JsonResult doDeleteObjectById(Integer id){
        roleService.deleteObjectById(id);
        return new JsonResult("角色信息删除成功");
    }

    /**
     * 删除角色信息及相关的权限数据
     * @param roleIds 角色id
     * @return
     */
    @RequestMapping("doDeleteObjectByIds")
    @ResponseBody
    public JsonResult doDeleteObjectByIds(Integer[] roleIds){
        roleService.deleteObjectByIds(roleIds);
        return new JsonResult("角色信息删除成功");
    }

    /**
     * 获取角色的树状图
     * @return
     */
    @RequestMapping("/doFindZtreeRoleNodes")
    @ResponseBody
    public JsonResult doFindZtreeRoleNodes(){
        return new JsonResult(roleService.findZtreeRoleRNodes());
    }
}
