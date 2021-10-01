package com.tweaker.model.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tweaker.handler.exception.CustomException;
import com.tweaker.handler.exception.InvalidDataException;
import com.tweaker.model.document.Appliance;
import com.tweaker.model.document.Brand;
import com.tweaker.model.document.Category;
import com.tweaker.model.document.Complaint;
import com.tweaker.model.document.Customer;
import com.tweaker.model.document.Engineer;
import com.tweaker.model.response.ResponseMessage;
import com.tweaker.model.service.AdminServiceApi;
import com.tweaker.repository.ApplianceRepo;
import com.tweaker.repository.BrandRepo;
import com.tweaker.repository.CategoryRepo;
import com.tweaker.repository.ComplaintRepo;
import com.tweaker.repository.CustomerRepo;
import com.tweaker.repository.EngineerRepo;

/**
 * @author Ankit Khatri
 */

@Service
public class AdminServiceApiImpl implements AdminServiceApi {

	@Autowired
	private BrandRepo brandRepository;
	@Autowired
	private CategoryRepo categoryRepository;
	@Autowired
	private ApplianceRepo applianceRepository;
	@Autowired
	private EngineerRepo engineerRepository;
	@Autowired
	private CustomerRepo customerRepository;
	@Autowired
	private ComplaintRepo complaintRepository;

