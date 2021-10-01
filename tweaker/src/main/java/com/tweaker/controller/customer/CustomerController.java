package com.tweaker.controller.customer;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweaker.handler.exception.InvalidDataException;
import com.tweaker.model.document.Complaint;
import com.tweaker.model.response.ResponseMessage;
import com.tweaker.model.service.CustomerServiceApi;

/**
 * @author Ankit Khatri
 */

@RestController
@RequestMapping("/c")
public class CustomerController {

	@Autowired
	private CustomerServiceApi customerApi;

	/* Api to return all complaints of a particular customer */
	@GetMapping("/complaints")
	public List<Complaint> getAllComplaints() {
		// take customer id from spring context
		return null;
	}

	@PostMapping("/complaints")
	public ResponseEntity<ResponseMessage> addComplaint(@Valid @RequestBody Complaint complaint, BindingResult result) {
		// validate data & create complaint
		if (result.hasErrors())
			throw new InvalidDataException(result.getFieldError().getDefaultMessage());
		customerApi.createComplaint(complaint);
		// set a ResponseMessage and return the response
		ResponseMessage responseStatus = new ResponseMessage(201, HttpStatus.CREATED,
				"Complaint is successfully added..!", new Date());

		return new ResponseEntity<>(responseStatus, HttpStatus.CREATED);
	}

	@PutMapping("/complaints")
	public ResponseEntity<ResponseMessage> updateComplaint(@Valid @RequestBody Complaint complaint,
			BindingResult result) {
		if (result.hasErrors())
			throw new InvalidDataException(result.getFieldError().getDefaultMessage());
		// update the existing complaint (check if no existing record avaiable)
		// set the responseMessage and return response

		customerApi.updateComplaint(complaint);
		// set a ResponseMessage and return the response
		ResponseMessage responseStatus = new ResponseMessage(200, HttpStatus.OK, "Complaint is successfully updated..!",
				new Date());

		return new ResponseEntity<>(responseStatus, HttpStatus.OK);
	}

	@DeleteMapping("/complaints/{id}")
	public ResponseEntity<ResponseMessage> withdrawComplaint(@PathVariable String id) {
		// check the status of the complaints. if completed return false
		// delete the complaint request and
		customerApi.deleteComplaint(id);
		// set a ResponseMessage and return the response
		ResponseMessage responseStatus = new ResponseMessage(200, HttpStatus.OK,
				"Complaint is successfully withdrawn..!", new Date());

		return new ResponseEntity<>(responseStatus, HttpStatus.OK);
	}

}
