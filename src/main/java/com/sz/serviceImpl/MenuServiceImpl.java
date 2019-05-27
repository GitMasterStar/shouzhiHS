package com.sz.serviceImpl;

import com.sz.common.vo.Node;
import com.sz.common.vo.PageObject;
import com.sz.dao.MenusMapper;
import com.sz.dao.RoleMenuMapper;
import com.sz.exception.ServiceException;
import com.sz.pojo.Menus;
import com.sz.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenusService {

    @Autowired
    private MenusMapper menusMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public int saveObjects(Menus entity) {
        if(entity==null)
            throw new IllegalArgumentException("保存对象不能为空");
        if(StringUtils.isEmpty(entity.getName()))
            throw new IllegalArgumentException("菜单名不允许为空");

        int rows =menusMapper.insert(entity);
        if (rows!=1)
            throw  new ServiceException("系统没有查询到相应记录");

        return rows;
    }

    @Override
    public List<Menus> findObject() {
        List<Menus> menusList = menusMapper.selectByPrimaryKeyALL();
        if (menusList==null)
            throw new ServiceException();
        return menusList;
    }

    @Override
    public List<Map<String, Object>> findObjects() {
        List<Map<String, Object>> list = menusMapper.findObjects();
        if (list==null||list.size()==0)
            throw new ServiceException();
        return list;
    }

    @Override
    public List<Node> findZtreeMenuNodes() {
        List<Node> list = menusMapper.findZtreeMenuNodes();
        if (list==null||list.size()==0)
            throw new ServiceException();
        return list;
    }

    @Override
    public PageObject<Menus> findPageObjects(String name, Integer pageCurrent, Integer pageSize) {
        //1.校验参数合法性
        if (pageCurrent==null||pageCurrent<=0)
            throw new ServiceException("请选择页数");
        //2.依据条件获取总记录数
        int rowCount = menusMapper.getRowCount(name);
        if (rowCount==0)
            throw new ServiceException("系统没有查询到相应记录");
        //3.计算startIndex的值
        if (pageSize==null)
            pageSize = 3;
        int startIndex = (pageCurrent-1)*pageSize;
        //4.依据条件获取当前页数
        List<Menus> menusList = menusMapper.findPageObjects(name, startIndex, pageSize);
        //5.封装数据
        PageObject<Menus> pageObject = new PageObject<>();
        pageObject.setRowCount(rowCount);
        pageObject.setPageSize(pageSize);
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setRecords(menusList);
        //6.返回结果集
        return pageObject;
    }

    @Override
    public int updateObject(Menus entity) {
        //1.校验参数有效性
        if (entity==null)
            throw new IllegalArgumentException("修改对象不能为空");
        if (StringUtils.isEmpty(entity.getName()))
            throw new IllegalArgumentException("权限资源名称不能为空");
        //2.执行修改权限资源信息操作
        int rows = menusMapper.updateByPrimaryKeySelective(entity);
        if (rows==0)
            throw new ServiceException("系统没有查询到相应记录");
        //3.返回操作结果
        return rows;
    }

    @Override
    public int deleteObject(Integer id) {
        //1.校验参数有效性
        if (id==null||id<1)
            throw new IllegalArgumentException("权限资源id值无效,id="+id);
        //2.判断是否还有子权限
        int count = menusMapper.getClildCount(id);
        if (count>0)
            throw new ServiceException("请先删除子权限");
        //3.执行删除资源权限操作
        int rows = menusMapper.deleteByPrimaryKey(id);
        if (rows==0)
            throw new ServiceException("系统没有查询到相应记录");
        //4.基于权限资源id，删除资源和角色的关系
        roleMenuMapper.deleteObjectsByMenuId(id);
        //5.返回结果
        return rows;
    }
}
