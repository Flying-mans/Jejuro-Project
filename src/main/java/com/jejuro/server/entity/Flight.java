package com.jejuro.server.entity;


/**
 *  NoArgsConstructor
 *  AllArgsConstructor
 *  Getter
 *  Setter
 */
public class Flight {

    private String collected_date;
    private String fee;
    private String lowestFee;
    private String highestFee;
    private String averageFee;

    public Flight() {}

    public Flight(String collected_date, String fee) {
		this.fee = fee;
		this.collected_date = collected_date;
	}

    
    public Flight(String collected_date, String fee, String lowestFee, String highestFee, String averageFee) {
		super();
		this.collected_date = collected_date;
		this.fee = fee;
		this.lowestFee = lowestFee;
		this.highestFee = highestFee;
		this.averageFee = averageFee;
	}

	public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

	public String getCollected_date() {
		return collected_date;
	}
	
	public void setCollected_date(String collected_date) {
		this.collected_date = collected_date;
	}

	public String getLowestFee() {
		return lowestFee;
	}

	public void setLowestFee(String lowestFee) {
		this.lowestFee = lowestFee;
	}

	public String getHighestFee() {
		return highestFee;
	}

	public void setHighestFee(String highestFee) {
		this.highestFee = highestFee;
	}

	public String getAverageFee() {
		return averageFee;
	}

	public void setAverageFee(String averageFee) {
		this.averageFee = averageFee;
	}

	@Override
	public String toString() {
		return "Flight [collected_date=" + collected_date + ", fee=" + fee + ", lowestFee=" + lowestFee
				+ ", highestFee=" + highestFee + ", averageFee=" + averageFee + "]";
	}
	

}