	/* --------------- BRAND RELATED APIs IMPLEMENTATION ------------------ */
	@Override
	public void createBrand(Brand brand) {
		try {
			brandRepository.save(brand);
		} catch (DuplicateKeyException exception) {

			ResponseMessage responseStatus = new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE,
					"Brand already exists..!", new Date());

			throw new CustomException(responseStatus, exception.getMessage());

		} catch (Exception exception) {
			throw new RuntimeException("Exception from AdminServiceApiImpl while Creating Brand..!");
		}
	}

	@Override
	public void updateBrand(Brand brand) {
		if (brand == null || brand.get_id() == null)
			throw new InvalidDataException("Brand id must not be null..!");
		Optional<Brand> optional = brandRepository.findById(brand.get_id());
		if (optional.isEmpty())
			throw new CustomException(
					new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE, "Brand id not found..!", new Date()), "");

		Brand brandInDB = optional.get();
		try {
			brandInDB.setCategories(brand.getCategories());
			brandInDB.setName(brand.getName());
			brandRepository.save(brandInDB);
		} catch (Exception exception) {
			throw new RuntimeException("Exception from AdminServiceApiImpl while updating brand..!");
		}
	}

	@Override
	public void deleteBrand(String id) {
		Optional<Brand> optional = brandRepository.findById(id);
		if (optional.isEmpty())
			throw new CustomException(
					new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE, "Brand id not found..!", new Date()), "");
		complaintRepository.deleteById(id);
	}

	/* --------------- CATEGORY RELATED APIs IMPLEMENTATION ------------------ */
	@Override
	public void createCategory(String categoryName) {
		try {
			categoryRepository.save(new Category(categoryName));
		} catch (DuplicateKeyException exception) {

			ResponseMessage responseStatus = new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE,
					"Category already exists..!", new Date());

			throw new CustomException(responseStatus, exception.getMessage());

		} catch (Exception exception) {
			throw new RuntimeException("Exception from AdminServiceApiImpl while Creating category..!");
		}
	}

	@Override
	public void updateCategory(Category category) {
		Optional<Category> optional = categoryRepository.findById(category.get_id());
		if (optional.isEmpty())
			throw new CustomException(
					new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE, "Category id not found..!", new Date()), "");

		Category categoryInDB = optional.get();
		try {
			category.set_id(categoryInDB.get_id());
			categoryRepository.save(category);
		} catch (Exception exception) {
			throw new RuntimeException("Exception from AdminServiceApiImpl while updating category..!");
		}
	}

	@Override
	public void deleteCategory(String id) {
		Optional<Category> optional = categoryRepository.findById(id);
		if (optional.isEmpty())
			throw new CustomException(
					new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE, "Category id not found..!", new Date()), "");
		complaintRepository.deleteById(id);
	}

	/* --------------- APPLIANCE RELATED APIs IMPLEMENTATION ------------------ */
	@Override
	public void createAppliance(String categoryId, String applianceName) {
		// check for the category existence
		Optional<Category> optional = categoryRepository.findById(categoryId);
		if (optional.isEmpty()) {
			ResponseMessage responseStatus = new ResponseMessage(404, HttpStatus.NOT_FOUND,
					"Category does not exist..!", new Date());
			throw new CustomException(responseStatus, "");
		}

		// got the category
		Category category = optional.get();
		try {
			applianceRepository.save(new Appliance(category, applianceName));
		} catch (DuplicateKeyException exception) {

			ResponseMessage responseStatus = new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE,
					"Appliance Number already exists..!", new Date());

			throw new CustomException(responseStatus, exception.getMessage());

		} catch (Exception exception) {
			throw new RuntimeException("Exception from AdminServiceApiImpl while Creating Appliance..!");
		}
	}

	@Override
	public void updateAppliance(Appliance appliance) {
		Optional<Appliance> optional = applianceRepository.findById(appliance.get_id());
		if (optional.isEmpty())
			throw new CustomException(
					new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE, "Appliance id not found..!", new Date()), "");

		Appliance applianceInDB = optional.get();
		try {
			appliance.set_id(applianceInDB.get_id());
			applianceRepository.save(appliance);
		} catch (Exception exception) {
			throw new RuntimeException("Exception from AdminServiceApiImpl while updating appliance..!");
		}
	}

	@Override
	public void deleteAppliance(String id) {
		Optional<Appliance> optional = applianceRepository.findById(id);
		if (optional.isEmpty())
			throw new CustomException(
					new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE, "Appliance id not found..!", new Date()), "");
		complaintRepository.deleteById(id);
	}

	/* --------------- COMPLAINT RELATED APIs IMPLEMENTATION ------------------ */
	@Override
	public List<Complaint> fetchAllComplaints() {
		return complaintRepository.findAll();
	}

	@Override
	public void createComplaint(Complaint complaint) {
		complaint.setComplaintDateTime(new Date());
		try {
			complaintRepository.save(complaint);
		} catch (DuplicateKeyException exception) {

			ResponseMessage responseStatus = new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE,
					"Complaint already exists..!", new Date());

			throw new CustomException(responseStatus, exception.getMessage());

		} catch (Exception exception) {
			throw new RuntimeException("Exception from AdminServiceApiImpl while Adding Complaint..!");
		}

	}

	@Override
	public void updateComplaint(Complaint complaint) {
		Optional<Complaint> optional = complaintRepository.findById(complaint.get_id());
		if (optional.isEmpty())
			throw new CustomException(
					new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE, "Complaint id not found..!", new Date()), "");

		Complaint complaintInDB = optional.get();
		try {
			complaint.setComplaintDateTime(complaintInDB.getComplaintDateTime());
			complaint.set_id(complaintInDB.get_id());
			complaintRepository.save(complaint);
		} catch (Exception exception) {
			throw new RuntimeException("Exception from AdminServiceApiImpl while updating complaint..!");
		}
	}

	@Override
	public void deleteComplaint(String id) {
		Optional<Complaint> optional = complaintRepository.findById(id);
		if (optional.isEmpty())
			throw new CustomException(
					new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE, "Complaint id not found..!", new Date()), "");
		complaintRepository.deleteById(id);
	}

	/* --------------- CUSTOMER RELATED APIs IMPLEMENTATION ------------------ */
	@Override
	public List<Customer> fetchAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void createCustomer(Customer customer) {
		customer.setAccountCreationTime(new Date());
		try {
			customerRepository.save(customer);
		} catch (DuplicateKeyException exception) {

			ResponseMessage responseStatus = new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE,
					"Customer already exists..!", new Date());

			throw new CustomException(responseStatus, exception.getMessage());

		} catch (Exception exception) {
			throw new RuntimeException("Exception from AdminServiceApiImpl while Adding Customer..!");
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		Optional<Customer> optional = customerRepository.findById(customer.get_id());
		if (optional.isEmpty())
			throw new CustomException(
					new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE, "Customer id not found..!", new Date()), "");

		Customer customerInDB = optional.get();
		try {
			customer.setAccountCreationTime(customerInDB.getAccountCreationTime());
			customerRepository.save(customer);
		} catch (DuplicateKeyException exception) {
			ResponseMessage responseStatus = new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE,
					"Customer already exists with this email or phone..!", new Date());
			throw new CustomException(responseStatus, exception.getMessage());
		} catch (Exception exception) {
			throw new RuntimeException("Exception from AdminServiceApiImpl while updating customer..!");
		}
	}

	@Override
	public void deleteCustomer(String id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if (optional.isEmpty())
			throw new CustomException(
					new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE, "Customer id not found..!", new Date()), "");
		complaintRepository.deleteById(id);
	}

	/* --------------- ENGINEER RELATED APIs IMPLEMENTATION ------------------ */
	@Override
	public List<Engineer> fetchAllEngineers() {
		return engineerRepository.findAll();
	}

	@Override
	public void createEngineer(Engineer engineer) {
		engineer.setAccountCreationTime(new Date());
		try {
			engineerRepository.save(engineer);
		} catch (DuplicateKeyException exception) {

			ResponseMessage responseStatus = new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE,
					"Engineer already exists..!", new Date());

			throw new CustomException(responseStatus, exception.getMessage());

		} catch (Exception exception) {
			throw new RuntimeException("Exception from AdminServiceApiImpl while adding engineer..!");
		}
	}

	@Override
	public void updateEngineer(Engineer engineer) {
		Optional<Engineer> optional = engineerRepository.findById(engineer.get_id());
		if (optional.isEmpty())
			throw new CustomException(
					new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE, "Engineer id not found..!", new Date()), "");

		Engineer engineerInDB = optional.get();
		try {
			engineer.setAccountCreationTime(engineerInDB.getAccountCreationTime());
			engineerRepository.save(engineer);
		} catch (Exception exception) {
			throw new RuntimeException("Exception from AdminServiceApiImpl while updating engineer..!");
		}
	}

	@Override
	public void deleteEngineer(String id) {
		Optional<Engineer> optional = engineerRepository.findById(id);
		if (optional.isEmpty())
			throw new CustomException(
					new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE, "Engineer id not found..!", new Date()), "");
		complaintRepository.deleteById(id);
	}

}
