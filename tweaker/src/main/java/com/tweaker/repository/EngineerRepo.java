package com.tweaker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tweaker.model.document.Engineer;

/**
 * @author Ankit Khatri
 */

public interface EngineerRepo extends MongoRepository<Engineer, String>{

}
