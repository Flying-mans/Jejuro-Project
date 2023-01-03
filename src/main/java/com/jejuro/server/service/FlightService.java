package com.jejuro.server.service;

import com.jejuro.server.dto.FlightListDto;
import com.jejuro.server.dto.chart.FlightChartDto;
import com.jejuro.server.entity.view.FlightInfo;

import java.util.List;

public interface FlightService {

    List<FlightListDto> getFlightList(boolean oneWay,
                                      String departure,
                                      String arrival,
                                      String depDate,
                                      String arrDate);

    FlightListDto getFlightInfoByCode(String code, String depDate);

    FlightChartDto getFlightChart(String code, String depDate);

}
