package com.jejuro.server.dto.chart;

import java.util.ArrayList;

public class ChartDto {
    private ArrayList<String> days;
    private ArrayList<Integer> fees;

    public ChartDto(ArrayList<String> days, ArrayList<Integer> fees) {
        this.days = days;
        this.fees = fees;
    }

    public ArrayList<String> getDays() {
        return days;
    }

    public ArrayList<Integer> getFees() {
        return fees;
    }
}
