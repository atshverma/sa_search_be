package com.sas.sanction.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_dt")
//	@Temporal(TemporalType.DATE)
	private java.sql.Date createdDt;

	@Column(name="created_dttm")
	private Timestamp createdDttm;
	
	@Column(name="updated_by")
	private String updatedBy;

	@Column(name="updated_dt")
	//@Temporal(TemporalType.DATE)
	private java.sql.Date updatedDt;

	@Column(name="updated_dttm")
	private Timestamp updatedDttm;

	
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDttm() {
		return createdDttm;
	}

	public void setCreatedDttm(Timestamp createdDttm) {
		this.createdDttm = createdDttm;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public java.sql.Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(java.sql.Date createdDt) {
		this.createdDt = createdDt;
	}

	public java.sql.Date getUpdatedDt() {
		return updatedDt;
	}

	public void setUpdatedDt(java.sql.Date updatedDt) {
		this.updatedDt = updatedDt;
	}

	public Timestamp getUpdatedDttm() {
		return updatedDttm;
	}

	public void setUpdatedDttm(Timestamp updatedDttm) {
		this.updatedDttm = updatedDttm;
	}

	@PreUpdate
	protected void onPreUpdate() {
		this.updatedDt = new java.sql.Date(new Date().getTime());
	}
	
	@PrePersist 
	protected void onPrePersist() {
		Date now =  new Date();
		this.createdDttm = new Timestamp(now.getTime());
		this.updatedDttm = createdDttm;
		this.createdDt = new java.sql.Date(now.getTime());
		this.updatedDt = createdDt;
	}
	
	
}
