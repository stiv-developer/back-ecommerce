package com.test.technical_test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name="clients")
@Getter
@Setter
public class ClientModel {
    @Id
    @Column(name="id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private String phone;
}
