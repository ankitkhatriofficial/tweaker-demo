package com.tweaker.model.service;

import java.util.List;

import com.tweaker.model.document.Complaint;

/**
 * @author Ankit Khatri
 */

public interface CustomerServiceApi {

	public List<Complaint> fetchAllComplaints();

	public void createComplaint(Complaint complaint);

	public void updateComplaint(Complaint complaint);

	public void deleteComplaint(String compId);

}
