package com.tweaker.model.document;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ankit Khatri
 */

@Getter
@Setter
@Document(collection = "engineers")
public class Engineer extends User{

}
