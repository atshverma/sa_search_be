package com.sas.sanction.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the matching_attribute_lookup database table.
 * 
 */
@Entity
@Table(name="matching_attribute_lookup")
@NamedQuery(name="MatchingAttributeLookup.findAll", query="SELECT m FROM MatchingAttributeLookup m")
public class MatchingAttributeLookup  extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mal_sno")
	private int malSno;

	@Column(name="field_name")
	private String fieldName;

	public MatchingAttributeLookup() {
	}

	public int getMalSno() {
		return this.malSno;
	}

	public void setMalSno(int malSno) {
		this.malSno = malSno;
	}


	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

}