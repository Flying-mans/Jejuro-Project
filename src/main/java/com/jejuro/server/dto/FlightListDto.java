package com.jejuro.server.dto;

public class FlightListDto {

    private String logoUrl;
    private String airlineName;
    private String durationTime;
    private String depArr; // 출발지 목적지
    private String depArrTime; // 출발시간 목적시간
    private int fee;

    public FlightListDto(String logoUrl, String airlineName, String durationTime, String depArr, String depArrTime, int fee) {
        this.logoUrl = logoUrl;
        this.airlineName = airlineName;
        this.durationTime = durationTime;
        this.depArr = depArr;
        this.depArrTime = depArrTime;
        this.fee = fee;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(String durationTime) {
        this.durationTime = durationTime;
    }

    public String getDepArr() {
        return depArr;
    }

    public void setDepArr(String depArr) {
        this.depArr = depArr;
    }

    public String getDepArrTime() {
        return depArrTime;
    }

    public void setDepArrTime(String depArrTime) {
        this.depArrTime = depArrTime;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
