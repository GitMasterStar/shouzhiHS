package com.sz.service;

import com.sz.common.vo.PageObject;
import com.sz.pojo.WorkDay;

public interface WorkDayService {

    /**
     * 分页查询工作日信息
     * @param pageCurrent 页码
     * @return
     */
    PageObject<WorkDay> findPageObjects(Integer pageCurrent);

    /**
     * 新增工作日信息
     * @param entity 保存对象
     * @return
     */
    int addObject(WorkDay entity);

    /**
     * 修改工作日信息
     * @param entity 修改对象
     * @return
     */
    int updateObject(WorkDay entity);

    /**
     * 删除工作日信息(可批量)
     * @param ids id集合
     * @return
     */
    int deleteObjects(Integer... ids);

}
