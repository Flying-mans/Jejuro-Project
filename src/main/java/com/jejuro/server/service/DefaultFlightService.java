package com.jejuro.server.service;

import com.jejuro.server.dao.FlightInfoDao;
import com.jejuro.server.dto.FlightListDto;
import com.jejuro.server.entity.view.FlightInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultFlightService implements FlightService{

    @Autowired
    private FlightInfoDao flightInfoDao;

    /**
     * search 페이지에서 넘어온 데이터를 가지고
     * 검색된 항공편 정보를 넘겨줌
     */
    @Override
    public List<FlightListDto> getFlightList(boolean oneWay, String departure, String arrival, String depDate, String arrDate) {
        List<FlightListDto> flightListDtos = new ArrayList<>();
        depDate = depDate.replace("-", "");

        if (oneWay) {
            List<FlightInfo> flightList = flightInfoDao.getFlightListOneWay(departure, depDate, 0, 100);

            for (FlightInfo f : flightList) {
                FlightListDto flightListDto = getFlightListDto(f);
                flightListDtos.add(flightListDto);
            }
        } else {
            // TODO: 왕복일 경우
        }
        return flightListDtos;
    }

    private static FlightListDto getFlightListDto(FlightInfo f) {
        String durationTime = getDurationTime(f.getArrTime(), f.getDepTime());
        //GMP - CJU
        String depArr = f.getDeparture() + " -> " + f.getArrival();
        // 0640 - 0710
        String depArrTime = f.getDepTime().substring(0,2) + ":" +f.getDepTime().substring(2,4)+ " ~ "
                + f.getArrTime().substring(0,2)+":"+f.getArrTime().substring(2,4);
        //항공사 이름, img
        String logoUrl = f.getUrl();
        String airLineName = f.getName();
        //가격
        DecimalFormat won = new DecimalFormat("###,###");
        String fee = won.format(f.getFee())+"원";
        FlightListDto flightListDto = new FlightListDto(logoUrl, airLineName, durationTime, depArr, depArrTime, fee);
        return flightListDto;
    }

    /**
     * 출발지에서 목적지까지 걸리는 시간을 계산해주는 함수
     */
    private static String getDurationTime(String arrivalTime, String departureTime) {
        int arrTime = Integer.parseInt(arrivalTime);
        int depTime = Integer.parseInt(departureTime);

        int time = ((arrTime / 100) * 60 + (arrTime % 100)) - ((depTime / 100) * 60 + (depTime % 100));
        int hour = time / 60;
        int min = time % 60;
        String durationTime = Integer.toString(hour) + "시간 " + Integer.toString(min) + "분";
        return durationTime;
    }
}