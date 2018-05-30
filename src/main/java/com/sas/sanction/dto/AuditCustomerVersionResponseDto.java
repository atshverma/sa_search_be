package com.sas.sanction.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AuditCustomerVersionResponseDto {

	private String customerNumber;
	
	private String fullname; 
	
	private String nationalId; 
	
	private String sanctionStatus;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private Date timeOfChange;

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	

	public String getSanctionStatus() {
		return sanctionStatus;
	}

	public void setSanctionStatus(String sanctionStatus) {
		this.sanctionStatus = sanctionStatus;
	}

	public Date getTimeOfChange() {
		return timeOfChange;
	}

	public void setTimeOfChange(Date timeOfChange) {
		this.timeOfChange = timeOfChange;
	}
	
	
}
