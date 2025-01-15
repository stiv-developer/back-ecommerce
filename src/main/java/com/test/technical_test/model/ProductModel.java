package com.test.technical_test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name="products")
@Getter
@Setter
public class ProductModel {
     @Id
    @Column(name="id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;
    
    @Column(name = "stock")
    private String stock;
}
