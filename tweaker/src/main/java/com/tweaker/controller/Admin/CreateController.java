package com.tweaker.controller.Admin;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweaker.handler.exception.InvalidDataException;
import com.tweaker.model.document.Brand;
import com.tweaker.model.document.Complaint;
import com.tweaker.model.document.Customer;
import com.tweaker.model.document.Engineer;
import com.tweaker.model.response.ResponseMessage;
import com.tweaker.model.service.AdminServiceApi;

/**
 * @author Ankit Khatri
 */

@RestController
@RequestMapping("/a/add")
public class CreateController {

	@Autowired
	private AdminServiceApi adminApi;

	@PostMapping("/brands")
	public ResponseEntity<ResponseMessage> addBrand(@Valid @RequestBody Brand brand, BindingResult result) {
		if (result.hasErrors())
			throw new InvalidDataException(result.getFieldError().getDefaultMessage());

		// take input of brand and add it to database
		// set response Entity and return response
		adminApi.createBrand(brand);

		ResponseMessage responseStatus = new ResponseMessage(201, HttpStatus.CREATED, "Brand is successfully added..!",
				new Date());

		return new ResponseEntity<>(responseStatus, HttpStatus.CREATED);
	}

	@PostMapping("/categories")
	public ResponseEntity<ResponseMessage> addCategory(@RequestParam("categoryName") String categoryName) {
		// take input of category and add it to database

		if (categoryName == null || categoryName.trim().isEmpty())
			throw new InvalidDataException("Invalid category id or category name..!");

		adminApi.createCategory(categoryName);

		// set response Entity and return response
		ResponseMessage responseStatus = new ResponseMessage(201, HttpStatus.CREATED,
				"Category is successfully added..!", new Date());

		return new ResponseEntity<>(responseStatus, HttpStatus.CREATED);
	}

	@PostMapping("/appliances")
	public ResponseEntity<ResponseMessage> addAppliance(@RequestParam("categoryId") String categoryId,
			@RequestParam("applianceNumber") String applianceNumber) {
		// take input of appliances and add it to database

		if (categoryId == null || categoryId.trim().isEmpty() || applianceNumber == null
				|| applianceNumber.trim().isEmpty())
			throw new InvalidDataException("Invalid brand id or category name..!");

		adminApi.createAppliance(categoryId, applianceNumber);

		// set response Entity and return response
		ResponseMessage responseStatus = new ResponseMessage(201, HttpStatus.CREATED,
				"Appliance number is successfully added..!", new Date());

		return new ResponseEntity<>(responseStatus, HttpStatus.CREATED);
	}

	@PostMapping("/complaints")
	public ResponseEntity<ResponseMessage> addComplaints(@Valid @RequestBody Complaint complaint,
			BindingResult result) {
		// take input of engineer and add it to database
		if (result.hasErrors())
			throw new InvalidDataException(result.getFieldError().getDefaultMessage());

		adminApi.createComplaint(complaint);

		// set response Entity and return response
		ResponseMessage responseStatus = new ResponseMessage(201, HttpStatus.CREATED,
				"New complaint is successfully added..!", new Date());

		return new ResponseEntity<>(responseStatus, HttpStatus.CREATED);
	}

	@PostMapping("/customers")
	public ResponseEntity<ResponseMessage> addCustomer(@Valid @RequestBody Customer customer, BindingResult result) {
		// take input of engineer and add it to database
		if (result.hasErrors())
			throw new InvalidDataException(result.getFieldError().getDefaultMessage());

		adminApi.createCustomer(customer);

		// set response Entity and return response
		ResponseMessage responseStatus = new ResponseMessage(201, HttpStatus.CREATED,
				"New customer is successfully added..!", new Date());

		return new ResponseEntity<>(responseStatus, HttpStatus.CREATED);
	}

	@PostMapping("/engineers")
	public ResponseEntity<ResponseMessage> addEngineer(@Valid @RequestBody Engineer engineer, BindingResult result) {
		// take input of engineer and add it to database
		if (result.hasErrors())
			throw new InvalidDataException(result.getFieldError().getDefaultMessage());

		adminApi.createEngineer(engineer);

		// set response Entity and return response
		ResponseMessage responseStatus = new ResponseMessage(201, HttpStatus.CREATED,
				"New engineer is successfully added..!", new Date());

		return new ResponseEntity<>(responseStatus, HttpStatus.CREATED);
	}
}
