package com.tweaker.controller.Admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweaker.model.response.ResponseMessage;
import com.tweaker.model.service.AdminServiceApi;

/**
 * @author Ankit Khatri
 */

@RestController
@RequestMapping("/a/r")
public class DeleteController {

	@Autowired
	private AdminServiceApi adminApi;

	@DeleteMapping("/brands/{id}")
	public ResponseEntity<ResponseMessage> deleteBrand(@PathVariable String id) {
		adminApi.deleteBrand(id);
		// set a ResponseMessage and return the response
		ResponseMessage responseStatus = new ResponseMessage(200, HttpStatus.OK, "Brand is successfully removed..!",
				new Date());
		return new ResponseEntity<>(responseStatus, HttpStatus.OK);
	}

	@DeleteMapping("/categories/{id}")
	public ResponseEntity<ResponseMessage> deleteCategory(@PathVariable String id) {
		adminApi.deleteCategory(id);
		// set a ResponseMessage and return the response
		ResponseMessage responseStatus = new ResponseMessage(200, HttpStatus.OK, "Category is successfully removed..!",
				new Date());
		return new ResponseEntity<>(responseStatus, HttpStatus.OK);
	}

	@DeleteMapping("/appliances/{id}")
	public ResponseEntity<ResponseMessage> deleteAppliance(@PathVariable String id) {
		adminApi.deleteAppliance(id);
		// set a ResponseMessage and return the response
		ResponseMessage responseStatus = new ResponseMessage(200, HttpStatus.OK, "Appliance is successfully removed..!",
				new Date());
		return new ResponseEntity<>(responseStatus, HttpStatus.OK);
	}

	@DeleteMapping("/complaints/{id}")
	public ResponseEntity<ResponseMessage> deleteComplaints(@PathVariable String id) {
		adminApi.deleteComplaint(id);
		// set a ResponseMessage and return the response
		ResponseMessage responseStatus = new ResponseMessage(200, HttpStatus.OK, "Complaint is successfully removed..!",
				new Date());
		return new ResponseEntity<>(responseStatus, HttpStatus.OK);
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<ResponseMessage> deleteCustomer(@PathVariable String id) {
		adminApi.deleteCustomer(id);
		// set a ResponseMessage and return the response
		ResponseMessage responseStatus = new ResponseMessage(200, HttpStatus.OK, "Customer is successfully removed..!",
				new Date());
		return new ResponseEntity<>(responseStatus, HttpStatus.OK);
	}

	@DeleteMapping("/engineers/{id}")
	public ResponseEntity<ResponseMessage> deleteEngineer(@PathVariable String id) {
		adminApi.deleteEngineer(id);
		// set a ResponseMessage and return the response
		ResponseMessage responseStatus = new ResponseMessage(200, HttpStatus.OK, "Engineer is successfully removed..!",
				new Date());
		return new ResponseEntity<>(responseStatus, HttpStatus.OK);
	}

}
