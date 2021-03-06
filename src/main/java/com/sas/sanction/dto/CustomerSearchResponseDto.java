package com.sas.sanction.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerSearchResponseDto {

	
	private String customerNumber;
	 
	private String fullName;
	 
	private String nationalId;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private Date dob;
	
	private String currentSanctionStatus;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private Date lastScreeningDateTime;


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

	public String getCurrentSanctionStatus() {
		return currentSanctionStatus;
	}

	public void setCurrentSanctionStatus(String currentSanctionStatus) {
		this.currentSanctionStatus = currentSanctionStatus;
	}

	public Date getLastScreeningDateTime() {
		return lastScreeningDateTime;
	}

	public void setLastScreeningDateTime(Date lastScreeningDateTime) {
		this.lastScreeningDateTime = lastScreeningDateTime;
	}

	
	
	
}
