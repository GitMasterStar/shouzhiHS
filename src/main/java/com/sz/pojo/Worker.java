package com.sz.pojo;

import java.util.Date;

public class Worker {
    private String id;

    private String workername;

    private String workersex;

    private String workeridcard;

    private String worknative;

    private String workerphone;

    private String workeremail;

    private String workerdept;

    private String workerlevel;

    private String workerleader;

    private String workercustomer;

    private String createpeople;

    private Date createdate;

    private Double price;

    private String pricetype;

    private Double normalsalary;

    private Double basesalary;

    private Double performancesalary;

    private String salaryratio;

    private String grossprofitrate;

    private String sixgoldcity;

    private Double sixgoldbase;

    private String paycity1;

    private Double paysalary1;

    private String paycity2;

    private Double paysalary2;

    private Double childeducation;

    private Double againeducation;

    private Double seriousillness;

    private Double houseloans;

    private Double rentinghouse;

    private Double supportold;

    private String equipment;

    private Double equipmentsubsidy;

    private Integer workerstatus;

    private Date dimissiondate;

    private String dimissionreason;

    private String declarationstatus;

    private String socialsecuritystatus;

    private Date updatedate;

    private String updatepeople;

    private String remark;

    private String standby;

    private String cmbcaccount;

    private String icbcaccount;

    public Worker(String id, String workername, String workersex, String workeridcard, String worknative, String workerphone, String workeremail, String workerdept, String workerlevel, String workerleader, String workercustomer, String createpeople, Date createdate, Double price, String pricetype, Double normalsalary, Double basesalary, Double performancesalary, String salaryratio, String grossprofitrate, String sixgoldcity, Double sixgoldbase, String paycity1, Double paysalary1, String paycity2, Double paysalary2, Double childeducation, Double againeducation, Double seriousillness, Double houseloans, Double rentinghouse, Double supportold, String equipment, Double equipmentsubsidy, Integer workerstatus, Date dimissiondate, String dimissionreason, String declarationstatus, String socialsecuritystatus, Date updatedate, String updatepeople, String remark, String standby, String cmbcaccount, String icbcaccount) {
        this.id = id;
        this.workername = workername;
        this.workersex = workersex;
        this.workeridcard = workeridcard;
        this.worknative = worknative;
        this.workerphone = workerphone;
        this.workeremail = workeremail;
        this.workerdept = workerdept;
        this.workerlevel = workerlevel;
        this.workerleader = workerleader;
        this.workercustomer = workercustomer;
        this.createpeople = createpeople;
        this.createdate = createdate;
        this.price = price;
        this.pricetype = pricetype;
        this.normalsalary = normalsalary;
        this.basesalary = basesalary;
        this.performancesalary = performancesalary;
        this.salaryratio = salaryratio;
        this.grossprofitrate = grossprofitrate;
        this.sixgoldcity = sixgoldcity;
        this.sixgoldbase = sixgoldbase;
        this.paycity1 = paycity1;
        this.paysalary1 = paysalary1;
        this.paycity2 = paycity2;
        this.paysalary2 = paysalary2;
        this.childeducation = childeducation;
        this.againeducation = againeducation;
        this.seriousillness = seriousillness;
        this.houseloans = houseloans;
        this.rentinghouse = rentinghouse;
        this.supportold = supportold;
        this.equipment = equipment;
        this.equipmentsubsidy = equipmentsubsidy;
        this.workerstatus = workerstatus;
        this.dimissiondate = dimissiondate;
        this.dimissionreason = dimissionreason;
        this.declarationstatus = declarationstatus;
        this.socialsecuritystatus = socialsecuritystatus;
        this.updatedate = updatedate;
        this.updatepeople = updatepeople;
        this.remark = remark;
        this.standby = standby;
        this.cmbcaccount = cmbcaccount;
        this.icbcaccount = icbcaccount;
    }

    public Worker() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getWorkername() {
        return workername;
    }

    public void setWorkername(String workername) {
        this.workername = workername == null ? null : workername.trim();
    }

    public String getWorkersex() {
        return workersex;
    }

    public void setWorkersex(String workersex) {
        this.workersex = workersex == null ? null : workersex.trim();
    }

    public String getWorkeridcard() {
        return workeridcard;
    }

    public void setWorkeridcard(String workeridcard) {
        this.workeridcard = workeridcard == null ? null : workeridcard.trim();
    }

    public String getWorknative() {
        return worknative;
    }

    public void setWorknative(String worknative) {
        this.worknative = worknative == null ? null : worknative.trim();
    }

    public String getWorkerphone() {
        return workerphone;
    }

    public void setWorkerphone(String workerphone) {
        this.workerphone = workerphone == null ? null : workerphone.trim();
    }

    public String getWorkeremail() {
        return workeremail;
    }

    public void setWorkeremail(String workeremail) {
        this.workeremail = workeremail == null ? null : workeremail.trim();
    }

    public String getWorkerdept() {
        return workerdept;
    }

    public void setWorkerdept(String workerdept) {
        this.workerdept = workerdept == null ? null : workerdept.trim();
    }

    public String getWorkerlevel() {
        return workerlevel;
    }

    public void setWorkerlevel(String workerlevel) {
        this.workerlevel = workerlevel == null ? null : workerlevel.trim();
    }

    public String getWorkerleader() {
        return workerleader;
    }

    public void setWorkerleader(String workerleader) {
        this.workerleader = workerleader == null ? null : workerleader.trim();
    }

