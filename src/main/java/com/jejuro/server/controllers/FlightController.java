package com.jejuro.server.controllers;

import com.jejuro.server.dto.BasicFlightInfoDto;
import com.jejuro.server.dto.FlightListDto;
import com.jejuro.server.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping()
    public String flightList(
            @RequestParam(value = "oneway", required = false) boolean oneWay,
            String departure,
            String arrival,
            String depDate,
            String arrDate,
            Model model
    ) {
        List<FlightListDto> flightList = flightService.getFlightList(oneWay, departure, arrival, depDate, arrDate);
        BasicFlightInfoDto basicInfoDto = new BasicFlightInfoDto(departure, arrival, depDate, arrDate);

        model.addAttribute("flights", flightList);
        model.addAttribute("basicInfo", basicInfoDto);

        return "html/airlinelist/airlinelist";
    }
}
