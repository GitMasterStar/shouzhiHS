package com.sz.pojo;

public class Dept {
    private Integer id;

    private String dname;

    private Integer parentid;

    private String principal;

    private String remark;

    private String standby;

    public Dept(Integer id, String dname, Integer parentid, String principal, String remark, String standby) {
        this.id = id;
        this.dname = dname;
        this.parentid = parentid;
        this.principal = principal;
        this.remark = remark;
        this.standby = standby;
    }

    public Dept() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStandby() {
        return standby;
    }

    public void setStandby(String standby) {
        this.standby = standby == null ? null : standby.trim();
    }
}