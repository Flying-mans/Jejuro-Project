package com.jejuro.server.dao;

import com.jejuro.server.entity.view.FlightInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FlightInfoDao {

    List<FlightInfo> getFlightListOneWay(String departure, String depDate, int offset, int size);
    List<FlightInfo> getFlightList(String departure, String depDate, String arrDate, int offset, int size);
}