package com.sz.serviceImpl;

import com.sun.deploy.net.HttpRequest;
import com.sz.common.vo.JsonResult;
import com.sz.common.vo.Node;
import com.sz.common.vo.PageObject;
import com.sz.dao.DeptMapper;
import com.sz.dao.RoleMapper;
import com.sz.dao.UserMapper;
import com.sz.dao.UserRoleMapper;
import com.sz.exception.ServiceException;
import com.sz.pojo.Dept;
import com.sz.pojo.Role;
import com.sz.pojo.User;
import com.sz.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageObject<Map<String, Object>> findPageObjects(String userrealname, Integer pageCurrent) {
        //1.参数合法性验证
        if (pageCurrent==null||pageCurrent<=0)
            throw new ServiceException("参数不合法");
        //2.依据条件获取总记录数
        int rowCount=userMapper.getRowCount(userrealname);
        /*if (rowCount==0)
            throw new ServiceException("记录不存在");*/
        //3.计算startIndex的值
        int pageSize = 15;
        int startIndex = (pageCurrent-1)*pageSize;
        //4.依据条件获取当前页数
        List<Map<String,Object>> userList = userMapper.findPageObjects(userrealname,startIndex,pageSize);

        //5.封装数据
        PageObject<Map<String,Object>> pageObject = new PageObject<>();
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setRowCount(rowCount);
        pageObject.setPageSize(pageSize);
        pageObject.setRecords(userList);
        return pageObject;
    }

    @Override
    public User findUserByUserName(String username) {
        //1.判断参数合法性
        if  (username==null)
            throw new IllegalArgumentException("没有参数");
        //2.执行查询用户信息
        User user = userMapper.findUserByUserName(username);
        return user;
    }

    @Override
    public User findUserById(Integer userid) {
        //1.判断参数合法性
        if (userid==null||userid<=0)
            throw new IllegalArgumentException("userId值参数不正确");
        //2.执行查询用户信息
        User user = userMapper.selectByPrimaryKey(userid);
        return user;
    }

    @Override
    public int validById(Integer userid, Integer valid,HttpSession session) {
        //1.参数合法性校验
        if (userid==null||userid<1)
            throw new IllegalArgumentException("用户id值无效，id="+userid);
        if (valid!=0&&valid!=1)
            throw new IllegalArgumentException("状态值无效，valid="+valid);
        //2.执行状态更新操作
        String username = (String) session.getAttribute("username");
        User loginUser = userMapper.findUserByUserName(username);
        String updateuser = loginUser.getUserrealname();
        if (StringUtils.isEmpty(updateuser))
            throw new ServiceException("修改用户不能为空");
        int rows = userMapper.validById(userid,valid,updateuser);
        //3.验证结果并返回
        return rows;
    }

    @Override
    @RequiresPermissions("add")
    public int addObject(User entity, Integer[] roleIds, HttpSession session) {
        //1.验证参数合法性
        if (entity==null)
            throw new IllegalArgumentException("保存对象不能为空");
        if (StringUtils.isEmpty(entity.getUsername()))
            throw new IllegalArgumentException("用户名不能为空");
        if (StringUtils.isEmpty(entity.getUserpwd()))
            throw new IllegalArgumentException("密码不能为空");
        if (roleIds==null||roleIds.length==0)
            throw new ServiceException("必须为用户分配角色");
        //2.对密码进行加密
        //2.1获取一个盐值（salt）：借助UUID
        String salt = UUID.randomUUID().toString();
        System.out.println("salt="+salt);
        //2.2对密码进行加密（借助shiro框架API）：MD5加密（消息摘要加密）
        SimpleHash simpleHash = new SimpleHash("MD5",entity.getUserpwd(),salt);
        String hashPwd = simpleHash.toHex();//将加密结果转化为16进制
        //3.对盐值，新的密码进行封装
        entity.setSalt(salt);
        entity.setUserpwd(hashPwd);
        entity.setValid(1);
        //从session中获取用户姓名 获取用户真实姓名
        String username = (String) session.getAttribute("username");
        User loginUser = userMapper.findUserByUserName(username);
        String userrealname = loginUser.getUserrealname();
        System.out.println(userrealname);
        entity.setCreateuser(userrealname);
        //4.保存用户自身信息
        int rows = userMapper.insertSelective(entity);
        //5.保存用户和角色的关系数据
        User user = userMapper.findUserByUserName(entity.getUsername());
        Integer userid = user.getUserid();
        userRoleMapper.insertObject(userid,roleIds);
        //6.返回操作结果
        return rows;
    }

    @Override
    public int updateObject(User entity, Integer[] roleIds) {
        //1.验证参数合法性
        if (entity==null)
            throw new IllegalArgumentException("修改对象不能为空");
        if (StringUtils.isEmpty(entity.getUsername()))
            throw new IllegalArgumentException("用户名不能为空");
       /* if (roleIds==null||roleIds.length==0)
            throw new ServiceException("必须为用户分配角色");*/
        //2.保存用户自身信息
        int rows = userMapper.updateByPrimaryKey(entity);
        if (rows==0)
            throw new ServiceException("修改记录可能已经不存在");
        //3.保存用户和角色的关系数据
        userRoleMapper.deleteObjectsByUserId(entity.getUserid());
        userRoleMapper.insertObject(entity.getUserid(),roleIds);
        //4.返回操作结果
        return rows;
    }

    @Override
    @RequiresPermissions("delete")
    public int deleteObjects(Integer... userids) {

        if (userids==null||userids.length==0)
            throw new IllegalArgumentException("请选择删除记录");
        int rows=userMapper.deleteObjects(userids);
        if (rows==0)
            throw new ServiceException("此记录不存在");
        return rows;

    }

    @Override
    public int updateObjects(User entity , Integer[] roleIds,HttpSession session) {
        if (entity==null)
            throw new IllegalArgumentException("修改对象不能为空");
        if (StringUtils.isEmpty(entity.getUsername()))
            throw new IllegalArgumentException("用户名不能为空");
        String username = (String) session.getAttribute("username");
        User loginUser = userMapper.findUserByUserName(username);
        String userrealname = loginUser.getUserrealname();
        entity.setUpdateuser(userrealname);
        entity.setUpdatedate(new Date());
        int rows = userMapper.updateByPrimaryKeySelective(entity);
        if (rows==0)
            throw new ServiceException("修改记录可能已经不存在   ");
        //3.保存用户和角色的关系数据
        //从session中获取用户姓名 获取用户真实姓名
        userRoleMapper.deleteObjectsByUserId(entity.getUserid());
        userRoleMapper.insertObject(entity.getUserid(),roleIds);

        //4.返回操作结果
        return rows;
    }

    @Override
    public Map<String,Object> doFindRoleByUserId(Integer userid) {
        User user = userMapper.selectByPrimaryKey(userid);
        List<Integer> roleIds = userRoleMapper.findRoleIdsByUserId(userid);
        List<String> roleName = new ArrayList<>();
        String rName = null;
        for (int id : roleIds) {
           rName = userMapper.findRoleNameByUserId(id);
           roleName.add(rName);
        }
        System.out.println(roleName);
        Integer deptid=user.getDeptid();
        String deptName=userMapper.findDeptNameByUserId(deptid);
        Integer leaderid = user.getLeaderid();
        String leaderName=userMapper.findLeaderNameByLeaderId(leaderid);
        /* List<String> roleName=userMapper.findRoleNameByUserId();*/
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("roleIds", roleIds);
        map.put("roleName", roleName);
        map.put("deptName", deptName);
        map.put("leaderName", leaderName);
        return map;
    }

    @Override
    public List<Node> findZTreeNodes() {
        return userMapper.findZTreeNodes();
    }

    @Override
    public Map<String,Object> doSession(HttpSession session) {
        String username = (String) session.getAttribute("username");
        User user = userMapper.findUserByUserName(username);
        String deptName = userMapper.findDeptNameByUserId(user.getDeptid());
        List<Integer> roleIds = userRoleMapper.findRoleIdsByUserId(user.getUserid());
        List<String> roleName = new ArrayList<>();
        String rName = null;
        for (int id : roleIds) {
            rName = userMapper.findRoleNameByUserId(id);
            roleName.add(rName);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("user",user);
        map.put("deptName",deptName);
        map.put("roleName",roleName);
        return map;
    }


}
