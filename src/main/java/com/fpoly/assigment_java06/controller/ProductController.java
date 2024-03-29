package com.fpoly.assigment_java06.controller;

import com.fpoly.assigment_java06.entity.Product;
import com.fpoly.assigment_java06.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {


    @Autowired
    ProductService productService;


    @GetMapping("/list")
    public String showViewListProduct(Model model, @RequestParam("page") Optional<Integer> pageParam) {
        return "product/list";
    }

    @GetMapping("/store")
    public String showViewStoreProduct(Model model, @RequestParam("page") Optional<Integer> pageParam
            , @RequestParam("cid") Optional<String> cid

    ) {
        int p = pageParam.orElse(0);
        String categoryId = cid.orElse(null);
        if (cid.isPresent()) {
            Page<Product> pageProduct = this.productService.findByCategoryId(categoryId, p, 9);
            model.addAttribute("pageProduct", pageProduct);
        } else {
            Page<Product> pageProduct = this.productService.findAll(p, 9);
            model.addAttribute("pageProduct", pageProduct);
        }


        return "product/store";


    }


    @GetMapping("/detail/{id}")
    public String detailProduct(Model model, @PathVariable("id") Integer id) {
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        return "product/detail";
    }
}
