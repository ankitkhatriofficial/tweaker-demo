package com.tweaker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tweaker.model.document.Category;

/**
 * @author Ankit Khatri
 */

public interface CategoryRepo extends MongoRepository<Category, String> {

	public Category findByName(String name);
	
}
