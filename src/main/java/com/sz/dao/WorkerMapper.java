package com.sz.dao;

import com.sz.pojo.Worker;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Worker record);

    int insertSelective(Worker record);

    Worker selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Worker record);

    int updateByPrimaryKey(Worker record);/**
     * 查询用户总数
     * @param workername
     * @return
     */
    int getRowCount(@Param("workername") String workername);

    /**
     * 分页查询用户信息
     * @param workername
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<Worker> findPageObjects(
            @Param("workername") String workername,
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize);
    int deleteObjects(@Param("ids") Integer... ids);

    int doFindByWorker(Worker entity);

}