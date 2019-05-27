package com.sz.service;

import com.sz.common.vo.Node;
import com.sz.common.vo.PageObject;
import com.sz.pojo.Role;
import com.sz.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.session.HttpServletSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 用户分页查询
     * @param userrealname
     * @param pageCurrent
     * @return
     */
    PageObject<Map<String, Object>> findPageObjects(String userrealname, Integer pageCurrent);

    /**
     * 基于用户名查询用户信息
     * @param username
     * @return
     */
    User findUserByUserName(String username);

    /**
     * 基于用户id查询用户信息
     * @param userid
     * @return
     */
    User findUserById(Integer userid);

    /**
     * 修改用户状态（0：禁用 1：启用）
     * @param userId 用户id
     * @param valid 状态
     * @param updateuser 修改用户
     * @return
     */
    int validById(Integer userid, Integer valid,HttpSession session);

    /**
     *保存用户信息
     * @param entity 保存对象
     * @param roleIds 角色Id集合
     * @return
     */
    int addObject(User entity,@Param("roleIds") Integer[] roleIds,HttpSession session);

    /**
     * 修改用户信息
     * @param entity 修改对象
     * @param roleIds 角色id集合
     * @return
     */
    int updateObject(User entity, Integer[] roleIds);

    int deleteObjects(@Param("userids")Integer... userids);

    int updateObjects(User entity, Integer[] roleIds,HttpSession session);

    Map<String,Object> doFindRoleByUserId(Integer userid);

    List<Node> findZTreeNodes();

    Map<String,Object> doSession(HttpSession session);

}
