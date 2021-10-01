package com.tweaker.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweaker.model.document.Appliance;
import com.tweaker.model.document.Brand;
import com.tweaker.model.document.Category;
import com.tweaker.model.document.User;
import com.tweaker.model.service.CommonServiceApi;
import com.tweaker.repository.ApplianceRepo;
import com.tweaker.repository.BrandRepo;
import com.tweaker.repository.CategoryRepo;

/**
 * @author Ankit Khatri
 */

@Service
public class CommonServiceApiImpl implements CommonServiceApi {

	@Autowired
	private BrandRepo brandRepository;
	@Autowired
	private CategoryRepo categoryRepository;
	@Autowired
	private ApplianceRepo applianceRepository;

	@Override
	public List<Brand> fetchAllBrands() {
		return brandRepository.findAll();
	}

	@Override
	public List<Category> fetchAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public List<Appliance> fetchAllAppliances() {
		return applianceRepository.findAll();
	}

	@Override
	public User fetchProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePassword() {
		// TODO Auto-generated method stub
		return false;
	}

}
