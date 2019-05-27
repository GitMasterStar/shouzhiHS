package com.sz.serviceImpl;

import com.sz.common.vo.TNode;
import com.sz.dao.ParameterMapper;
import com.sz.pojo.Parameter;
import com.sz.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    private ParameterMapper parameterMapper;

    @Override
    public List<TNode> findZtreeParameterTNodes() {
        return parameterMapper.findZtreeParameterTNodes();
    }

    @Override
    public List<Parameter> findObjects(Integer id) {
        //1.校验参数合法性
        if (id==null||id<0)
            throw new IllegalArgumentException("参数id值不正确，id="+id);
        //2.校验数据字典级别，判断是否继续执行
        Parameter parameter = parameterMapper.selectByPrimaryKey(id);
        if (parameter.getLevel()==null||parameter.getLevel()==1)
            return null;
        //3.基于id执行当前数据字典下级查询
        List<Parameter> parameterList = parameterMapper.findObjects(id);
        //4.返回结果
        return parameterList;
    }
}
