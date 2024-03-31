package com.fpoly.assigment_java06.controller;


import com.fpoly.assigment_java06.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {


//    @GetMapping("")
    @RequestMapping("/home")
    public String showView(Model model){
        Account account = LoginController.account;
        model.addAttribute("account",account);
        return "layout/main";
    }
}
