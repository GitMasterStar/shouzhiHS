package com.sz.pojo;

public class Insurance {
    private Integer id;

    private String icity;

    private String endowmentj;

    private String endowmentp;

    private Double endowmentmax;

    private Double endowmentmin;

    private String medicalj;

    private String medicalp;

    private Double medicalmax;

    private Double medicalmin;

    private String unemploymentj;

    private String unemploymentp;

    private Double unemploymentmax;

    private Double unemploymentmin;

    private String inductrialinjuryj;

    private Double inductrialinjurymax;

    private Double inductrialinjurymin;

    private String fertilityjob;

    private Double fertilitymax;

    private Double fertilitymin;

    private String housej;

    private String housep;

    private Double housemax;

    private Double housemin;

    public Insurance(Integer id, String icity, String endowmentj, String endowmentp, Double endowmentmax, Double endowmentmin, String medicalj, String medicalp, Double medicalmax, Double medicalmin, String unemploymentj, String unemploymentp, Double unemploymentmax, Double unemploymentmin, String inductrialinjuryj, Double inductrialinjurymax, Double inductrialinjurymin, String fertilityjob, Double fertilitymax, Double fertilitymin, String housej, String housep, Double housemax, Double housemin) {
        this.id = id;
        this.icity = icity;
        this.endowmentj = endowmentj;
        this.endowmentp = endowmentp;
        this.endowmentmax = endowmentmax;
        this.endowmentmin = endowmentmin;
        this.medicalj = medicalj;
        this.medicalp = medicalp;
        this.medicalmax = medicalmax;
        this.medicalmin = medicalmin;
        this.unemploymentj = unemploymentj;
        this.unemploymentp = unemploymentp;
        this.unemploymentmax = unemploymentmax;
        this.unemploymentmin = unemploymentmin;
        this.inductrialinjuryj = inductrialinjuryj;
        this.inductrialinjurymax = inductrialinjurymax;
        this.inductrialinjurymin = inductrialinjurymin;
        this.fertilityjob = fertilityjob;
        this.fertilitymax = fertilitymax;
        this.fertilitymin = fertilitymin;
        this.housej = housej;
        this.housep = housep;
        this.housemax = housemax;
        this.housemin = housemin;
    }

    public Insurance() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcity() {
        return icity;
    }

    public void setIcity(String icity) {
        this.icity = icity == null ? null : icity.trim();
    }

    public String getEndowmentj() {
        return endowmentj;
    }

    public void setEndowmentj(String endowmentj) {
        this.endowmentj = endowmentj == null ? null : endowmentj.trim();
    }

    public String getEndowmentp() {
        return endowmentp;
    }

    public void setEndowmentp(String endowmentp) {
        this.endowmentp = endowmentp == null ? null : endowmentp.trim();
    }

    public Double getEndowmentmax() {
        return endowmentmax;
    }

    public void setEndowmentmax(Double endowmentmax) {
        this.endowmentmax = endowmentmax;
    }

    public Double getEndowmentmin() {
        return endowmentmin;
    }

    public void setEndowmentmin(Double endowmentmin) {
        this.endowmentmin = endowmentmin;
    }

    public String getMedicalj() {
        return medicalj;
    }

    public void setMedicalj(String medicalj) {
        this.medicalj = medicalj == null ? null : medicalj.trim();
    }

    public String getMedicalp() {
        return medicalp;
    }

    public void setMedicalp(String medicalp) {
        this.medicalp = medicalp == null ? null : medicalp.trim();
    }

    public Double getMedicalmax() {
        return medicalmax;
    }

    public void setMedicalmax(Double medicalmax) {
        this.medicalmax = medicalmax;
    }

    public Double getMedicalmin() {
        return medicalmin;
    }

    public void setMedicalmin(Double medicalmin) {
        this.medicalmin = medicalmin;
    }

    public String getUnemploymentj() {
        return unemploymentj;
    }

    public void setUnemploymentj(String unemploymentj) {
        this.unemploymentj = unemploymentj == null ? null : unemploymentj.trim();
    }

    public String getUnemploymentp() {
        return unemploymentp;
    }

    public void setUnemploymentp(String unemploymentp) {
        this.unemploymentp = unemploymentp == null ? null : unemploymentp.trim();
    }

    public Double getUnemploymentmax() {
        return unemploymentmax;
    }

    public void setUnemploymentmax(Double unemploymentmax) {
        this.unemploymentmax = unemploymentmax;
    }

    public Double getUnemploymentmin() {
        return unemploymentmin;
    }

    public void setUnemploymentmin(Double unemploymentmin) {
        this.unemploymentmin = unemploymentmin;
    }

    public String getInductrialinjuryj() {
        return inductrialinjuryj;
    }

    public void setInductrialinjuryj(String inductrialinjuryj) {
        this.inductrialinjuryj = inductrialinjuryj == null ? null : inductrialinjuryj.trim();
    }

    public Double getInductrialinjurymax() {
        return inductrialinjurymax;
    }

    public void setInductrialinjurymax(Double inductrialinjurymax) {
        this.inductrialinjurymax = inductrialinjurymax;
    }

    public Double getInductrialinjurymin() {
        return inductrialinjurymin;
    }

    public void setInductrialinjurymin(Double inductrialinjurymin) {
        this.inductrialinjurymin = inductrialinjurymin;
    }

    public String getFertilityjob() {
        return fertilityjob;
    }

    public void setFertilityjob(String fertilityjob) {
        this.fertilityjob = fertilityjob == null ? null : fertilityjob.trim();
    }

    public Double getFertilitymax() {
        return fertilitymax;
    }

    public void setFertilitymax(Double fertilitymax) {
        this.fertilitymax = fertilitymax;
    }

    public Double getFertilitymin() {
        return fertilitymin;
    }

    public void setFertilitymin(Double fertilitymin) {
        this.fertilitymin = fertilitymin;
    }

    public String getHousej() {
        return housej;
    }

    public void setHousej(String housej) {
        this.housej = housej == null ? null : housej.trim();
    }

    public String getHousep() {
        return housep;
    }

    public void setHousep(String housep) {
        this.housep = housep == null ? null : housep.trim();
    }

    public Double getHousemax() {
        return housemax;
    }

    public void setHousemax(Double housemax) {
        this.housemax = housemax;
    }

    public Double getHousemin() {
        return housemin;
    }

    public void setHousemin(Double housemin) {
        this.housemin = housemin;
    }
}