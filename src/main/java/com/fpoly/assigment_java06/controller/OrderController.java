package com.fpoly.assigment_java06.controller;

import com.fpoly.assigment_java06.entity.Order;
import com.fpoly.assigment_java06.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/checkout")
    public String checkOut(){
        return "order/checkout";
    }

    @GetMapping("/list")
    public String orderList(){
        return "order/list";
    }


    @GetMapping("/detail/{id}")
    public String orderDetail(@PathVariable("id") Long id, Model model){
        Order order = orderService.findById(id);
        System.out.println(order.getId());
        model.addAttribute("order",order);

        return "order/detail";
    }


}
