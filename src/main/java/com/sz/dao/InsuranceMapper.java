package com.sz.dao;

import com.sz.pojo.Insurance;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Insurance record);

    int insertSelective(Insurance record);

    Insurance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Insurance record);

    int updateByPrimaryKey(Insurance record);

    /**
     * 统计总记录数
     * @return
     */
    int getRowCount();

    /**
     * 分页查询六金配置信息
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<Insurance> findPageObjects(
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize);
}