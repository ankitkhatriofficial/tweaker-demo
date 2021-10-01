package com.tweaker.model.service;

import java.util.List;

import com.tweaker.model.document.Appliance;
import com.tweaker.model.document.Brand;
import com.tweaker.model.document.Category;
import com.tweaker.model.document.User;

/**
 * @author Ankit Khatri
 */

public interface CommonServiceApi {

	public List<Brand> fetchAllBrands();

	public List<Category> fetchAllCategories();

	public List<Appliance> fetchAllAppliances();

	public User fetchProfile();

	public boolean updatePassword();

}
