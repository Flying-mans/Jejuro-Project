package com.jejuro.server.entity;

public class Alarm {
	private int alarm_id;

	private String price;
	private int member_id;
	private String flight_code;
	private String dep_date;
	private int status;


	public Alarm() {
		// TODO Auto-generated constructor stub
	}

	public Alarm(String price) {
		this.price = price;
	}

	public int getAlarm_id() {
		return alarm_id;
	}

	public void setAlarm_id(int alarm_id) {
		this.alarm_id = alarm_id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getFlight_code() {
		return flight_code;
	}

	public void setFlight_code(String flight_code) {
		this.flight_code = flight_code;
	}

	public String getDep_date() {
		return dep_date;
	}

	public void setDep_date(String dep_date) {
		this.dep_date = dep_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Alarm [alarm_id=" + alarm_id + ", price=" + price + ", member_id=" + member_id + ", flight_code="
				+ flight_code + ", dep_date=" + dep_date + ", status=" + status + "]";
	}



}