    public String getWorkercustomer() {
        return workercustomer;
    }

    public void setWorkercustomer(String workercustomer) {
        this.workercustomer = workercustomer == null ? null : workercustomer.trim();
    }

    public String getCreatepeople() {
        return createpeople;
    }

    public void setCreatepeople(String createpeople) {
        this.createpeople = createpeople == null ? null : createpeople.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPricetype() {
        return pricetype;
    }

    public void setPricetype(String pricetype) {
        this.pricetype = pricetype == null ? null : pricetype.trim();
    }

    public Double getNormalsalary() {
        return normalsalary;
    }

    public void setNormalsalary(Double normalsalary) {
        this.normalsalary = normalsalary;
    }

    public Double getBasesalary() {
        return basesalary;
    }

    public void setBasesalary(Double basesalary) {
        this.basesalary = basesalary;
    }

    public Double getPerformancesalary() {
        return performancesalary;
    }

    public void setPerformancesalary(Double performancesalary) {
        this.performancesalary = performancesalary;
    }

    public String getSalaryratio() {
        return salaryratio;
    }

    public void setSalaryratio(String salaryratio) {
        this.salaryratio = salaryratio == null ? null : salaryratio.trim();
    }

    public String getGrossprofitrate() {
        return grossprofitrate;
    }

    public void setGrossprofitrate(String grossprofitrate) {
        this.grossprofitrate = grossprofitrate == null ? null : grossprofitrate.trim();
    }

    public String getSixgoldcity() {
        return sixgoldcity;
    }

    public void setSixgoldcity(String sixgoldcity) {
        this.sixgoldcity = sixgoldcity == null ? null : sixgoldcity.trim();
    }

    public Double getSixgoldbase() {
        return sixgoldbase;
    }

    public void setSixgoldbase(Double sixgoldbase) {
        this.sixgoldbase = sixgoldbase;
    }

    public String getPaycity1() {
        return paycity1;
    }

    public void setPaycity1(String paycity1) {
        this.paycity1 = paycity1 == null ? null : paycity1.trim();
    }

    public Double getPaysalary1() {
        return paysalary1;
    }

    public void setPaysalary1(Double paysalary1) {
        this.paysalary1 = paysalary1;
    }

    public String getPaycity2() {
        return paycity2;
    }

    public void setPaycity2(String paycity2) {
        this.paycity2 = paycity2 == null ? null : paycity2.trim();
    }

    public Double getPaysalary2() {
        return paysalary2;
    }

    public void setPaysalary2(Double paysalary2) {
        this.paysalary2 = paysalary2;
    }

    public Double getChildeducation() {
        return childeducation;
    }

    public void setChildeducation(Double childeducation) {
        this.childeducation = childeducation;
    }

    public Double getAgaineducation() {
        return againeducation;
    }

    public void setAgaineducation(Double againeducation) {
        this.againeducation = againeducation;
    }

    public Double getSeriousillness() {
        return seriousillness;
    }

    public void setSeriousillness(Double seriousillness) {
        this.seriousillness = seriousillness;
    }

    public Double getHouseloans() {
        return houseloans;
    }

    public void setHouseloans(Double houseloans) {
        this.houseloans = houseloans;
    }

    public Double getRentinghouse() {
        return rentinghouse;
    }

    public void setRentinghouse(Double rentinghouse) {
        this.rentinghouse = rentinghouse;
    }

    public Double getSupportold() {
        return supportold;
    }

    public void setSupportold(Double supportold) {
        this.supportold = supportold;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment == null ? null : equipment.trim();
    }

    public Double getEquipmentsubsidy() {
        return equipmentsubsidy;
    }

    public void setEquipmentsubsidy(Double equipmentsubsidy) {
        this.equipmentsubsidy = equipmentsubsidy;
    }

    public Integer getWorkerstatus() {
        return workerstatus;
    }

    public void setWorkerstatus(Integer workerstatus) {
        this.workerstatus = workerstatus;
    }

    public Date getDimissiondate() {
        return dimissiondate;
    }

    public void setDimissiondate(Date dimissiondate) {
        this.dimissiondate = dimissiondate;
    }

    public String getDimissionreason() {
        return dimissionreason;
    }

    public void setDimissionreason(String dimissionreason) {
        this.dimissionreason = dimissionreason == null ? null : dimissionreason.trim();
    }

    public String getDeclarationstatus() {
        return declarationstatus;
    }

    public void setDeclarationstatus(String declarationstatus) {
        this.declarationstatus = declarationstatus == null ? null : declarationstatus.trim();
    }

    public String getSocialsecuritystatus() {
        return socialsecuritystatus;
    }

    public void setSocialsecuritystatus(String socialsecuritystatus) {
        this.socialsecuritystatus = socialsecuritystatus == null ? null : socialsecuritystatus.trim();
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getUpdatepeople() {
        return updatepeople;
    }

    public void setUpdatepeople(String updatepeople) {
        this.updatepeople = updatepeople == null ? null : updatepeople.trim();
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

    public String getCmbcaccount() {
        return cmbcaccount;
    }

    public void setCmbcaccount(String cmbcaccount) {
        this.cmbcaccount = cmbcaccount == null ? null : cmbcaccount.trim();
    }

    public String getIcbcaccount() {
        return icbcaccount;
    }

    public void setIcbcaccount(String icbcaccount) {
        this.icbcaccount = icbcaccount == null ? null : icbcaccount.trim();
    }
}