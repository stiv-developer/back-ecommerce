package com.test.technical_test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.technical_test.model.OrderModel;
import com.test.technical_test.repository.OrderRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    public Mono<OrderModel> createOrder(OrderModel order) {
        return orderRepository.save(order);
    }

    public Flux<OrderModel> getOrders() {
        return orderRepository.findAll();
    }

    public Mono<OrderModel> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    public Mono<OrderModel> updateOrder(String id, OrderModel order) {
        return orderRepository.findById(id)
            .flatMap(existingOrder -> {
                existingOrder.setNroOrder(order.getNroOrder());
                existingOrder.setIdClient(order.getIdClient());
                existingOrder.setClient(order.getClient());
                existingOrder.setProducts(order.getProducts());
                existingOrder.setTotal(order.getTotal());
                return orderRepository.save(existingOrder);
            });
    }

    public Mono<Void> deleteOrder(String id) {
        return orderRepository.deleteById(id);
    }
}
