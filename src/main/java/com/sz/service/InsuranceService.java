package com.sz.service;

import com.sz.common.vo.PageObject;
import com.sz.pojo.Insurance;

public interface InsuranceService {

    /**
     * 分页查询六金配置信息
     * @param pageCurrent 页码
     * @return
     */
    PageObject<Insurance> findPageObjects(Integer pageCurrent);

}
