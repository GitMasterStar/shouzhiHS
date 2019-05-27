package com.sz.serviceImpl;

import com.sz.common.vo.CheckBox;
import com.sz.common.vo.PageObject;
import com.sz.common.vo.RNode;
import com.sz.dao.RoleMapper;
import com.sz.dao.RoleMenuMapper;
import com.sz.dao.UserRoleMapper;
import com.sz.exception.ServiceException;
import com.sz.pojo.Role;
import com.sz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<CheckBox> findObjects() {
        return roleMapper.findObjects();
    }

    @Override
    public Map<String, Object> findObjectById(Integer id) {
        //1.参数合法性校验
        if(id==null||id<1)
            throw new IllegalArgumentException("角色id值无效！");
        //2.基于角色id查询自身信息
        Role role = roleMapper.selectByPrimaryKey(id);
        if(role==null)
            throw new ServiceException("系统没有查询到相应记录");
        //3.验证结果基于id查询角色对应的菜单id和上级角色信息
        List<Integer> list = roleMenuMapper.findMenuIdsByRoleId(id);
        Role role1 = roleMapper.selectByPrimaryKey(role.getUproleid());
        //4.封装查询结果
        HashMap<String, Object> map = new HashMap<>();
        map.put("role",role);
        map.put("upRole",role1);
        map.put("menuIds",list);
        //5.返回结果集
        return map;
    }

    @Override
    public PageObject<Role> findPageObjects(String name, Integer pageCurrent) {
        //1.验证参数合法性
        //1.1验证pageCurrent的合法性
        if (pageCurrent==null||pageCurrent<1)
            throw new IllegalArgumentException("当前页码不正确");
        //2.基于条件查询总记录数
        //2.1）执行查询
        int rowCount = roleMapper.getRowCount(name);
        //2.2)验证查询结果，假如rowCount等于0弹出错误提示
        if (rowCount==0)
            throw new ServiceException("没有角色信息，请录入新角色信息");
        //3.基于条件查询当前页记录（pageSize定义为2）
        //3.1)定义pageSize
        int pageSize=5;
        //3.2)计算startIndex
        int startIndex=(pageCurrent-1)*pageSize;
        //3.3)执行当前数据的查询操作
        List<Role> roleList = roleMapper.findPageObjects(name, startIndex, pageSize);
        //4.对分页信息以及当前页记录进行封装
        //4.1)构建PageObject对象
        PageObject<Role> pageObject = new PageObject<>();
        //4.2)封装数据
        pageObject.setRowCount(rowCount);
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRecords(roleList);
        //5.返回封装结果
        return pageObject;
    }

    @Override
    public int addObject(Role entity, Integer[] menuIds) {
        //1.验证有效性
        if (entity==null)
            throw new IllegalArgumentException("保存数据不能为空");
        if (StringUtils.isEmpty(entity.getName()))
            throw new IllegalArgumentException("角色名不能为空");
        if (menuIds==null||menuIds.length==0)
            throw new ServiceException("必须为角色分配权限");
        //2.保存角色自身信息
        int rows = roleMapper.insertSelective(entity);
        Role role = roleMapper.selectByName(entity.getName());
        //3.保存角色和权限的关系数据
      if(role.getId()!=null) {
            roleMenuMapper.insertObject(role.getId(), menuIds);
        }
        //4.返回结果
        return rows;
    }

    @Override
    public int updateObject(Role entity, Integer[] menuIds) {
        //1.验证有效性
        if (entity==null)
            throw new IllegalArgumentException("修改对象不能为空");
        if (StringUtils.isEmpty(entity.getName()))
            throw new IllegalArgumentException("角色名不能为空");
        if (menuIds==null||menuIds.length==0)
            throw new ServiceException("必须为角色分配权限");
        //2.保存角色自身信息
        int rows = roleMapper.updateByPrimaryKey(entity);
        if (rows==0)
            throw new ServiceException("系统没有查询到相应记录");
        //3.保存角色和权限的关系数据
        roleMenuMapper.deleteObjectsByRoleId(entity.getId());
        roleMenuMapper.insertObject(entity.getId(), menuIds);
        //4.返回结果
        return rows;
    }

    @Override
    public int deleteObjectById(Integer id) {
        //1.验证合法性
        if (id==null||id<0)
            throw new IllegalArgumentException("角色id值参数无效");
        //2.删除角色自身信息
        int rows = roleMapper.deleteByPrimaryKey(id);
        if (rows==0)
            throw new ServiceException("系统没有查询到相应记录");
        //3.删除角色与权限和用户的关系数据
        roleMenuMapper.deleteObjectsByRoleId(id);
        userRoleMapper.deleteObjectsByRoleId(id);
        //4.返回结果
        return rows;
    }

    @Override
    public int deleteObjectByIds(Integer[] roleIds) {
        //1.验证合法性
        if (roleIds==null||roleIds.length==0)
            throw new ServiceException("请选择需要删除的角色");
        for (int i=0;i<roleIds.length;i++)
            if (roleIds[i]<1)
                throw new IllegalArgumentException("请选择有效的角色id值");
        //2.删除角色及与权限和用户的数据
        for (int i=0;i<roleIds.length;i++){
            //2.1)删除角色自身信息
            roleMapper.deleteByPrimaryKey(roleIds[i]);
            //2.2）删除角色与权限和用户的关系数据
            roleMenuMapper.deleteObjectsByRoleId(roleIds[i]);
            userRoleMapper.deleteObjectsByRoleId(roleIds[i]);
        }
        //3.返回结果
        return 1;
    }

    @Override
    public List<RNode> findZtreeRoleRNodes() {
        return roleMapper.findZtreeRoleRNodes();
    }

    @Override
    public PageObject<Map<String, Object>> findObject(String name, Integer pageCurrent) {
        //1.验证参数合法性
        //1.1验证pageCurrent的合法性
        if (pageCurrent==null||pageCurrent<1)
            throw new IllegalArgumentException("当前页码不正确");
        //2.基于条件查询总记录数
        //2.1）执行查询
        int rowCount = roleMapper.getRowCount(name);
        //2.2)验证查询结果，假如rowCount等于0弹出错误提示
        if (rowCount==0)
            throw new ServiceException("没有角色信息，请录入新角色信息");
        //3.基于条件查询当前页记录（pageSize定义为2）
        //3.1)定义pageSize
        int pageSize=5;
        //3.2)计算startIndex
        int startIndex=(pageCurrent-1)*pageSize;
        //3.3)执行当前数据的查询操作
        List<Map<String, Object>> roleList = roleMapper.findObject(name, startIndex, pageSize);
        //4.对分页信息以及当前页记录进行封装
        //4.1)构建PageObject对象
        PageObject<Map<String, Object>> pageObject = new PageObject<>();
        //4.2)封装数据
        pageObject.setRowCount(rowCount);
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRecords(roleList);
        //5.返回封装结果
        return pageObject;
    }
}
