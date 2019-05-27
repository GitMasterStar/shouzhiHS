package com.sz.controller;

import com.sz.common.vo.JsonResult;
import com.sz.common.vo.PageObject;
import com.sz.exception.ServiceException;
import com.sz.pojo.User;
import com.sz.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/doUserList")
    public String doUserList() {
        return "user";
    }

    @RequestMapping("/doLoadUI")
    public String doLoadUI() {
        return "userUI";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public JsonResult doLogin(String username, String userpwd) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, userpwd);
        SecurityUtils.getSubject().getSession().setAttribute("token",token);
        SecurityUtils.getSubject().getSession().setAttribute("username",username);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        return new JsonResult("登录成功");
    }

    /**
     * 分页查询用户信息
     *
     * @param userrealname 用户名称
     * @param pageCurrent  具体页数
     * @return
     */
    @RequestMapping("/doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String userrealname, Integer pageCurrent) {
        PageObject<Map<String, Object>> pageObject = userService.findPageObjects(userrealname, pageCurrent);
        return new JsonResult(pageObject);
    }

    /**
     * 基于用户名查询用户信息
     *
     * @param username 用户名称
     * @return
     */
    @RequestMapping("/doFindUserByUserName")
    @ResponseBody
    public JsonResult doFindUserByUserName(String username) {
        User user = userService.findUserByUserName(username);
        return new JsonResult(user);
    }

    /**
     * 基于用户id查询用户信息
     *
     * @param userid 用户id
     * @return
     */
    @RequestMapping("/doFindUserById")
    @ResponseBody
    public JsonResult doFindUserById(Integer userid) {
        User user = userService.findUserById(userid);
        return new JsonResult(user);
    }

    /**
     * 修改用户的状态信息（0：禁用 1：启用）
     *
     * @param userid     用户id
     * @param valid      状态
     * @return
     */
    @RequestMapping("/doValidById")
    @ResponseBody
    public JsonResult doValidById(Integer userid, Integer valid,HttpSession session) {
        userService.validById(userid, valid,session);
        return new JsonResult(" 用户状态修改成功 ");
    }

    /**
     * 新增用户，保存用户信息
     *
     * @param entity  保存对象
     * @param roleIds 角色id
     * @return
     */
    @RequestMapping("/doAddObject")
    @ResponseBody
    public JsonResult doAddObject(User entity, Integer[] roleIds,HttpSession session) {
        userService.addObject(entity, roleIds,session);
        return new JsonResult("用户新增成功！");
    }

    /**
     * 修改用户，保存修改信息
     *
     * @param entity  修改对象
     * @param roleIds 角色id
     * @return
     */
    @RequestMapping("/doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(User entity, Integer[] roleIds) {
        userService.updateObject(entity, roleIds);
        return new JsonResult("用户修改成功！");
    }

    @RequestMapping("/doUpdateObjects")
    @ResponseBody
    public JsonResult doUpdateObjects(User entity, Integer[] roleIds,HttpSession session) {
        userService.updateObjects(entity, roleIds,session);
        return new JsonResult("用户修改成功！");
    }

    @RequestMapping("/doDeleteObjects")
    @ResponseBody
    public JsonResult doDeleteObjects(Integer... userids) {
        userService.deleteObjects(userids);
        return new JsonResult("删除成功！");
    }

    @RequestMapping("/doFindAllByUserId")
    @ResponseBody
    public JsonResult doFindAllByUserId(Integer userid) {
        Map<String, Object> map = userService.doFindRoleByUserId(userid);
        return new JsonResult(map);
    }

    @RequestMapping("/doFindZTreeNodes")
    @ResponseBody
    public JsonResult doFindZTreeNodes() {
        return new JsonResult(userService.findZTreeNodes());
    }

    @RequestMapping("/doSession")
    @ResponseBody
    public JsonResult doSession(HttpSession session){
        Map<String,Object> user=userService.doSession(session);
        return new JsonResult(user);
    }

    @RequestMapping("/closeSession")
    @ResponseBody
    public JsonResult closeSession(HttpServletRequest request,HttpSession session){

        Enumeration<String> em = request.getSession().getAttributeNames();

        while(em.hasMoreElements()){
            String name =em.nextElement();
            /*Object value = request.getSession().getAttribute(name);*/
            request.getSession().removeAttribute(name);
        }
        return new JsonResult("清除成功");
    }

    @RequestMapping("/checkToken")
    @ResponseBody
    public JsonResult checkToken(HttpServletRequest request){
        String username = (String) request.getSession().getAttribute("username");

        System.out.println(username);
        if(username!=null||request.getSession().getAttribute("token")!=null){
               return new JsonResult("信息存在");
            }else{
            throw new ServiceException("用户未登录");
        }
    }

}
