package com.test.technical_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.technical_test.model.ProductModel;
import com.test.technical_test.service.ProductService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("product")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public Flux<ProductModel> listProducts(){
        return productService.listProducts();
    }
}
