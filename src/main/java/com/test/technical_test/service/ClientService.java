package com.test.technical_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.technical_test.model.ClientModel;
import com.test.technical_test.repository.ClientRepository;
import reactor.core.publisher.Flux;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Flux<ClientModel> listClients() {
        return Flux.fromIterable(clientRepository.findAll());
    }
    
}
