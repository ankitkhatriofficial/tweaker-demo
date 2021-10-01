package com.tweaker.controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweaker.model.document.Appliance;
import com.tweaker.model.document.Brand;
import com.tweaker.model.document.Category;
import com.tweaker.model.document.User;
import com.tweaker.model.response.ResponseMessage;
import com.tweaker.model.service.CommonServiceApi;

/**
 * @author Ankit Khatri
 */

@RestController
@RequestMapping("/public")
public class CommonController {

	@Autowired
	private CommonServiceApi commonServiceApi;

	@GetMapping("/brands")
	public List<Brand> getAllBrands() {
		return commonServiceApi.fetchAllBrands();
	}

	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		return commonServiceApi.fetchAllCategories();
	}

	@GetMapping("/appliances")
	public List<Appliance> getAllAppliances() {
		return commonServiceApi.fetchAllAppliances();
	}

	@GetMapping("/profile")
	public User getProfile() {
		// return user profile data by id or from spring context
		return null;
	}

	@PostMapping("/change-password")
	public ResponseEntity<ResponseMessage> changePassword() {
		// Take password as responseBody or request paramater
		return null;
	}
}
