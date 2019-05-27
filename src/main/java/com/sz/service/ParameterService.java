package com.sz.service;

import com.sz.common.vo.TNode;
import com.sz.pojo.Parameter;

import java.util.List;

public interface ParameterService {

    /**
     * 获取数据字典树状图
     * @return
     */
    List<TNode> findZtreeParameterTNodes();

    /**
     * 获取数据字典第三级信息
     * @param id 数据字典id
     * @return
     */
    List<Parameter> findObjects(Integer id);
}
