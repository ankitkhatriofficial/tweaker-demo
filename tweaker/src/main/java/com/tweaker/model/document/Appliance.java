package com.tweaker.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ankit Khatri
 */
@Getter
@Setter
@Document(collection = "appliances")
@NoArgsConstructor
public class Appliance {

	@Id
	private String _id;
	private Category category;
	private String applianceNumber;

	public Appliance(Category category, String applianceNumber) {
		this.category = category;
		this.applianceNumber = applianceNumber;
	}

}
