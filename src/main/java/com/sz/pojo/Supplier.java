package com.sz.pojo;

import java.util.Date;

public class Supplier {
    private Integer id;

    private String sname;

    private String sfullname;

    private String dbank;

    private String baccount;

    private String legalpersonid;

    private Integer sstatus;

    private Date createdtime;

    private String createduser;

    private Date modifiedtime;

    private String modifieduser;

    private Integer type;

    public Supplier(Integer id, String sname, String sfullname, String dbank, String baccount, String legalpersonid, Integer sstatus, Date createdtime, String createduser, Date modifiedtime, String modifieduser, Integer type) {
        this.id = id;
        this.sname = sname;
        this.sfullname = sfullname;
        this.dbank = dbank;
        this.baccount = baccount;
        this.legalpersonid = legalpersonid;
        this.sstatus = sstatus;
        this.createdtime = createdtime;
        this.createduser = createduser;
        this.modifiedtime = modifiedtime;
        this.modifieduser = modifieduser;
        this.type = type;
    }

    public Supplier() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSfullname() {
        return sfullname;
    }

    public void setSfullname(String sfullname) {
        this.sfullname = sfullname == null ? null : sfullname.trim();
    }

    public String getDbank() {
        return dbank;
    }

    public void setDbank(String dbank) {
        this.dbank = dbank == null ? null : dbank.trim();
    }

    public String getBaccount() {
        return baccount;
    }

    public void setBaccount(String baccount) {
        this.baccount = baccount == null ? null : baccount.trim();
    }

    public String getLegalpersonid() {
        return legalpersonid;
    }

    public void setLegalpersonid(String legalpersonid) {
        this.legalpersonid = legalpersonid == null ? null : legalpersonid.trim();
    }

    public Integer getSstatus() {
        return sstatus;
    }

    public void setSstatus(Integer sstatus) {
        this.sstatus = sstatus;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public String getCreateduser() {
        return createduser;
    }

    public void setCreateduser(String createduser) {
        this.createduser = createduser == null ? null : createduser.trim();
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public String getModifieduser() {
        return modifieduser;
    }

    public void setModifieduser(String modifieduser) {
        this.modifieduser = modifieduser == null ? null : modifieduser.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}