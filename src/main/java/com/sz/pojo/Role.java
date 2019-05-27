package com.sz.pojo;

public class Role {
    private Integer id;

    private String name;

    private Integer uproleid;

    private String manager;

    private String remark;

    public Role(Integer id, String name, Integer uproleid, String manager, String remark) {
        this.id = id;
        this.name = name;
        this.uproleid = uproleid;
        this.manager = manager;
        this.remark = remark;
    }

    public Role() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getUproleid() {
        return uproleid;
    }

    public void setUproleid(Integer uproleid) {
        this.uproleid = uproleid;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}