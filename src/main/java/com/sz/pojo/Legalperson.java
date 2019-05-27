package com.sz.pojo;

public class Legalperson {
    private Integer id;

    private String legalname;

    private String legalfullname;

    private Integer legaltype;

    public Legalperson(Integer id, String legalname, String legalfullname, Integer legaltype) {
        this.id = id;
        this.legalname = legalname;
        this.legalfullname = legalfullname;
        this.legaltype = legaltype;
    }

    public Legalperson() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLegalname() {
        return legalname;
    }

    public void setLegalname(String legalname) {
        this.legalname = legalname == null ? null : legalname.trim();
    }

    public String getLegalfullname() {
        return legalfullname;
    }

    public void setLegalfullname(String legalfullname) {
        this.legalfullname = legalfullname == null ? null : legalfullname.trim();
    }

    public Integer getLegaltype() {
        return legaltype;
    }

    public void setLegaltype(Integer legaltype) {
        this.legaltype = legaltype;
    }
}