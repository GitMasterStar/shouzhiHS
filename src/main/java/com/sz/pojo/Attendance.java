package com.sz.pojo;

public class Attendance {
    private Integer id;

    private Integer workerid;

    private Integer deptid;

    private Integer workday;

    private Integer checkoutday;

    private Double checkoutprice;

    private Double other;

    private Double adjustment;

    private Integer validday;

    private Integer invalidday;

    private Double normalsalary;

    private Double paysalary1;

    private Double paysalary2;

    private String salaryratio;

    private Double payrealsalary1;

    private Double payrealsalary2;

    private Double computersubsidy;

    private Double overtimesubsidy;

    private Double othersubsidy;

    private Double allsubsidy;

    private Double sendsalary1;

    private Double sendsalary2;

    private Double allsendsalary;

    private Boolean checkout;

    private String reason;

    private String paycity2;

    private Double bonus;

    private Double allsend;

    private Integer updateid;

    private String month;

    private String standby;

    public Attendance(Integer id, Integer workerid, Integer deptid, Integer workday, Integer checkoutday, Double checkoutprice, Double other, Double adjustment, Integer validday, Integer invalidday, Double normalsalary, Double paysalary1, Double paysalary2, String salaryratio, Double payrealsalary1, Double payrealsalary2, Double computersubsidy, Double overtimesubsidy, Double othersubsidy, Double allsubsidy, Double sendsalary1, Double sendsalary2, Double allsendsalary, Boolean checkout, String reason, String paycity2, Double bonus, Double allsend, Integer updateid, String month, String standby) {
        this.id = id;
        this.workerid = workerid;
        this.deptid = deptid;
        this.workday = workday;
        this.checkoutday = checkoutday;
        this.checkoutprice = checkoutprice;
        this.other = other;
        this.adjustment = adjustment;
        this.validday = validday;
        this.invalidday = invalidday;
        this.normalsalary = normalsalary;
        this.paysalary1 = paysalary1;
        this.paysalary2 = paysalary2;
        this.salaryratio = salaryratio;
        this.payrealsalary1 = payrealsalary1;
        this.payrealsalary2 = payrealsalary2;
        this.computersubsidy = computersubsidy;
        this.overtimesubsidy = overtimesubsidy;
        this.othersubsidy = othersubsidy;
        this.allsubsidy = allsubsidy;
        this.sendsalary1 = sendsalary1;
        this.sendsalary2 = sendsalary2;
        this.allsendsalary = allsendsalary;
        this.checkout = checkout;
        this.reason = reason;
        this.paycity2 = paycity2;
        this.bonus = bonus;
        this.allsend = allsend;
        this.updateid = updateid;
        this.month = month;
        this.standby = standby;
    }

    public Attendance() {
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

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getWorkday() {
        return workday;
    }

    public void setWorkday(Integer workday) {
        this.workday = workday;
    }

    public Integer getCheckoutday() {
        return checkoutday;
    }

    public void setCheckoutday(Integer checkoutday) {
        this.checkoutday = checkoutday;
    }

    public Double getCheckoutprice() {
        return checkoutprice;
    }

    public void setCheckoutprice(Double checkoutprice) {
        this.checkoutprice = checkoutprice;
    }

    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }

    public Double getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(Double adjustment) {
        this.adjustment = adjustment;
    }

    public Integer getValidday() {
        return validday;
    }

    public void setValidday(Integer validday) {
        this.validday = validday;
    }

    public Integer getInvalidday() {
        return invalidday;
    }

    public void setInvalidday(Integer invalidday) {
        this.invalidday = invalidday;
    }

    public Double getNormalsalary() {
        return normalsalary;
    }

    public void setNormalsalary(Double normalsalary) {
        this.normalsalary = normalsalary;
    }

    public Double getPaysalary1() {
        return paysalary1;
    }

    public void setPaysalary1(Double paysalary1) {
        this.paysalary1 = paysalary1;
    }

    public Double getPaysalary2() {
        return paysalary2;
    }

    public void setPaysalary2(Double paysalary2) {
        this.paysalary2 = paysalary2;
    }

    public String getSalaryratio() {
        return salaryratio;
    }

    public void setSalaryratio(String salaryratio) {
        this.salaryratio = salaryratio == null ? null : salaryratio.trim();
    }

    public Double getPayrealsalary1() {
        return payrealsalary1;
    }

    public void setPayrealsalary1(Double payrealsalary1) {
        this.payrealsalary1 = payrealsalary1;
    }

    public Double getPayrealsalary2() {
        return payrealsalary2;
    }

    public void setPayrealsalary2(Double payrealsalary2) {
        this.payrealsalary2 = payrealsalary2;
    }

    public Double getComputersubsidy() {
        return computersubsidy;
    }

    public void setComputersubsidy(Double computersubsidy) {
        this.computersubsidy = computersubsidy;
    }

    public Double getOvertimesubsidy() {
        return overtimesubsidy;
    }

    public void setOvertimesubsidy(Double overtimesubsidy) {
        this.overtimesubsidy = overtimesubsidy;
    }

    public Double getOthersubsidy() {
        return othersubsidy;
    }

    public void setOthersubsidy(Double othersubsidy) {
        this.othersubsidy = othersubsidy;
    }

    public Double getAllsubsidy() {
        return allsubsidy;
    }

    public void setAllsubsidy(Double allsubsidy) {
        this.allsubsidy = allsubsidy;
    }

    public Double getSendsalary1() {
        return sendsalary1;
    }

    public void setSendsalary1(Double sendsalary1) {
        this.sendsalary1 = sendsalary1;
    }

    public Double getSendsalary2() {
        return sendsalary2;
    }

    public void setSendsalary2(Double sendsalary2) {
        this.sendsalary2 = sendsalary2;
    }

    public Double getAllsendsalary() {
        return allsendsalary;
    }

    public void setAllsendsalary(Double allsendsalary) {
        this.allsendsalary = allsendsalary;
    }

    public Boolean getCheckout() {
        return checkout;
    }

    public void setCheckout(Boolean checkout) {
        this.checkout = checkout;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getPaycity2() {
        return paycity2;
    }

    public void setPaycity2(String paycity2) {
        this.paycity2 = paycity2 == null ? null : paycity2.trim();
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getAllsend() {
        return allsend;
    }

    public void setAllsend(Double allsend) {
        this.allsend = allsend;
    }

    public Integer getUpdateid() {
        return updateid;
    }

    public void setUpdateid(Integer updateid) {
        this.updateid = updateid;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public String getStandby() {
        return standby;
    }

    public void setStandby(String standby) {
        this.standby = standby == null ? null : standby.trim();
    }
}