package com.sz.service;

import com.sz.common.vo.CheckBox;
import com.sz.common.vo.JsonResult;
import com.sz.common.vo.PageObject;
import com.sz.common.vo.RNode;
import com.sz.pojo.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {

    List<CheckBox> findObjects();

    /**
     * 基于角色id查询角色相关信息
     * @param id
     * @return
     */
    Map<String, Object> findObjectById(Integer id);

    /**
     * 分页查询
     * @param name
     * @param pageCurrent
     * @return
     */
    PageObject<Role> findPageObjects(String name, Integer pageCurrent);

    /**
     * 添加新角色
     * @param entity 保存对象
     * @return
     */
    int addObject(Role entity, Integer[] menuIds);

    /**
     * 修改角色信息
     * @param entity 修改对象
     * @param menuIds 权限id
     * @return
     */
    int updateObject(Role entity, Integer[] menuIds);

    /**
     * 删除角色信息及相关权限数据
     * @param id 角色Id
     * @return
     */
    int deleteObjectById(Integer id);

    /**
     * 删除角色信息及相关权限数据
     * @param roleIds 角色Id
     * @return
     */
    int deleteObjectByIds(Integer[] roleIds);

    /**
     * 获取角色树状图
     * @return
     */
    List<RNode> findZtreeRoleRNodes();

    /**
     * 分页查询角色信息（带上级角色名称）
     * @return
     */
    PageObject<Map<String, Object>> findObject(String name, Integer pageCurrent);
}
