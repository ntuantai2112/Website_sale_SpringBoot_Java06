package com.fpoly.assigment_java06.rest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fpoly.assigment_java06.entity.Order;
import com.fpoly.assigment_java06.entity.Product;
import com.fpoly.assigment_java06.service.OrderService;
import com.fpoly.assigment_java06.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {

    @Autowired
    OrderService orderService;

    @PostMapping()
    public Order addOrder(@RequestBody JsonNode orderData){
        return orderService.create(orderData);
    }
}
