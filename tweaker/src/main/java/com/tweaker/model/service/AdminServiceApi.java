package com.tweaker.model.service;

import java.util.List;

import com.tweaker.model.document.Appliance;
import com.tweaker.model.document.Brand;
import com.tweaker.model.document.Category;
import com.tweaker.model.document.Complaint;
import com.tweaker.model.document.Customer;
import com.tweaker.model.document.Engineer;

/**
 * @author Ankit Khatri
 */

public interface AdminServiceApi {

	/* --------------- BRAND ------------------ */
	public void createBrand(Brand brand);

	public void updateBrand(Brand brand);

	public void deleteBrand(String id);

	/* --------------- CATEGORY ------------------ */
	public void createCategory(String categoryName);

	public void updateCategory(Category category);

	public void deleteCategory(String id);

	/* --------------- Appliance ------------------ */
	public void createAppliance(String categoryId, String applianceName);

	public void updateAppliance(Appliance appliance);

	public void deleteAppliance(String id);

	/* --------------- COMPLAINT ------------------ */
	public void createComplaint(Complaint complaint);

	public void updateComplaint(Complaint complaint);

	public void deleteComplaint(String id);

	public List<Complaint> fetchAllComplaints();

	/* --------------- CUSTOMER ------------------ */
	public void createCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(String id);

	public List<Customer> fetchAllCustomers();

	/* --------------- Engineer ------------------ */
	public void createEngineer(Engineer engineer);

	public void updateEngineer(Engineer engineer);

	public void deleteEngineer(String id);

	public List<Engineer> fetchAllEngineers();
}
