package com.test.technical_test.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.technical_test.model.ProductModel;

public interface ProductRepository extends CrudRepository<ProductModel, String> {
    
}
