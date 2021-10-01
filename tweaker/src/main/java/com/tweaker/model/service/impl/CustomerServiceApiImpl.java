package com.tweaker.model.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tweaker.handler.exception.CustomException;
import com.tweaker.model.document.Complaint;
import com.tweaker.model.response.ResponseMessage;
import com.tweaker.model.service.CustomerServiceApi;
import com.tweaker.repository.ComplaintRepo;

/**
 * @author Ankit Khatri
 */

@Service
public class CustomerServiceApiImpl implements CustomerServiceApi {

	@Autowired
	private ComplaintRepo complaintRepository;

	@Override
	public List<Complaint> fetchAllComplaints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createComplaint(Complaint complaint) {
		try {
			complaint.setComplaintDateTime(new Date());
			complaintRepository.save(complaint);
		} catch (Exception exception) {
			throw new RuntimeException("Exception from CustomerServiceApiImpl while creating complaint..!");
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
			throw new RuntimeException("Exception from CustomerServiceApiImpl while updating complaint..!");
		}
	}

	@Override
	public void deleteComplaint(String compId) {
		Optional<Complaint> optional = complaintRepository.findById(compId);
		if (optional.isEmpty())
			throw new CustomException(
					new ResponseMessage(406, HttpStatus.NOT_ACCEPTABLE, "Complaint id not found..!", new Date()), "");
		complaintRepository.deleteById(compId);
	}

}
