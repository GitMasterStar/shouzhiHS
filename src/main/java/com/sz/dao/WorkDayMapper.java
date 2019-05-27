package com.sz.dao;

import com.sz.pojo.WorkDay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkDayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkDay record);

    int insertSelective(WorkDay record);

    WorkDay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkDay record);

    int updateByPrimaryKey(WorkDay record);

    /**
     * 总记录数
     * @return
     */
    int getRowCount();

    /**
     * 分页查询工作日信息
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<WorkDay> findPageObjects(
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize);
}