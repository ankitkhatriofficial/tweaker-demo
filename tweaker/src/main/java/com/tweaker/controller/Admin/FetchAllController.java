package com.tweaker.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweaker.model.document.Complaint;
import com.tweaker.model.document.Customer;
import com.tweaker.model.document.Engineer;
import com.tweaker.model.service.AdminServiceApi;

/**
 * @author Ankit Khatri
 */

@RestController
@RequestMapping("/a/all")
public class FetchAllController {

	@Autowired
	private AdminServiceApi adminApi;

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return adminApi.fetchAllCustomers();
	}

	@GetMapping("/engineers")
	public List<Engineer> getAllEngineers() {
		return adminApi.fetchAllEngineers();
	}

	@GetMapping("/complaints")
	public List<Complaint> getAllComplaints() {
		return adminApi.fetchAllComplaints();
	}

}
