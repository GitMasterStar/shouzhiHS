package com.sz.dao;

import com.sz.common.vo.Node;
import com.sz.common.vo.Node2;
import com.sz.pojo.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface DeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    int  getChildCount(Integer id);
    /**
     * 查询全部部门信息
     * @return
     */
    List<Map<String, Object>> findObjects();
    List<Node>findZTreeNodes();
}