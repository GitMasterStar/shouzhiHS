package com.sz.service;

import com.sz.common.vo.PageObject;
import com.sz.pojo.Supplier;

public interface SupplierService {

    /**
     * 分页查询供应商信息
     * @param sname
     * @param type
     * @param sstatus
     * @param pageCurrent
     * @return
     */
    PageObject<Supplier> findPageObjects(String sname, Integer type, Integer sstatus, Integer pageCurrent);

    /**
     * 新增供应商信息
     * @param entity 保存对象
     * @return
     */
    int addObject(Supplier entity);

    /**
     * 修改供应商信息
     * @param entity 修改对象
     * @return
     */
    int updateObject(Supplier entity);

    /**
     * 修改id对应的供应商状态
     * @param ids 对应id
     * @param status 修改的状态
     * @return
     */
    int statusById(Integer status,Integer... ids);

    /**
     * 基于id删除供应商信息(批量)
     * @param ids id集合
     * @return
     */
    int deleteObjects(Integer... ids);

}
