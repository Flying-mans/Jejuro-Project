package com.jejuro.server.service;

import com.jejuro.server.dto.FlightListDto;

import java.util.List;

public interface FlightService {

    List<FlightListDto> getFlightList(boolean oneWay,
                                      String departure,
                                      String arrival,
                                      String depDate,
                                      String arrDate);
}
