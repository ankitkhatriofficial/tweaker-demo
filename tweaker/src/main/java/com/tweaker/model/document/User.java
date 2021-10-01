package com.tweaker.model.document;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import com.tweaker.model.ADT.Address;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ankit Khatri
 */

@Getter
@Setter
public class User {

	@Id
	private String _id;
	@NotBlank(message = "FirstName can not be empty..!")
	private String firstName;
	private String lastName;
	@Indexed(unique = true)
	@NotBlank(message = "Email can not be empty..!")
	private String email;
	@Indexed(unique = true)
	@NotBlank(message = "contactNo can not be empty..!")
	private String contactNo;
	private Address address;
	private Date accountCreationTime;

}
