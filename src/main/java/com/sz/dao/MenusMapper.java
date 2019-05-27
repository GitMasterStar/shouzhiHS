package com.sz.dao;

import com.sz.common.vo.Node;
import com.sz.pojo.Menus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MenusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menus record);

    int insertSelective(Menus record);

    Menus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menus record);

    int updateByPrimaryKeyWithBLOBs(Menus record);

    int updateByPrimaryKey(Menus record);

    List<String> findPermissions(@Param("menuIds") Integer... menuIds);

    List<Node> findZtreeMenuNodes();

    List<Menus> selectByPrimaryKeyALL();

    /**
     * 统计数量
     * @param name 名称
     * @return
     */
    int getRowCount(@Param("name") String name);

    /**
     * 分页查询
     * @param name 名称
     * @param startIndex 起始位置
     * @param pageSize 数量
     * @return
     */
    List<Menus> findPageObjects(
            @Param("name") String name,
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize);

    /**
     * 添加菜单信息
     * @param entity
     * @return
     */

    /**
     * 查询子权限
     * @param id 权限id
     * @return
     */
    int getClildCount(Integer id);

    /**
     * 通过数据层对象获取所有权限信息
     * @return
     */
    List<Map<String, Object>> findObjects();
}