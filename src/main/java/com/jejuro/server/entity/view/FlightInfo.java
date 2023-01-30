package com.jejuro.server.entity.view;


/**
 *  NoArgsConstructor
 *  AllArgsConstructor
 *  Getter
 *  Setter
 */
public class FlightInfo {

    private String name;
    private String url; // logo image url (추후 s3에 올리기)

    private String code;
    private String departure;
    private String arrival;
    private int fee;

    private String dep_time;

    private String arr_time;

    private String dep_date;

    private  String airline_id;

    public FlightInfo(String name, String url, String code, String departure, String arrival, int fee, String dep_time, String arr_time, String dep_date, String airlineId) {
        this.name = name;
        this.url = url;
        this.code = code;
        this.departure = departure;
        this.arrival = arrival;
        this.fee = fee;
        this.dep_time = dep_time;
        this.arr_time = arr_time;
        this.dep_date = dep_date;
        this.airline_id = airlineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getDepTime() {
        return dep_time;
    }

    public void setDepTime(String dep_time) {
        this.dep_time = dep_time;
    }

    public String getArrTime() {
        return arr_time;
    }

    public void setArrTime(String arr_time) {
        this.arr_time = arr_time;
    }

    public String getDepDate() {
        return dep_date;
    }

    public void setDepDate(String dep_date) {
        this.dep_date = dep_date;
    }

    public String getAirlineId() {
        return airline_id;
    }

    public void setAirlineId(String airline_id) {
        this.airline_id = airline_id;
    }
}