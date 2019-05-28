package com.sz.service;

import com.sz.common.vo.PageObject;
import com.sz.pojo.Customer;

public interface CustomerService {

    /**
     * 分页查询客户信息
     * @param cname 客户简称
     * @param pageCurrent 页数
     * @return
     */
    PageObject<Customer> findPageObjects(String cname, Integer pageCurrent,Integer ctype, Integer cstatus);

    /**
     * 录入新客户信息
     * @param entity 录入对象
     * @return
     */
    int addObject(Customer entity);

    /**
     * 编辑客户信息
     * @param entity 编辑对象
     * @return
     */
    int updateObject(Customer entity);

    /**
     * 批量删除客户信息
     * @param ids 删除对象
     * @return
     */
    int deleteObjects(Integer... ids);

    /**
     * 修改客户状态
     * @param id 对象id
     * @param status 修改状态
     * @return
     */
    int statusById(Integer id, Integer status);

}
