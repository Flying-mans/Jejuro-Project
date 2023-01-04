package com.jejuro.server.dto.chart;

public class FlightChartDto {

    private int lowestFee;
    private int highestFee;
    private int averageFee;
    private int previousFee;
    private int changePercentage;
    private ChartDto chartDto;

    public FlightChartDto(int lowestFee, int highestFee, int averageFee, int previousFee, int changePercentage, ChartDto chartDto) {
        this.lowestFee = lowestFee;
        this.highestFee = highestFee;
        this.averageFee = averageFee;
        this.previousFee = previousFee;
        this.changePercentage = changePercentage;
        this.chartDto = chartDto;
    }

    public int getLowestFee() {
        return lowestFee;
    }

    public void setLowestFee(int lowestFee) {
        this.lowestFee = lowestFee;
    }

    public int getHighestFee() {
        return highestFee;
    }

    public void setHighestFee(int highestFee) {
        this.highestFee = highestFee;
    }

    public int getAverageFee() {
        return averageFee;
    }

    public void setAverageFee(int averageFee) {
        this.averageFee = averageFee;
    }

    public int getPreviousFee() {
        return previousFee;
    }

    public void setPreviousFee(int previousFee) {
        this.previousFee = previousFee;
    }

    public int getChangePercentage() {
        return changePercentage;
    }

    public void setChangePercentage(int changePercentage) {
        this.changePercentage = changePercentage;
    }

    public ChartDto getChartDto() {
        return chartDto;
    }

    public void setChartDto(ChartDto chartDto) {
        this.chartDto = chartDto;
    }
}