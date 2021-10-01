package com.tweaker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tweaker.model.document.Appliance;

/**
 * @author Ankit Khatri
 */

public interface ApplianceRepo extends MongoRepository<Appliance, String>{
	
}
