package com.tweaker.model.document;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

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
class Catg {

	@Id
	@NotBlank(message = "Category id must not be null..!")
	private String _id;

	@NotBlank(message = "Category name must not be null..!")
	private String name;
}

@Document(collection = "brands")
@Getter
@Setter
@NoArgsConstructor
public class Brand {

	@Id
	private String _id;

	@Indexed(unique = true)
	private String name;

	private Set<Catg> categories;

	public Brand(String brandName, Set<Catg> categories) {
		this.name = brandName;
		if (categories == null)
			this.categories = new HashSet<>();
		else
			this.categories = categories;
	}

}
