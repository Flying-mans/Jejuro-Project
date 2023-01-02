package com.jejuro.server.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public String main() {
        return "html/index";
    }

    @GetMapping("index")
    public String index() {
        return "html/index";
    }

    @GetMapping("search")
    public String search() {
        return "html/search/search";
    }

    @GetMapping("post")
    public String post() {
        return "html/post/post";
    }

    @GetMapping("sign-up")
    public String signup() {
        return "html/sign-up/sign-up";
    }

    @PostMapping("password")
    public String password() {
        return "html/findpasswd/password";
    }

    @GetMapping("denied")
    public String denied() {
        return "html/error/denied";
    }
}
