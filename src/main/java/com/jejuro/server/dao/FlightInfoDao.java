package com.jejuro.server.dao;

import com.jejuro.server.entity.Flight;
import com.jejuro.server.entity.view.FlightInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FlightInfoDao {

	List<FlightInfo> getFlightListRoundtrip(String departure, String depDate, String arrDate, int offset, int size);
    List<FlightInfo> getFlightListOneWay(String departure, String depDate, int offset, int size);
    List<Flight> getDays(String code, String depDate, String airlineId);
    List<Flight> getDay(String code, String depDate, String airlineId);
    
    
    FlightInfo getFlightInfoByCode(String code, String depDate, String airlineId);
}
