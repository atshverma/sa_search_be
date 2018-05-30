package com.sas.sanction.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TransactionSearchRequestDto {

	private String transactionRefNumber;
	
	private String transactionType;
	
	private BigDecimal amountGreater;
	
	private BigDecimal amountLess; 
	
/*	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
	private Date transactionDate;*/
	
	private String currentSanctionStatus;

	
	@JsonFormat(shape=JsonFormat.Shape.ARRAY, pattern ="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date[] transactionDateTime;
	
	
	
	
	public Date[] getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(Date[] transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getTransactionRefNumber() {
		return transactionRefNumber;
	}

	public void setTransactionRefNumber(String transactionRefNumber) {
		this.transactionRefNumber = transactionRefNumber;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public BigDecimal getAmountGreater() {
		return amountGreater;
	}

	public void setAmountGreater(BigDecimal amountGreater) {
		this.amountGreater = amountGreater;
	}

	public BigDecimal getAmountLess() {
		return amountLess;
	}

	public void setAmountLess(BigDecimal amountLess) {
		this.amountLess = amountLess;
	}

	

	public String getCurrentSanctionStatus() {
		return currentSanctionStatus;
	}

	public void setCurrentSanctionStatus(String currentSanctionStatus) {
		this.currentSanctionStatus = currentSanctionStatus;
	} 
	
	
}
