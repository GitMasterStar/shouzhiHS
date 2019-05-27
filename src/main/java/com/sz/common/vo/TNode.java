package com.sz.common.vo;

import java.io.Serializable;

/**
 * Node :Value Object
 * 借助此对象封装zTree对应的树节点信息
 */
public class TNode implements Serializable {
    private static final long serialVersionUID = 9083307336269807105L;

    /**菜单id*/
    private Integer id;
    /**上级菜单id*/
    private Integer pid;
    /**菜单名称*/
    private String name;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPid() {
        return pid;
    }
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}

