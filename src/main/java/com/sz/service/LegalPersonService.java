package com.sz.service;

import com.sz.pojo.Legalperson;

import java.util.Map;

public interface LegalPersonService {

    /**
     * 查询法人信息
     * @return
     */
    Map<String, Object> doFindObjects();

    /**
     * 录入新法人信息
     * @param entity 保存对象
     * @return
     */
    int addObject(Legalperson entity);

    /**
     * 修改法人信息
     * @param entity 修改对象
     * @return
     */
    int updateObject(Legalperson entity);

    /**
     * 删除法人信息
     * @param ids 法人id
     * @return
     */
    int deleteObjects(Integer... ids);

}
