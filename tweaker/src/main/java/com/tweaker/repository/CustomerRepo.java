package com.tweaker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tweaker.model.document.Customer;

/**
 * @author Ankit Khatri
 */

public interface CustomerRepo extends MongoRepository<Customer, String>{

}
