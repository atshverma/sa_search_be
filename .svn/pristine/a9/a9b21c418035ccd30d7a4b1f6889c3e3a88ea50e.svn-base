package com.sas.sanction.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


/**
 * The persistent class for the matching_attribute_config database table.
 * 
 */
@Entity
@Table(name="matching_attribute_config")
@NamedQuery(name="MatchingAttributeConfig.findAll", query="SELECT m FROM MatchingAttributeConfig m")
public class MatchingAttributeConfig extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Type(type="int")
	@GenericGenerator(name="mac",strategy="increment")
	@GeneratedValue(generator="mac")
	@Column(name="mac_sno")
	private int macSno;

	@Column(name="match_strength")
	private String matchStrength;

	@Column(name="match_type")
	private String matchType;

	@Column(name="request_attribute_name")
	private String requestAttributeName;

	//bi-directional many-to-one association to MatchingAttributeConfigVersion
	@OneToMany(mappedBy="matchingAttributeConfig")
	private List<MatchingAttributeConfigVersion> matchingAttributeConfigVersions;

	public MatchingAttributeConfig() {
	}

	public int getMacSno() {
		return this.macSno;
	}

	public void setMacSno(int macSno) {
		this.macSno = macSno;
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

	public List<MatchingAttributeConfigVersion> getMatchingAttributeConfigVersions() {
		return this.matchingAttributeConfigVersions;
	}

	public void setMatchingAttributeConfigVersions(List<MatchingAttributeConfigVersion> matchingAttributeConfigVersions) {
		this.matchingAttributeConfigVersions = matchingAttributeConfigVersions;
	}

	public MatchingAttributeConfigVersion addMatchingAttributeConfigVersion(MatchingAttributeConfigVersion matchingAttributeConfigVersion) {
		getMatchingAttributeConfigVersions().add(matchingAttributeConfigVersion);
		matchingAttributeConfigVersion.setMatchingAttributeConfig(this);

		return matchingAttributeConfigVersion;
	}

	public MatchingAttributeConfigVersion removeMatchingAttributeConfigVersion(MatchingAttributeConfigVersion matchingAttributeConfigVersion) {
		getMatchingAttributeConfigVersions().remove(matchingAttributeConfigVersion);
		matchingAttributeConfigVersion.setMatchingAttributeConfig(null);

		return matchingAttributeConfigVersion;
	}

}