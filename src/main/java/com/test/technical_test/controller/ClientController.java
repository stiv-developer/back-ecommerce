package com.test.technical_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.technical_test.model.ClientModel;
import com.test.technical_test.service.ClientService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/list")
    public Flux<ClientModel> listClient() {
        return clientService.listClients();
    }
    
}
