package com.tweaker.controller.Admin;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweaker.handler.exception.InvalidDataException;
import com.tweaker.model.document.Appliance;
import com.tweaker.model.document.Brand;
import com.tweaker.model.document.Category;
import com.tweaker.model.document.Complaint;
import com.tweaker.model.document.Customer;
import com.tweaker.model.document.Engineer;
import com.tweaker.model.response.ResponseMessage;
import com.tweaker.model.service.AdminServiceApi;

/**
 * @author Ankit Khatri
 */

@RestController
@RequestMapping("/a/update")
public class UpdateController {

	@Autowired
	private AdminServiceApi adminApi;

	@PutMapping("/brands")
	public ResponseEntity<ResponseMessage> updateBrand(@Valid @RequestBody Brand brand, BindingResult result) {
		// take input of brand and update it to database
		if (result.hasErrors())
			throw new InvalidDataException(result.getFieldError().getDefaultMessage());

		adminApi.updateBrand(brand);
		// set a ResponseMessage and return the response
		ResponseMessage responseStatus = new ResponseMessage(200, HttpStatus.OK, "Brand is successfully updated..!",
				new Date());

		return new ResponseEntity<>(responseStatus, HttpStatus.OK);

	}

	@PutMapping("/categories")
	public ResponseEntity<ResponseMessage> updateCategory(@Valid @RequestBody Category category, BindingResult result) {
		// take input of category and update it to database
		if (result.hasErrors())
			throw new InvalidDataException(result.getFieldError().getDefaultMessage());

		adminApi.updateCategory(category);
		// set a ResponseMessage and return the response
		ResponseMessage responseStatus = new ResponseMessage(200, HttpStatus.OK, "Category is successfully updated..!",
				new Date());

		return new ResponseEntity<>(responseStatus, HttpStatus.OK);
	}

	@PutMapping("/appliances")
	public ResponseEntity<ResponseMessage> updateAppliance(@Valid @RequestBody Appliance appliance,
			BindingResult result) {
		// take input of appliances and update it to database
		if (result.hasErrors())
			throw new InvalidDataException(result.getFieldError().getDefaultMessage());

		adminApi.updateAppliance(appliance);
		// set a ResponseMessage and return the response
		ResponseMessage responseStatus = new ResponseMessage(200, HttpStatus.OK, "Appliance is successfully updated..!",
				new Date());

		return new ResponseEntity<>(responseStatus, HttpStatus.OK);
	}

	@PutMapping("/complaints")
	public ResponseEntity<ResponseMessage> updateComplaint(@Valid @RequestBody Complaint complaint,
			BindingResult result) {
		// update complaints on the basis of customer
		if (result.hasErrors())
			throw new InvalidDataException(result.getFieldError().getDefaultMessage());

		adminApi.updateComplaint(complaint);
		// set a ResponseMessage and return the response
		ResponseMessage responseStatus = new ResponseMessage(200, HttpStatus.OK, "Complaint is successfully updated..!",
				new Date());

		return new ResponseEntity<>(responseStatus, HttpStatus.OK);
	}

	@PutMapping("/customers")
	public ResponseEntity<ResponseMessage> updateCustomer(@Valid @RequestBody Customer customer, BindingResult result) {
		// take input of engineer and update it to database
		if (result.hasErrors())
			throw new InvalidDataException(result.getFieldError().getDefaultMessage());

		adminApi.updateCustomer(customer);
		// set a ResponseMessage and return the response
		ResponseMessage responseStatus = new ResponseMessage(200, HttpStatus.OK, "Customer is successfully updated..!",
				new Date());

		return new ResponseEntity<>(responseStatus, HttpStatus.OK);
	}

	@PutMapping("/engineers")
	public ResponseEntity<ResponseMessage> updateEngineer(@Valid @RequestBody Engineer engineer, BindingResult result) {
		// take input of engineer and update it to database
		if (result.hasErrors())
			throw new InvalidDataException(result.getFieldError().getDefaultMessage());

		adminApi.updateEngineer(engineer);
		// set a ResponseMessage and return the response
		ResponseMessage responseStatus = new ResponseMessage(200, HttpStatus.OK, "Engineer is successfully updated..!",
				new Date());

		return new ResponseEntity<>(responseStatus, HttpStatus.OK);
	}

}
