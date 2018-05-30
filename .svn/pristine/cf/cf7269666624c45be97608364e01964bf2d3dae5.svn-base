package com.sas.sanction.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the branch_dim_ncore database table.
 * 
 */
@Entity
@Table(name="branch_dim_ncore", schema="rskncore")
@NamedQuery(name="BranchDimNcore.findAll", query="SELECT b FROM BranchDimNcore b")
public class BranchDimNcore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BRANCH_SNO")
	private long branchSno;

	@Column(name="ADDR_CITY")
	private String addrCity;

	@Column(name="ADDR_CNTRY_CD")
	private String addrCntryCd;

	@Column(name="ADDR_CNTRY_NAME")
	private String addrCntryName;

	@Column(name="ADDR_LINE_1")
	private String addrLine1;

	@Column(name="ADDR_LINE_2")
	private String addrLine2;

	@Column(name="ADDR_LINE_3")
	private String addrLine3;

	@Column(name="ADDR_POSTAL_CD")
	private String addrPostalCd;

	@Column(name="ADDR_STATE")
	private String addrState;

	@Column(name="BRANCH_CAT")
	private String branchCat;

	@Column(name="BRANCH_CONTACT_NAME")
	private String branchContactName;

	@Column(name="BRANCH_CONTACT_NUM")
	private double branchContactNum;

	@Column(name="BRANCH_NAME")
	private String branchName;

	@Column(name="BRANCH_NUM")
	private String branchNum;

	@Column(name="BRANCH_SUB_CAT")
	private String branchSubCat;

	@Column(name="SEGMENT_NAME")
	private String segmentName;

	//bi-directional many-to-one association to NonFinTranFactNcore
	@OneToMany(mappedBy="branchDimNcore")
	private List<NonFinTranFactNcore> nonFinTranFactNcores;

	@OneToMany(mappedBy="branchDimNcore")
	private List<FinTranFactNcore> finTranFactNcores;
	
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

	public BranchDimNcore() {
	}

	public long getBranchSno() {
		return this.branchSno;
	}

	public void setBranchSno(long branchSno) {
		this.branchSno = branchSno;
	}

	public String getAddrCity() {
		return this.addrCity;
	}

	public void setAddrCity(String addrCity) {
		this.addrCity = addrCity;
	}

	public String getAddrCntryCd() {
		return this.addrCntryCd;
	}

	public void setAddrCntryCd(String addrCntryCd) {
		this.addrCntryCd = addrCntryCd;
	}

	public String getAddrCntryName() {
		return this.addrCntryName;
	}

	public void setAddrCntryName(String addrCntryName) {
		this.addrCntryName = addrCntryName;
	}

	public String getAddrLine1() {
		return this.addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return this.addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}

	public String getAddrLine3() {
		return this.addrLine3;
	}

	public void setAddrLine3(String addrLine3) {
		this.addrLine3 = addrLine3;
	}

	public String getAddrPostalCd() {
		return this.addrPostalCd;
	}

	public void setAddrPostalCd(String addrPostalCd) {
		this.addrPostalCd = addrPostalCd;
	}

	public String getAddrState() {
		return this.addrState;
	}

	public void setAddrState(String addrState) {
		this.addrState = addrState;
	}

	public String getBranchCat() {
		return this.branchCat;
	}

	public void setBranchCat(String branchCat) {
		this.branchCat = branchCat;
	}

	public String getBranchContactName() {
		return this.branchContactName;
	}

	public void setBranchContactName(String branchContactName) {
		this.branchContactName = branchContactName;
	}

	public double getBranchContactNum() {
		return this.branchContactNum;
	}

	public void setBranchContactNum(double branchContactNum) {
		this.branchContactNum = branchContactNum;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchNum() {
		return this.branchNum;
	}

	public void setBranchNum(String branchNum) {
		this.branchNum = branchNum;
	}

	public String getBranchSubCat() {
		return this.branchSubCat;
	}

	public void setBranchSubCat(String branchSubCat) {
		this.branchSubCat = branchSubCat;
	}

	public String getSegmentName() {
		return this.segmentName;
	}

	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}

	public List<NonFinTranFactNcore> getNonFinTranFactNcores() {
		return this.nonFinTranFactNcores;
	}

	public void setNonFinTranFactNcores(List<NonFinTranFactNcore> nonFinTranFactNcores) {
		this.nonFinTranFactNcores = nonFinTranFactNcores;
	}

	public NonFinTranFactNcore addNonFinTranFactNcore(NonFinTranFactNcore nonFinTranFactNcore) {
		getNonFinTranFactNcores().add(nonFinTranFactNcore);
		nonFinTranFactNcore.setBranchDimNcore(this);

		return nonFinTranFactNcore;
	}

	public NonFinTranFactNcore removeNonFinTranFactNcore(NonFinTranFactNcore nonFinTranFactNcore) {
		getNonFinTranFactNcores().remove(nonFinTranFactNcore);
		nonFinTranFactNcore.setBranchDimNcore(null);

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
		finTranFactNcore.setBranchDimNcore(this);

		return finTranFactNcore;
	}

	public FinTranFactNcore removeFinTranFactNcore(FinTranFactNcore finTranFactNcore) {
		getFinTranFactNcores().remove(finTranFactNcore);
		finTranFactNcore.setBranchDimNcore(null);

		return finTranFactNcore;
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