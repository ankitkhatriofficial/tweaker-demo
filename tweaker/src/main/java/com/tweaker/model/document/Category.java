package com.tweaker.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ankit Khatri
 */
@Getter
@Setter
@Document(collection = "categories")
@NoArgsConstructor
public class Category {

	@Id
	private String _id;

	@Indexed(unique = true)
	private String name;

	public Category(String name) {
		this.name = name;
	}
}
