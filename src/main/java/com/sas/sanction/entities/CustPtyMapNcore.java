package com.sas.sanction.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cust_pty_map_ncore", schema="rskncore")
public class CustPtyMapNcore 
{
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "MAP_ID")
	private int mapId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUST_SNO")
	private CustDimNcore custDimNcore;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RELATED_PARTY_SNO")
	private ExtPartyDimNcore extPartyDimNcore;
	
	@Column(name = "RELATIONSHIP_CD")
	private String relationshipCode;
	
	@Column(name = "RELATIONSHIP_CD_DESC")
	private String relationshipCodeDescription;
	
	@Column(name = "RELATED_PARTY_CUSTOMER_FLAG")
	private String relatedPartyCustomerFlag;
	
	@Column(name = "CREATED_DTTM")
	private Timestamp createdDtTm;
	
	@Column(name = "CREATED_DT")
	private Date createdDt;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "UPDTD_DTTM")
	private Timestamp updatedDtTm;
	
	@Column(name = "UPDTD_DT")
	private Date updatedDt;
	
	@Column(name = "UPDTD_BY")
	private String updatedBy;
	

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public CustDimNcore getCustDimNcore() {
		return custDimNcore;
	}

	public void setCustDimNcore(CustDimNcore custDimNcore) {
		this.custDimNcore = custDimNcore;
	}

	public ExtPartyDimNcore getExtPartyDimNcore() {
		return extPartyDimNcore;
	}

	public void setExtPartyDimNcore(ExtPartyDimNcore extPartyDimNcore) {
		this.extPartyDimNcore = extPartyDimNcore;
	}

	public String getRelationshipCode() {
		return relationshipCode;
	}

	public void setRelationshipCode(String relationshipCode) {
		this.relationshipCode = relationshipCode;
	}

	public String getRelationshipCodeDescription() {
		return relationshipCodeDescription;
	}

	public void setRelationshipCodeDescription(String relationshipCodeDescription) {
		this.relationshipCodeDescription = relationshipCodeDescription;
	}

	public String getRelatedPartyCustomerFlag() {
		return relatedPartyCustomerFlag;
	}

	public void setRelatedPartyCustomerFlag(String relatedPartyCustomerFlag) {
		this.relatedPartyCustomerFlag = relatedPartyCustomerFlag;
	}

	public Timestamp getCreatedDtTm() {
		return createdDtTm;
	}

	public void setCreatedDtTm(Timestamp createdDtTm) {
		this.createdDtTm = createdDtTm;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getUpdatedDtTm() {
		return updatedDtTm;
	}

	public void setUpdatedDtTm(Timestamp updatedDtTm) {
		this.updatedDtTm = updatedDtTm;
	}

	public Date getUpdatedDt() {
		return updatedDt;
	}

	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
