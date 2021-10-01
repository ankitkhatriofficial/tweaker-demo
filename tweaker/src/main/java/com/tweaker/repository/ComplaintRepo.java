package com.tweaker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tweaker.model.document.Complaint;

/**
 * @author Ankit Khatri
 */
public interface ComplaintRepo extends MongoRepository<Complaint, String> {

}
