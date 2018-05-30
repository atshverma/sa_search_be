package com.sas.sanction.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


/**
 * The persistent class for the matching_attribute_config_version database table.
 * 
 */
@Entity
@Table(name="matching_attribute_config_version")
@NamedQuery(name="MatchingAttributeConfigVersion.findAll", query="SELECT m FROM MatchingAttributeConfigVersion m")
public class MatchingAttributeConfigVersion extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Type(type="int")
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="mac_ver_sno")
	private int macVerSno;

	private String action;



	@Column(name="match_strength")
	private String matchStrength;

	@Column(name="match_type")
	private String matchType;

	@Column(name="request_attribute_name")
	private String requestAttributeName;

	//bi-directional many-to-one association to MatchingAttributeConfig
	@ManyToOne
	@JoinColumn(name="mac_sno")
	private MatchingAttributeConfig matchingAttributeConfig;

	public MatchingAttributeConfigVersion() {
	}

	public int getMacVerSno() {
		return this.macVerSno;
	}

	public void setMacVerSno(int macVerSno) {
		this.macVerSno = macVerSno;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
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

	public String getRequestAttributeName() {
		return this.requestAttributeName;
	}

	public void setRequestAttributeName(String requestAttributeName) {
		this.requestAttributeName = requestAttributeName;
	}

	

	public MatchingAttributeConfig getMatchingAttributeConfig() {
		return this.matchingAttributeConfig;
	}

	public void setMatchingAttributeConfig(MatchingAttributeConfig matchingAttributeConfig) {
		this.matchingAttributeConfig = matchingAttributeConfig;
	}

}