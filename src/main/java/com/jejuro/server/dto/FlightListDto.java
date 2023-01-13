package com.jejuro.server.dto;

public class FlightListDto {

    private String logoUrl;
    private String airlineName;
    private String code;
    private String durationTime;
    private String depArr; // 출발지 목적지
    private String depArrTime; // 출발시간 목적시간
    private String depDate; // 출발 날짜
    private String airlineId; // 항공사
    private String fee;

    public FlightListDto(String logoUrl, String airlineName, String code, String durationTime, String depArr, String depArrTime, String depDate, String fee, String airlineId) {
        this.logoUrl = logoUrl;
        this.airlineName = airlineName;
        this.code = code;
        this.durationTime = durationTime;
        this.depArr = depArr;
        this.depArrTime = depArrTime;
        this.depDate = depDate;
        this.fee = fee;
        this.airlineId = airlineId;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getDepDate() {
        return depDate;
    }

    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

    public String getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(String airlineId) {
        this.airlineId = airlineId;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "FlightListDto{" +
                "logoUrl='" + logoUrl + '\'' +
                ", airlineName='" + airlineName + '\'' +
                ", code='" + code + '\'' +
                ", durationTime='" + durationTime + '\'' +
                ", depArr='" + depArr + '\'' +
                ", depArrTime='" + depArrTime + '\'' +
                ", depDate='" + depDate + '\'' +
                ", airlineId='" + airlineId + '\'' +
                ", fee='" + fee + '\'' +
                '}';
    }
}
