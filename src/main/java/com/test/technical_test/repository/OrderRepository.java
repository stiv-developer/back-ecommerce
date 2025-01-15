package com.test.technical_test.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.test.technical_test.model.OrderModel;

@Repository
public interface OrderRepository extends ReactiveMongoRepository<OrderModel, String> {
    
}
