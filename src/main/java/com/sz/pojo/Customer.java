package com.sz.pojo;

public class Customer {
    private Integer id;

    private String cname;

    private String cfullname;

    private Integer ctype;

    private String caddress;

    private String cphone;

    private String legalpersonid;

    private Double csignday;

    private Double csignaging;

    private Integer cstatus;

    public Customer(Integer id, String cname, String cfullname, Integer ctype, String caddress, String cphone, String legalpersonid, Double csignday, Double csignaging, Integer cstatus) {
        this.id = id;
        this.cname = cname;
        this.cfullname = cfullname;
        this.ctype = ctype;
        this.caddress = caddress;
        this.cphone = cphone;
        this.legalpersonid = legalpersonid;
        this.csignday = csignday;
        this.csignaging = csignaging;
        this.cstatus = cstatus;
    }

    public Customer() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCfullname() {
        return cfullname;
    }

    public void setCfullname(String cfullname) {
        this.cfullname = cfullname == null ? null : cfullname.trim();
    }

    public Integer getCtype() {
        return ctype;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress == null ? null : caddress.trim();
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone == null ? null : cphone.trim();
    }

    public String getLegalpersonid() {
        return legalpersonid;
    }

    public void setLegalpersonid(String legalpersonid) {
        this.legalpersonid = legalpersonid == null ? null : legalpersonid.trim();
    }

    public Double getCsignday() {
        return csignday;
    }

    public void setCsignday(Double csignday) {
        this.csignday = csignday;
    }

    public Double getCsignaging() {
        return csignaging;
    }

    public void setCsignaging(Double csignaging) {
        this.csignaging = csignaging;
    }

    public Integer getCstatus() {
        return cstatus;
    }

    public void setCstatus(Integer cstatus) {
        this.cstatus = cstatus;
    }
}