package com.sz.serviceImpl;

import com.sz.dao.LegalpersonMapper;
import com.sz.exception.ServiceException;
import com.sz.pojo.Legalperson;
import com.sz.service.LegalPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LegalPersonServiceImpl implements LegalPersonService {

    @Autowired
    private LegalpersonMapper legalpersonMapper;

    @Override
    public Map<String, Object> doFindObjects() {
        //1.校验参数有效性

        //2.执行查询功能
        //2.1)发薪法人
        List<Legalperson> legalperson0 = legalpersonMapper.selectByPrimaryKeyType(0);
        //2.2)签约法人
        List<Legalperson> legalperson1 = legalpersonMapper.selectByPrimaryKeyType(1);
        //3.封装结果集
        Map<String, Object> map = new HashMap<>();
        map.put("fxfr",legalperson0);
        map.put("qufr",legalperson1);
        //4.返回结果
        return map;
    }

    @Override
    public int addObject(Legalperson entity) {
        //1.校验参数有效性
        if (entity==null)
            throw new IllegalArgumentException("录入对象不能为空");
        if (StringUtils.isEmpty(entity.getLegalname())&&StringUtils.isEmpty(entity.getLegalfullname()))
            throw new IllegalArgumentException("红色星号为必填项，请完整填写");
        //2.执行录入新法人信息
        int rows = legalpersonMapper.insertSelective(entity);
        //3.返回结果
        return rows;
    }

    @Override
    public int updateObject(Legalperson entity) {
        //1.校验参数有效性
        if (entity==null)
            throw new IllegalArgumentException("修改对象不能为空");
        if (StringUtils.isEmpty(entity.getLegalname())&&StringUtils.isEmpty(entity.getLegalfullname()))
            throw new IllegalArgumentException("红色星号为必填项，请完整填写");
        //2.执行修改法人信息
        int rows = legalpersonMapper.updateByPrimaryKeySelective(entity);
        if (rows==0)
            throw new ServiceException("系统查询不到对应对象");
        //3.返回结果
        return rows;
    }

    @Override
    public int deleteObjects(Integer... ids) {
        //1.校验参数合法性
        if (ids.length==0)
            throw new IllegalArgumentException("请选择删除的对象!");
        for (int i=0;i<ids.length;i++)
            if (ids[i]<0)
                throw new IllegalArgumentException("参数值无效，ids["+i+"]="+ids[i]);
        //2.执行删除法人信息
        int rows=0;
        for (int i=0;i<ids.length;i++) {
            rows = legalpersonMapper.deleteByPrimaryKey(ids[i]);
            if (rows==0)
                throw new ServiceException("系统查询不到id为"+ids[i]+"的对应对象");
        }
        //3.返回结果
        return rows;
    }

}
