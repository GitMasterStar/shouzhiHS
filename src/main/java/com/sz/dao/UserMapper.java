package com.sz.dao;

import com.sz.common.vo.Node;
import com.sz.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findUserByUserName(String username);

    /**
     * 查询用户总数
     *
     * @param username
     * @return
     */
    int getRowCount(@Param("userrealname") String userrealname);

    /**
     * 分页查询用户信息
     *
     * @param userrealname
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<Map<String, Object>> findPageObjects(
            @Param("userrealname") String userrealname,
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize);

    /**
     * 修改用户状态（0：禁用 1：启用）
     *
     * @param userid
     * @param valid
     * @param updateuser
     * @return
     */
    int validById(
            @Param("userid") Integer userid,
            @Param("valid") Integer valid,
            @Param("updateuser") String updateuser);

    /**
     * 删除（可多选）
     *
     * @param userids
     * @return
     */
    int deleteObjects(@Param("userids") Integer... userids);

    String findRoleNameByUserId(@Param("id") Integer id);

    String findDeptNameByUserId(Integer deptid);

    List<Node> findZTreeNodes();

    String findLeaderNameByLeaderId(Integer leaderid);
}