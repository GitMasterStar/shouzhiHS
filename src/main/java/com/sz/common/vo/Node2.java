package com.sz.common.vo;

import java.io.Serializable;

/**
 * Node :Value Object
 * 借助此对象封装zTree对应的树节点信息
 */
public class Node2 implements Serializable {
    private static final long serialVersionUID = 4351174414771192644L;
    /**菜单id*/
    private Integer id;
    /**上级菜单id*/
    private Integer parentid;
    /**菜单名称*/
    private String dname;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getParentid() {
        return parentid;
    }
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
    public String getDname() {
        return dname;
    }
    public void setDname(String dname) {
        this.dname = dname;
    }


}

