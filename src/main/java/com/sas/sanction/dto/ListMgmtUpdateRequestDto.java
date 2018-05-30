package com.sas.sanction.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ListMgmtUpdateRequestDto {

	@JsonProperty(required = true)
	private String listDataUniqueSno;
	
	private String customerNumber; 
	
	private String fullName; 
	
	private String nationalId; 
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private Date dob;
	
	
	

	public String getListDataUniqueSno() {
		return listDataUniqueSno;
	}

	public void setListDataUniqueSno(String listDataUniqueSno) {
		this.listDataUniqueSno = listDataUniqueSno;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	} 
	
	
	
	
}
