package com.jejuro.server.service;

import com.jejuro.server.dto.FlightListDto;
import com.jejuro.server.entity.Flight;

import java.util.List;

public interface FlightService {

    List<FlightListDto> getFlightList(boolean oneWay,
                                      String departure,
                                      String arrival,
                                      String depDate,
                                      String arrDate);

    FlightListDto getFlightInfoByCode(String code, String depDate);




	List<Flight> getDays(String code, String depDate);
	
	List<Flight> getDay(String code, String depDate);
	
	
    
}
