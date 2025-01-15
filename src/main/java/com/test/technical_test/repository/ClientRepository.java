package com.test.technical_test.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.technical_test.model.ClientModel;

public interface ClientRepository extends CrudRepository<ClientModel, String>{

   
}
