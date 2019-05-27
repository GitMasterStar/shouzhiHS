package com.sz.service;

import com.sz.common.vo.Node;
import com.sz.pojo.Dept;

import java.util.List;
import java.util.Map;

public interface DeptService {

    int saveObject(Dept entity);
    int updateObject(Dept entity);
    int deleteObject(Integer id);

    List<Map<String,Object>> findObjects();
    List<Node>findZTreeNodes();
    Dept doFindObject(Integer id);
}
