package com.sz.pojo;

public class SixGoldDetail {
    private Integer id;

    private Integer workerid;

    private String workeridcard;

    private Integer deptid;

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

    public SixGoldDetail(Integer id, Integer workerid, String workeridcard, Integer deptid, Double endowmententerprise, Double endowmentpersonage, Double medicalenterprise, Double medicalpersonage, Double unemploymententerprise, Double unemploymentpersonage, Double inductrialinjuryenterprise, Double maternityenterprise, Double housingfundenterprise, Double housingfundpersonage, Double collectenterprise, Double collectpersonage, Double collect) {
        this.id = id;
        this.workerid = workerid;
        this.workeridcard = workeridcard;
        this.deptid = deptid;
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

    public Integer getWorkerid() {
        return workerid;
    }

    public void setWorkerid(Integer workerid) {
        this.workerid = workerid;
    }

    public String getWorkeridcard() {
        return workeridcard;
    }

    public void setWorkeridcard(String workeridcard) {
        this.workeridcard = workeridcard == null ? null : workeridcard.trim();
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
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
}