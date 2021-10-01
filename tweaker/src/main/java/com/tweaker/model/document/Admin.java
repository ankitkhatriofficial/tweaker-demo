package com.tweaker.model.document;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ankit Khatri
 */

@Getter
@Setter
@Document(collection = "admins")
public class Admin extends User{
	
}
