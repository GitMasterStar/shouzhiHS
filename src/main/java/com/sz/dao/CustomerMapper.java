package com.sz.dao;

import com.sz.pojo.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    /**
     * 统计查询数量
     * @param cname 客户简称
     * @return
     */
    int getRowCount(@Param("cname") String cname,
                    @Param("ctype") Integer ctype,
                    @Param("cstatus") Integer cstatus);

    /**
     * 分页查询客户信息
     * @param cname 客户简称
     * @param startIndex 起始页码
     * @param pageSize 页面大小
     * @return
     */
    List<Customer> findPageObjects(
            @Param("cname") String cname,
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize);

    /**
     * 修改客户状态
     * @param id 对象id
     * @param status 修改状态
     * @return
     */
    int statusById(@Param("id") Integer id, @Param("status") Integer status);


}