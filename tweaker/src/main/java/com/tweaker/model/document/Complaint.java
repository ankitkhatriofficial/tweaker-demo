package com.tweaker.model.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ankit Khatri
 */
@Getter
@Setter
@Document(collection = "complaints")
public class Complaint {

	@Id
	private String _id;
	private boolean isresolved;
	private String status = "pending";
	private Customer customer;
	private Brand brand;
	private Category category;
	private Appliance appliance;
	private Date complaintDateTime;

}
