package com.fpoly.assigment_java06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/checkout")
    public String checkOut(){
        return "order/checkout";
    }

    @GetMapping("/list")
    public String orderList(){
        return "order/list";
    }
    @GetMapping("/detail/{id}")
    public String orderDetail(){
        return "order/detail";
    }


}
