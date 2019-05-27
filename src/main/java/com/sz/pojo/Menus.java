package com.sz.pojo;

import java.util.Date;

public class Menus {
    private Integer id;

    private String icon;

    private String name;

    private Integer type;

    private Integer sort;

    private String note;

    private Integer parentid;

    private String permission;

    private Date createdtime;

    private Date modifiedtime;

    private String createduser;

    private byte[] modifieduser;

    public Menus(Integer id, String icon, String name, Integer type, Integer sort, String note, Integer parentid, String permission, Date createdtime, Date modifiedtime, String createduser, byte[] modifieduser) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.type = type;
        this.sort = sort;
        this.note = note;
        this.parentid = parentid;
        this.permission = permission;
        this.createdtime = createdtime;
        this.modifiedtime = modifiedtime;
        this.createduser = createduser;
        this.modifieduser = modifieduser;
    }

    public Menus() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public String getCreateduser() {
        return createduser;
    }

    public void setCreateduser(String createduser) {
        this.createduser = createduser == null ? null : createduser.trim();
    }

    public byte[] getModifieduser() {
        return modifieduser;
    }

    public void setModifieduser(byte[] modifieduser) {
        this.modifieduser = modifieduser;
    }
}