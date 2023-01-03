package com.jejuro.server.dto;

public class BasicFlightInfoDto {
    private String departure;
    private String arrival;
    private String depDate;

    private String arrDate;

    public BasicFlightInfoDto(String departure, String arrival, String depDate, String arrDate) {
        this.departure = departure;
        this.arrival = arrival;
        this.depDate = depDate;
        this.arrDate = arrDate;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDepDate() {
        return depDate;
    }

    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

    public String getArrDate() {
        return arrDate;
    }

    public void setArrDate(String arrDate) {
        this.arrDate = arrDate;
    }
}
