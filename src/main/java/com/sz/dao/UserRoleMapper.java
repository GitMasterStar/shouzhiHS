package com.sz.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRoleMapper {
    /**
     * 基于用户id获取用户对应的角色id
     * @param userid
     * @return
     */
    List<Integer> findRoleIdsByUserId(Integer userid);


    /**
     * 向用户和角色的关系表中写入用户和角色的关系数据
     * @param userId 用户id
     * @param roleIds 角色id
     * @return
     */
    int insertObject(
            @Param("USERID") Integer userId,
            @Param("ROLEID")Integer[] roleIds);

    /**
     * 基于用户id删除用户和角色的关系数据
     * @param userId
     * @return
     */
    int deleteObjectsByUserId(Integer userId);


    /**
     * 删除用户和角色关系数据
     * @param roleId 角色id
     * @return 删除的行数
     */
    int deleteObjectsByRoleId(Integer roleId);

}
