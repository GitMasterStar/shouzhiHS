package com.sz.service;


import com.sz.common.vo.Node;
import com.sz.common.vo.PageObject;
import com.sz.pojo.Menus;

import java.util.List;
import java.util.Map;

public interface MenusService {

    /**
     * 添加菜单信息
     * @param entity
     * @return
     */
    int saveObjects(Menus entity);

    /**
     * 查询菜单全部信息
     * @return
     */
    List<Menus> findObject();

    /**
     * 查询菜单全部信息
     * @return
     */
    List<Map<String, Object>> findObjects();

    /**
     * 查询权限节点信息
     * @return
     */
    List<Node> findZtreeMenuNodes();

    /**
     * 分页查询资源信息
     * @param name 名称
     * @param pageCurrent 页数
     * @return
     */
    PageObject<Menus> findPageObjects(String name, Integer pageCurrent, Integer pageSize);

    /**
     * 修改权限资源信息
     * @param entity 保存对象
     * @return
     */
    int updateObject(Menus entity);

    /**
     * 基于权限资源id删除权限资源信息
     * @param id 权限资源id
     * @return
     */
    int deleteObject(Integer id);
}
