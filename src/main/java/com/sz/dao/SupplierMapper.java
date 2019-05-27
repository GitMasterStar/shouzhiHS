package com.sz.dao;

import com.sz.pojo.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

    /**
     * 总记录数
     * @param sname
     * @return
     */
    int getRowCount(@Param("sname") String sname,
                    @Param("type") Integer type,
                    @Param("status") Integer status);

    /**
     * 分页查询
     * @param sname
     * @param type
     * @param status
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<Supplier> findPageObjects(
            @Param("sname") String sname,
            @Param("type") Integer type,
            @Param("status") Integer status,
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize);

    /**
     * 基于id修改供应商状态
     * @param ids 供应商id
     * @param status 供应商状态
     * @return
     */
    int statusById(
            @Param("status") Integer status,
            @Param("name") String name,
            @Param("ids") Integer... ids);
}