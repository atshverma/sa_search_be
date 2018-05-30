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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cust_acc_map_ncore", schema="rskncore")
public class CustAccMapNcore
{
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "MAP_ID")
	private int mapId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ACC_SNO")
	private AccDimNcore accDimNcore;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUST_SNO")
	private CustDimNcore custDimNcore;
	
	@Column(name = "ACC_OWNERSHIP_CAT")
	private String accOwnershipCat;
	
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
	public AccDimNcore getAccDimNcore() {
		return accDimNcore;
	}
	public void setAccDimNcore(AccDimNcore accDimNcore) {
		this.accDimNcore = accDimNcore;
	}
	public CustDimNcore getCustDimNcore() {
		return custDimNcore;
	}
	public void setCustDimNcore(CustDimNcore custDimNcore) {
		this.custDimNcore = custDimNcore;
	}
	public String getAccOwnershipCat() {
		return accOwnershipCat;
	}
	public void setAccOwnershipCat(String accOwnershipCat) {
		this.accOwnershipCat = accOwnershipCat;
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
