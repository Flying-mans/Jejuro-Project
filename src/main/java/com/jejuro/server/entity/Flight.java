package com.jejuro.server.entity;


/**
 *  NoArgsConstructor
 *  AllArgsConstructor
 *  Getter
 *  Setter
 */
public class Flight {

    private Long id;
    private String code;
    private String departure;
    private String arrival;
    private String depTime;
    private String arrTime;
    private String depDate;
    private String collectedDate;

    private int fee;

    public Flight() {}

    public Flight(Long id, String code, String departure, String arrival, String depTime, String arrTime, String depDate, String collectedDate, int fee) {
        this.id = id;
        this.code = code;
        this.departure = departure;
        this.arrival = arrival;
        this.depTime = depTime;
        this.arrTime = arrTime;
        this.depDate = depDate;
        this.collectedDate = collectedDate;
        this.fee = fee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public String getDepDate() {
        return depDate;
    }

    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

    public String getCollectedDate() {
        return collectedDate;
    }

    public void setCollectedDate(String collectedDate) {
        this.collectedDate = collectedDate;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}

