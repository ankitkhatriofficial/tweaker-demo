package com.tweaker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tweaker.model.document.Brand;

/**
 * @author Ankit Khatri
 */

public interface BrandRepo extends MongoRepository<Brand, String>{

}
