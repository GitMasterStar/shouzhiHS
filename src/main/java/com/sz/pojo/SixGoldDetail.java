package com.sz.pojo;

import java.util.Date;

public class SixGoldDetail {
    private Integer id;

    private String workername;

    private String workeridcard;

    private Integer paymonth;

    private Double endowmententerprise;

    private Double endowmentpersonage;

    private Double medicalenterprise;

    private Double medicalpersonage;

    private Double unemploymententerprise;

    private Double unemploymentpersonage;

    private Double inductrialinjuryenterprise;

    private Double maternityenterprise;

    private Double housingfundenterprise;

    private Double housingfundpersonage;

    private Double collectenterprise;

    private Double collectpersonage;

    private Double collect;

    private Date month;

    public SixGoldDetail(Integer id, String workername, String workeridcard, Integer paymonth, Double endowmententerprise, Double endowmentpersonage, Double medicalenterprise, Double medicalpersonage, Double unemploymententerprise, Double unemploymentpersonage, Double inductrialinjuryenterprise, Double maternityenterprise, Double housingfundenterprise, Double housingfundpersonage, Double collectenterprise, Double collectpersonage, Double collect, Date month) {
        this.id = id;
        this.workername = workername;
        this.workeridcard = workeridcard;
        this.paymonth = paymonth;
        this.endowmententerprise = endowmententerprise;
        this.endowmentpersonage = endowmentpersonage;
        this.medicalenterprise = medicalenterprise;
        this.medicalpersonage = medicalpersonage;
        this.unemploymententerprise = unemploymententerprise;
        this.unemploymentpersonage = unemploymentpersonage;
        this.inductrialinjuryenterprise = inductrialinjuryenterprise;
        this.maternityenterprise = maternityenterprise;
        this.housingfundenterprise = housingfundenterprise;
        this.housingfundpersonage = housingfundpersonage;
        this.collectenterprise = collectenterprise;
        this.collectpersonage = collectpersonage;
        this.collect = collect;
        this.month = month;
    }

    public SixGoldDetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkername() {
        return workername;
    }

    public void setWorkername(String workername) {
        this.workername = workername;
    }

    public String getWorkeridcard() {
        return workeridcard;
    }

    public void setWorkeridcard(String workeridcard) {
        this.workeridcard = workeridcard == null ? null : workeridcard.trim();
    }

    public Integer getPaymonth() {
        return paymonth;
    }

    public void setPaymonth(Integer paymonth) {
        this.paymonth = paymonth;
    }

    public Double getEndowmententerprise() {
        return endowmententerprise;
    }

    public void setEndowmententerprise(Double endowmententerprise) {
        this.endowmententerprise = endowmententerprise;
    }

    public Double getEndowmentpersonage() {
        return endowmentpersonage;
    }

    public void setEndowmentpersonage(Double endowmentpersonage) {
        this.endowmentpersonage = endowmentpersonage;
    }

    public Double getMedicalenterprise() {
        return medicalenterprise;
    }

    public void setMedicalenterprise(Double medicalenterprise) {
        this.medicalenterprise = medicalenterprise;
    }

    public Double getMedicalpersonage() {
        return medicalpersonage;
    }

    public void setMedicalpersonage(Double medicalpersonage) {
        this.medicalpersonage = medicalpersonage;
    }

    public Double getUnemploymententerprise() {
        return unemploymententerprise;
    }

    public void setUnemploymententerprise(Double unemploymententerprise) {
        this.unemploymententerprise = unemploymententerprise;
    }

    public Double getUnemploymentpersonage() {
        return unemploymentpersonage;
    }

    public void setUnemploymentpersonage(Double unemploymentpersonage) {
        this.unemploymentpersonage = unemploymentpersonage;
    }

    public Double getInductrialinjuryenterprise() {
        return inductrialinjuryenterprise;
    }

    public void setInductrialinjuryenterprise(Double inductrialinjuryenterprise) {
        this.inductrialinjuryenterprise = inductrialinjuryenterprise;
    }

    public Double getMaternityenterprise() {
        return maternityenterprise;
    }

    public void setMaternityenterprise(Double maternityenterprise) {
        this.maternityenterprise = maternityenterprise;
    }

    public Double getHousingfundenterprise() {
        return housingfundenterprise;
    }

    public void setHousingfundenterprise(Double housingfundenterprise) {
        this.housingfundenterprise = housingfundenterprise;
    }

    public Double getHousingfundpersonage() {
        return housingfundpersonage;
    }

    public void setHousingfundpersonage(Double housingfundpersonage) {
        this.housingfundpersonage = housingfundpersonage;
    }

    public Double getCollectenterprise() {
        return collectenterprise;
    }

    public void setCollectenterprise(Double collectenterprise) {
        this.collectenterprise = collectenterprise;
    }

    public Double getCollectpersonage() {
        return collectpersonage;
    }

    public void setCollectpersonage(Double collectpersonage) {
        this.collectpersonage = collectpersonage;
    }

    public Double getCollect() {
        return collect;
    }

    public void setCollect(Double collect) {
        this.collect = collect;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }
}