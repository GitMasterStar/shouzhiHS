package com.sz.dao;

import com.sz.common.vo.CheckBox;
import com.sz.common.vo.RNode;
import com.sz.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface RoleMapper {
    List<CheckBox> findObjects();

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 查询用户总数
     * @param name 角色名
     * @return
     */
    int getRowCount(@Param("name") String name);

    /**
     * 分页查询角色信息
     * @param name 角色名
     * @param startIndex 起始页数
     * @param pageSize 行数
     * @return
     */
    List<Role> findPageObjects(
            @Param("name") String name,
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize);

    /**
     * 获取角色的树状图
     * @return
     */
    List<RNode> findZtreeRoleRNodes();

    /**
     * 分页查询角色信息
     * @return
     */
    List<Map<String, Object>>   findObject(
            @Param("name") String name,
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize);

    Role selectByName(String name);

}