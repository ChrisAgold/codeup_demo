package com.codeup.codeup_demo.springblog.controllers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


//    @GetMapping("/")
//    @ResponseBody
//    public String welcome(){
//        return "This is the landing page!";
//    }

//    @GetMapping("/")
//    @ResponseBody
//    public String welcome(){
//        return "This is the landing page!";
//    }

    @GetMapping("/")
    @ResponseBody
    public String welcome(){
        return "home";
    }
}