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
    private String departure;
    private String arrival;
    private int fee;

    private String dep_time;

    private String arr_time;


    public FlightInfo() {
    }

    public FlightInfo(String name, String url, String departure, String arrival, int fee, String depTime, String arrTime) {
        this.name = name;
        this.url = url;
        this.departure = departure;
        this.arrival = arrival;
        this.fee = fee;
        this.dep_time = depTime;
        this.arr_time = arrTime;
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

    public void setDepTime(String depTime) {
        this.dep_time = depTime;
    }

    public String getArrTime() {
        return arr_time;
    }

    public void setArrTime(String arrTime) {
        this.arr_time = arrTime;
    }

    @Override
    public String toString() {
        return "FlightInfo{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", fee=" + fee +
                ", depTime='" + dep_time + '\'' +
                ", arrTime='" + arr_time + '\'' +
                '}';
    }
}