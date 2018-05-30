package com.sas.sanction.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the txn_fact_ncore database table.
 * 
 */
@Entity
@Table(name="txn_fact_ncore", schema="rskncore")
@NamedQuery(name="TxnFactNcore.findAll", query="SELECT t FROM TxnFactNcore t")
public class TxnFactNcore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TXN_TYP_NUM")
	private long txnTypNum;

	@Column(name="CHANNEL_MED")
	private String channelMed;

	@Column(name="CHANNEL_NAME")
	private String channelName;

	@Column(name="PRODUCT_MED")
	private String productMed;

	@Column(name="PRODUCT_NAME")
	private String productName;

	@Column(name="SERVICE_NAME")
	private String serviceName;

	@Column(name="TXN_CAT")
	private String txnCat;

	@Column(name="TXN_TYP_FLAG")
	private String txnTypFlag;

	//bi-directional many-to-one association to NonFinTranFactNcore
	@OneToMany(mappedBy="txnFactNcore")
	private List<NonFinTranFactNcore> nonFinTranFactNcores;

	@OneToMany(mappedBy="txnFactNcore")
	private List<FinTranFactNcore> finTranFactNcores;
	
	@Column(name = "CREATED_DTTM")
	private Timestamp createdDtTm;
	
	@Column(name = "CREATED_DT")
	private java.sql.Date createdDt;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "UPDTD_DTTM")
	private Timestamp updatedDtTm;
	
	@Column(name = "UPDTD_DT")
	private java.sql.Date updatedDt;
	
	@Column(name = "UPDTD_BY")
	private String updatedBy;

	public TxnFactNcore() {
	}

	public long getTxnTypNum() {
		return this.txnTypNum;
	}

	public void setTxnTypNum(long txnTypNum) {
		this.txnTypNum = txnTypNum;
	}

	public String getChannelMed() {
		return this.channelMed;
	}

	public void setChannelMed(String channelMed) {
		this.channelMed = channelMed;
	}

	public String getChannelName() {
		return this.channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getProductMed() {
		return this.productMed;
	}

	public void setProductMed(String productMed) {
		this.productMed = productMed;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getTxnCat() {
		return this.txnCat;
	}

	public void setTxnCat(String txnCat) {
		this.txnCat = txnCat;
	}

	public String getTxnTypFlag() {
		return this.txnTypFlag;
	}

	public void setTxnTypFlag(String txnTypFlag) {
		this.txnTypFlag = txnTypFlag;
	}

	public List<NonFinTranFactNcore> getNonFinTranFactNcores() {
		return this.nonFinTranFactNcores;
	}

	public void setNonFinTranFactNcores(List<NonFinTranFactNcore> nonFinTranFactNcores) {
		this.nonFinTranFactNcores = nonFinTranFactNcores;
	}

	public NonFinTranFactNcore addNonFinTranFactNcore(NonFinTranFactNcore nonFinTranFactNcore) {
		getNonFinTranFactNcores().add(nonFinTranFactNcore);
		nonFinTranFactNcore.setTxnFactNcore(this);

		return nonFinTranFactNcore;
	}

	public NonFinTranFactNcore removeNonFinTranFactNcore(NonFinTranFactNcore nonFinTranFactNcore) {
		getNonFinTranFactNcores().remove(nonFinTranFactNcore);
		nonFinTranFactNcore.setTxnFactNcore(null);

		return nonFinTranFactNcore;
	}

	public List<FinTranFactNcore> getFinTranFactNcores() {
		return this.finTranFactNcores;
	}

	public void setFinTranFactNcores(List<FinTranFactNcore> finTranFactNcores) {
		this.finTranFactNcores = finTranFactNcores;
	}

	public FinTranFactNcore addFinTranFactNcore(FinTranFactNcore finTranFactNcore) {
		getFinTranFactNcores().add(finTranFactNcore);
		finTranFactNcore.setTxnFactNcore(this);

		return finTranFactNcore;
	}

	public FinTranFactNcore removeFinTranFactNcore(FinTranFactNcore finTranFactNcore) {
		getFinTranFactNcores().remove(finTranFactNcore);
		finTranFactNcore.setTxnFactNcore(null);

		return finTranFactNcore;
	}

	public Timestamp getCreatedDtTm() {
		return createdDtTm;
	}

	public void setCreatedDtTm(Timestamp createdDtTm) {
		this.createdDtTm = createdDtTm;
	}

	public java.sql.Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(java.sql.Date createdDt) {
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

	public java.sql.Date getUpdatedDt() {
		return updatedDt;
	}

	public void setUpdatedDt(java.sql.Date updatedDt) {
		this.updatedDt = updatedDt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}