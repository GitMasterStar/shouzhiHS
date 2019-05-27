package com.sz.serviceImpl;

import com.sz.common.vo.Node;
import com.sz.common.vo.Node2;
import com.sz.dao.DeptMapper;
import com.sz.exception.ServiceException;
import com.sz.pojo.Dept;
import com.sz.service.DeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptMapper deptMapper;



    @Override
    public int saveObject(Dept entity) {
        if (entity==null)
        throw new ServiceException("保存对象不能为空");
        if(StringUtils.isEmpty(entity.getDname()))
            throw new ServiceException("部门不能为空");
        int rows= deptMapper.insertSelective(entity);
        return rows;

    }

    @Override
    public int updateObject(Dept entity) {
        if (entity==null)
            throw new ServiceException("修改对象不能为空");
        if(StringUtils.isEmpty(entity.getDname()))
            throw new ServiceException("部门不能为空");
        int rows;
        try {
            rows = deptMapper.updateByPrimaryKeySelective(entity);
        }catch (Exception e){
            e.printStackTrace();
            throw new ServiceException("更新失败");
        }
        return rows;
        }

    @Override
    public int deleteObject(Integer id) {
        if (id==null||id<0)
            throw new ServiceException("数据不正确，id="+id);
        int chileCount=deptMapper.getChildCount(id);
        if(chileCount>0)
            throw new ServiceException("此菜单有子菜单,不允许删除");
        int rows = deptMapper.deleteByPrimaryKey(id);
        if(rows==0)
            throw new ServiceException("信息不存在");
        return rows;
    }

    @Override
    public List<Map<String, Object>> findObjects() {
        return deptMapper.findObjects();
    }

    @Override
    public List<Node> findZTreeNodes() {
        return deptMapper.findZTreeNodes();
    }

    @Override
    public Dept doFindObject(Integer id) {
        return deptMapper.selectByPrimaryKey(id);
    }
}
