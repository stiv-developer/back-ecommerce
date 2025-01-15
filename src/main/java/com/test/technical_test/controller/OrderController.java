package com.test.technical_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.test.technical_test.model.OrderModel;
import com.test.technical_test.service.OrderService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Mono<ResponseEntity<OrderModel>> createOrder(@RequestBody OrderModel order) {
        return orderService.createOrder(order)
            .map(savedOrder -> ResponseEntity.ok(savedOrder));
    }

    @GetMapping
    public Flux<OrderModel> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<OrderModel>> getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id)
            .map(order -> ResponseEntity.ok(order))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<OrderModel>> updateOrder(@PathVariable String id, @RequestBody OrderModel order) {
        return orderService.updateOrder(id, order)
            .map(updatedOrder -> ResponseEntity.ok(updatedOrder))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteOrder(@PathVariable String id) {
        return orderService.deleteOrder(id)
            .then(Mono.just(ResponseEntity.noContent().build()));
    }
    
}
