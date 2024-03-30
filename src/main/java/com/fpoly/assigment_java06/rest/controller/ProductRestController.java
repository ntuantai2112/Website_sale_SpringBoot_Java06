package com.fpoly.assigment_java06.rest.controller;

import com.fpoly.assigment_java06.entity.Product;
import com.fpoly.assigment_java06.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {

    @Autowired
    ProductService productService;

    @GetMapping("{id}")
    public Product getOne(@PathVariable("id") Integer id){
        return productService.findById(id);
    }
}
