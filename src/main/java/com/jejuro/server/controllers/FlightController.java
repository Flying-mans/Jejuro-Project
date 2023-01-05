package com.jejuro.server.controllers;

import java.util.ArrayList;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.jejuro.server.dto.BasicFlightInfoDto;
import com.jejuro.server.dto.FlightListDto;
import com.jejuro.server.entity.Flight;
import com.jejuro.server.service.FlightService;
import com.jejuro.server.entity.Member;
import com.jejuro.server.service.AlarmService;
import com.jejuro.server.service.MemberService;


@Controller
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;


    

    @Autowired
    private AlarmService alarmService;
  
    @Autowired
    private MemberService memberService;


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

    @GetMapping("/{code}/{depDate}")
    public String getChart(
            @PathVariable("code") String code,
            @PathVariable("depDate") String depDate,
            Model model
    ) {
        FlightListDto flightInfoByCode = flightService.getFlightInfoByCode(code, depDate);
        model.addAttribute("flight", flightInfoByCode);
       
       List<Flight> charts = flightService.getDays(code,depDate);
       List<Flight> chart = flightService.getDay(code, depDate);
       List<String> days = new ArrayList<String>();
       List<String> fees = new ArrayList<String>();
    
       for(int i=0; i<charts.size(); i++) {
    	   String dayList = charts.get(i).getCollected_date();
    	   String feeList = charts.get(i).getFee(); 
    	   days.add(dayList);
    	   fees.add(feeList);
       }
       
       int lowestFee = Integer.parseInt(charts.get(0).getLowestFee());
       int highestFee = Integer.parseInt(charts.get(0).getHighestFee());
       
       model.addAttribute("days", days);
       model.addAttribute("fees", fees);
       model.addAttribute("charts",charts);
       model.addAttribute("chart", chart);
       model.addAttribute("lowestFee", lowestFee);
       model.addAttribute("highestFee", highestFee);
       
        return "html/airlinechart/airlinechart";
    }

    @PostMapping("/alarm")
    public String setAlarm(
            @RequestParam("code") String code,
            @RequestParam("depDate") String depDate,
            @RequestParam("alarm") String price1,
            Principal principal
    ) {
        String username = principal.getName();
        Member member = memberService.getByNickname(username);
        int memberId = member.getMember_id();
        int price = Integer.parseInt(price1);

        alarmService.setAlarm(memberId, code, depDate, price);


        String result = "redirect:/flight/" + code + "/" + depDate;
        return result;
    }
}
