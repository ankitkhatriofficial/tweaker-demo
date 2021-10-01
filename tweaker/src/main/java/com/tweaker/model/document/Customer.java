package com.tweaker.model.document;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Ankit Khatri
 */

@Getter
@Setter
@ToString
@Document(collection = "customers")
public class Customer extends User {

}
