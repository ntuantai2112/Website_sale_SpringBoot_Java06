package com.fpoly.assigment_java06.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {

//    @GetMapping("")
    @RequestMapping("/home")
    public String showView(){
        return "layout/main";
    }
}
