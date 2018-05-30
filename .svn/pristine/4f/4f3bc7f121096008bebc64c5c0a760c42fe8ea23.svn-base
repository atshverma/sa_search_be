package com.sas.sanction.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the tran_dim_ncore database table.
 * 
 */
@Entity
@Table(name="tran_dim_ncore", schema="rskncore")
@NamedQuery(name="TranDimNcore.findAll", query="SELECT t FROM TranDimNcore t")
public class TranDimNcore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="txnsno", strategy="increment")
	@GeneratedValue(generator="txnsno")
	@Column(name="TXN_SNO")
	private long txnSno;

	@Column(name="CHANNEL_ID")
	private String channelId;

	@Column(name="CHANNEL_NAME")
	private String channelName;

	@Column(name="NARRATIVE_1")
	private String narrative1;

	@Column(name="NARRATIVE_2")
	private String narrative2;

	@Column(name="NARRATIVE_3")
	private String narrative3;

	@Column(name="TXN_PTRN_NUM")
	private String txnPtrnNum;

	@Column(name="TXN_REF_NUM")
	private String txnRefNum;

	@Column(name="TXN_STATUS")
	private String txnStatus;

	//bi-directional one-to-one association to NonFinTranFactNcore
	@OneToOne(mappedBy = "tranDimNcore", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private NonFinTranFactNcore nonFinTranFactNcore;

	@OneToOne(mappedBy = "tranDimNcore")
	private FinTranFactNcore finTranFactNcore;
	
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

	public TranDimNcore() {
	}

	public long getTxnSno() {
		return this.txnSno;
	}

	public void setTxnSno(long txnSno) {
		this.txnSno = txnSno;
	}

	public String getChannelId() {
		return this.channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return this.channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getNarrative1() {
		return this.narrative1;
	}

	public void setNarrative1(String narrative1) {
		this.narrative1 = narrative1;
	}

	public String getNarrative2() {
		return this.narrative2;
	}

	public void setNarrative2(String narrative2) {
		this.narrative2 = narrative2;
	}

	public String getNarrative3() {
		return this.narrative3;
	}

	public void setNarrative3(String narrative3) {
		this.narrative3 = narrative3;
	}

	public String getTxnPtrnNum() {
		return this.txnPtrnNum;
	}

	public void setTxnPtrnNum(String txnPtrnNum) {
		this.txnPtrnNum = txnPtrnNum;
	}

	public String getTxnRefNum() {
		return this.txnRefNum;
	}

	public void setTxnRefNum(String txnRefNum) {
		this.txnRefNum = txnRefNum;
	}

	public String getTxnStatus() {
		return this.txnStatus;
	}

	public void setTxnStatus(String txnStatus) {
		this.txnStatus = txnStatus;
	}

	public NonFinTranFactNcore getNonFinTranFactNcore() {
		return this.nonFinTranFactNcore;
	}

	public void setNonFinTranFactNcore(NonFinTranFactNcore nonFinTranFactNcore) {
		this.nonFinTranFactNcore = nonFinTranFactNcore;
	}

	public FinTranFactNcore getFinTranFactNcore() {
		return finTranFactNcore;
	}

	public void setFinTranFactNcore(FinTranFactNcore finTranFactNcore) {
		this.finTranFactNcore = finTranFactNcore;
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