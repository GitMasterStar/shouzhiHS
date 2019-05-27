package com.sz.dao;

import com.sz.common.vo.TNode;
import com.sz.pojo.Parameter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParameterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Parameter record);

    int insertSelective(Parameter record);

    Parameter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Parameter record);

    int updateByPrimaryKey(Parameter record);


    /**
     * 获取数据字典树状图
     * @return
     */
    List<TNode> findZtreeParameterTNodes();

    /**
     * 获取下级信息
     * @param id
     * @return
     */
    List<Parameter> findObjects(@Param("id") Integer id);
}