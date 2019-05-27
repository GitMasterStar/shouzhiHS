package com.sz.dao;

import com.sz.common.vo.RNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleMenuMapper {
    /**
     * 基于角色id查询关系表中角色id对应菜单id
     * @param roleIds
     * @return
     */
    List<Integer> findMenuIdsByRoleId(@Param("roleIds") Integer... roleIds);

    /**
     * 写入角色和菜单的关系数据(本质上是在为角色进行授权操作)
     * @param roleId
     * @param menuIds
     * @return
     */
    int insertObject(@Param("id") Integer roleId,
                     @Param("menuIds") Integer[] menuIds);

    /**
     * 基于菜单id删除角色与菜单的关系数据
     * @param menuId
     * @return
     */
    int deleteObjectsByMenuId(Integer menuId);

    /**
     * 基于角色id删除角色与菜单的关系数据
     * @param roleId
     * @return 删除的行数
     */
    int deleteObjectsByRoleId(Integer roleId);
}
