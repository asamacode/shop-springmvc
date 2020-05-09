package com.asama.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("home/index")
    public String index() {
        return "home/index";
    }
    
    @RequestMapping("home/about")
    public String about() {
        return "home/about";
    }
    
    @RequestMapping("home/contact")
    public String contact() {
        return "home/contact";
    }
    
    @RequestMapping("home/services")
    public String services() {
        return "home/services";
    }
}