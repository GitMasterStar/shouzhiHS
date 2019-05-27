package com.sz.pojo;

import java.util.Date;

public class Income {
    private Integer id;

    private Integer workerid;

    private Integer attendanceid;

    private Double income;

    private Double initialincome;

    private Double invoicevalue;

    private Double difference;

    private String differencemonth;

    private Date returnmoneydate;

    private String returnstatus;

    public Income(Integer id, Integer workerid, Integer attendanceid, Double income, Double initialincome, Double invoicevalue, Double difference, String differencemonth, Date returnmoneydate, String returnstatus) {
        this.id = id;
        this.workerid = workerid;
        this.attendanceid = attendanceid;
        this.income = income;
        this.initialincome = initialincome;
        this.invoicevalue = invoicevalue;
        this.difference = difference;
        this.differencemonth = differencemonth;
        this.returnmoneydate = returnmoneydate;
        this.returnstatus = returnstatus;
    }

    public Income() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkerid() {
        return workerid;
    }

    public void setWorkerid(Integer workerid) {
        this.workerid = workerid;
    }

    public Integer getAttendanceid() {
        return attendanceid;
    }

    public void setAttendanceid(Integer attendanceid) {
        this.attendanceid = attendanceid;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getInitialincome() {
        return initialincome;
    }

    public void setInitialincome(Double initialincome) {
        this.initialincome = initialincome;
    }

    public Double getInvoicevalue() {
        return invoicevalue;
    }

    public void setInvoicevalue(Double invoicevalue) {
        this.invoicevalue = invoicevalue;
    }

    public Double getDifference() {
        return difference;
    }

    public void setDifference(Double difference) {
        this.difference = difference;
    }

    public String getDifferencemonth() {
        return differencemonth;
    }

    public void setDifferencemonth(String differencemonth) {
        this.differencemonth = differencemonth == null ? null : differencemonth.trim();
    }

    public Date getReturnmoneydate() {
        return returnmoneydate;
    }

    public void setReturnmoneydate(Date returnmoneydate) {
        this.returnmoneydate = returnmoneydate;
    }

    public String getReturnstatus() {
        return returnstatus;
    }

    public void setReturnstatus(String returnstatus) {
        this.returnstatus = returnstatus == null ? null : returnstatus.trim();
    }
}