package com.test.technical_test.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "orders")
@Getter
@Setter
public class OrderModel {
    @Id
    private String id;
    private String nroOrder;
    private String idClient;
    private String client;
    private List<Product> products;
    private Double total;

    @Getter
    @Setter
    public static class Product {
        private String id;   
        private String name; 
        private String quantity;
        private String totalPrice;
    }
}
