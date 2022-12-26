package com.jejuro.server.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("index")
    public String index(){
        return "html/index";
    }

    @GetMapping("search")
    public String search(){
        return "html/search/search";
    }

    @GetMapping("login")
    public String login(){
        return "html/login/login";
    }
    @GetMapping("sign-up")
    public String signup(){
        return "html/sign-up/sign-up";
    }
}
