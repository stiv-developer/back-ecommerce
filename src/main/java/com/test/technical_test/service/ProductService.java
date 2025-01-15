package com.test.technical_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.technical_test.model.ProductModel;
import com.test.technical_test.repository.ProductRepository;
import reactor.core.publisher.Flux;

@Service
public class ProductService {
    
    @Autowired
    ProductRepository productRepository;

    public Flux<ProductModel> listProducts() {
        return Flux.fromIterable(productRepository.findAll());
    }
}
