package com.fpoly.assigment_java06.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LoginController {

    //    @GetMapping("")
    @RequestMapping("/login")
    public String showView(){
        return "login/login";
    }
}
