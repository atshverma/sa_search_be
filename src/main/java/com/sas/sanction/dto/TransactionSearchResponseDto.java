package com.sas.sanction.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TransactionSearchResponseDto {

	private String refNumber;
	 
	private String name;
	 
	private String type;
	
	private BigDecimal amount;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private Date transactionDateTime;
	
	private String transactionSanctionStatus;
	
	private String currentSanctionStatus;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private Date lastScreeningDate;


	public String getRefNumber() {
		return refNumber;
	}

	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(Date transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getTransactionSanctionStatus() {
		return transactionSanctionStatus;
	}

	public void setTransactionSanctionStatus(String transactionSanctionStatus) {
		this.transactionSanctionStatus = transactionSanctionStatus;
	}

	public String getCurrentSanctionStatus() {
		return currentSanctionStatus;
	}

	public void setCurrentSanctionStatus(String currentSanctionStatus) {
		this.currentSanctionStatus = currentSanctionStatus;
	}

	public Date getLastScreeningDate() {
		return lastScreeningDate;
	}

	public void setLastScreeningDate(Date lastScreeningDate) {
		this.lastScreeningDate = lastScreeningDate;
	}

	
	
	
}
