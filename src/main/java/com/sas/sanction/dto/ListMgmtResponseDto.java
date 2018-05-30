package com.sas.sanction.dto;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ListMgmtResponseDto {

	private String listDataUniqueSno;
	
	private String listNameUniqueSno;
	
	private String listName;
	
	private String listType; 
	
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

	

	public String getListNameUniqueSno() {
		return listNameUniqueSno;
	}

	public void setListNameUniqueSno(String listNameUniqueSno) {
		this.listNameUniqueSno = listNameUniqueSno;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getListType() {
		return listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
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
