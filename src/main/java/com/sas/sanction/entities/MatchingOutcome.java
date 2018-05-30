package com.sas.sanction.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the matching_outcome database table.
 * 
 */
@Entity
@Table(name="matching_outcome")
@NamedQuery(name="MatchingOutcome.findAll", query="SELECT m FROM MatchingOutcome m")
public class MatchingOutcome extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mo_sno")
	private int moSno;

	@Column(name="list_name")
	private String listName;

	@Column(name="match_strength")
	private String matchStrength;

	@Column(name="match_type")
	private String matchType;

	@Column(name="matched_value")
	private String matchedValue;

	@Column(name="matching_attribute")
	private String matchingAttribute;

	@Column(name="matching_attribute_value")
	private String matchingAttributeValue;

	@Column(name="transaction_sno")
	private String transactionSno;

	//bi-directional many-to-one association to SanctionCustomer
	@ManyToOne
	@JoinColumn(name="customer_id", referencedColumnName="customer_id")
	private SanctionCustomer sanctionCustomer;

	
	
	public MatchingOutcome() {
	}

	public int getMoSno() {
		return this.moSno;
	}

	public void setMoSno(int moSno) {
		this.moSno = moSno;
	}

	public String getListName() {
		return this.listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getMatchStrength() {
		return this.matchStrength;
	}

	public void setMatchStrength(String matchStrength) {
		this.matchStrength = matchStrength;
	}

	public String getMatchType() {
		return this.matchType;
	}

	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}

	public String getMatchedValue() {
		return this.matchedValue;
	}

	public void setMatchedValue(String matchedValue) {
		this.matchedValue = matchedValue;
	}

	public String getMatchingAttribute() {
		return this.matchingAttribute;
	}

	public void setMatchingAttribute(String matchingAttribute) {
		this.matchingAttribute = matchingAttribute;
	}

	public String getMatchingAttributeValue() {
		return this.matchingAttributeValue;
	}

	public void setMatchingAttributeValue(String matchingAttributeValue) {
		this.matchingAttributeValue = matchingAttributeValue;
	}

	
	public String getTransactionSno() {
		return transactionSno;
	}

	public void setTransactionSno(String transactionSno) {
		this.transactionSno = transactionSno;
	}

	public SanctionCustomer getSanctionCustomer() {
		return this.sanctionCustomer;
	}

	public void setSanctionCustomer(SanctionCustomer sanctionCustomer) {
		this.sanctionCustomer = sanctionCustomer;
	}

}