package com.sz.common.vo;

import java.io.Serializable;

/**
 * Node :Value Object
 * 借助此对象封装zTree对应的树节点信息
 */
public class RNode implements Serializable {

    private static final long serialVersionUID = -573245884764582541L;
    /**角色id*/
    private Integer id;
    /**上级角色id*/
    private Integer upRoleId;
    /**角色名称*/
    private String name;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUpRoleId() {
        return upRoleId;
    }
    public void setUpRoleId(Integer upRoleId) {
        this.upRoleId = upRoleId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}

