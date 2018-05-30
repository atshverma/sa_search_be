package com.sas.sanction.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ListMgmtSearchRequestDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String listType;
	
	private String listNameUniqueSno;
	
	private String customerName;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date dob; 
	
	private String nationalId;
	
	

	

	public String getListType() {
		return listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}

	public String getListNameUniqueSno() {
		return listNameUniqueSno;
	}

	public void setListNameUniqueSno(String listNameUniqueSno) {
		this.listNameUniqueSno = listNameUniqueSno;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	
	
	
}
