package com.sas.sanction.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the acc_dim_ncore database table.
 * 
 */
@Entity
@Table(name="acc_dim_ncore", schema="rskncore")
@NamedQuery(name="AccDimNcore.findAll", query="SELECT a FROM AccDimNcore a")
public class AccDimNcore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACC_SNO")
	private long accSno;

	@Column(name="ACC_CLOSE_DT")
	private Date accCloseDt;

	@Column(name="ACC_CURR_CD")
	private String accCurrCd;

	@Column(name="ACC_CURR_NAME")
	private String accCurrName;

	@Column(name="ACC_NAME")
	private String accName;

	@Column(name="ACC_NUM")
	private String accNum;

	@Column(name="ACC_OPEN_BRANCH_NAME")
	private String accOpenBranchName;

	@Column(name="ACC_OPEN_DT")
	private Date accOpenDt;

	@Column(name="ACC_STATUS")
	private String accStatus;

	@Column(name="ACC_SUB_TYP")
	private String accSubTyp;

	@Column(name="ACC_TYP")
	private String accTyp;

	@Column(name="DORMANT_IND")
	private String dormantInd;

	@Column(name="LAST_DORMANT_DT")
	private Date lastDormantDt;

	@Column(name="LINKED_ACC_NUM")
	private String linkedAccNum;

	@Column(name="LINKED_ACC_RELATION")
	private String linkedAccRelation;

	@Column(name="MAILING_ADDR_CITY")
	private String mailingAddrCity;

	@Column(name="MAILING_ADDR_CNTRY_CD")
	private String mailingAddrCntryCd;

	@Column(name="MAILING_ADDR_CNTRY_NAME")
	private String mailingAddrCntryName;

	@Column(name="MAILING_ADDR_LINE_1")
	private String mailingAddrLine1;

	@Column(name="MAILING_ADDR_LINE_2")
	private String mailingAddrLine2;

	@Column(name="MAILING_ADDR_LINE_3")
	private String mailingAddrLine3;

	@Column(name="MAILING_ADDR_POSTAL_CD")
	private String mailingAddrPostalCd;

	@Column(name="MAILING_ADDR_STATE")
	private String mailingAddrState;

	@Column(name="MATURITY_DT")
	private Date maturityDt;

	@Column(name="ORIGINAL_LOAN_AMT_VAL")
	private double originalLoanAmtVal;

	@Column(name="PRODUCT_CAT_NAME")
	private String productCatName;

	@Column(name="PRODUCT_SUB_CAT_CD_1")
	private String productSubCatCd1;

	@Column(name="PRODUCT_SUB_CAT_CD_2")
	private String productSubCatCd2;

	@Column(name="SEGMENT_NAME")
	private String segmentName;

	@Column(name="TAX_ID")
	private String taxId;

	//bi-directional many-to-one association to NonFinTranFactNcore
	@OneToMany(mappedBy="accDimNcore")
	private List<NonFinTranFactNcore> nonFinTranFactNcores;
	
	@OneToMany(mappedBy = "accDimNcore")
	private List<FinTranFactNcore> finTranFactNcores;
	
	@ManyToMany(mappedBy = "accDimNcores")
	private Set<CustDimNcore> custDimNcores = new HashSet<>();
	
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
	

	public AccDimNcore() {
	}

	public long getAccSno() {
		return this.accSno;
	}

	public void setAccSno(long accSno) {
		this.accSno = accSno;
	}

	public Date getAccCloseDt() {
		return this.accCloseDt;
	}

	public void setAccCloseDt(Date accCloseDt) {
		this.accCloseDt = accCloseDt;
	}

	public String getAccCurrCd() {
		return this.accCurrCd;
	}

	public void setAccCurrCd(String accCurrCd) {
		this.accCurrCd = accCurrCd;
	}

	public String getAccCurrName() {
		return this.accCurrName;
	}

	public void setAccCurrName(String accCurrName) {
		this.accCurrName = accCurrName;
	}

	public String getAccName() {
		return this.accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccNum() {
		return this.accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getAccOpenBranchName() {
		return this.accOpenBranchName;
	}

	public void setAccOpenBranchName(String accOpenBranchName) {
		this.accOpenBranchName = accOpenBranchName;
	}

	public Date getAccOpenDt() {
		return this.accOpenDt;
	}

	public void setAccOpenDt(Date accOpenDt) {
		this.accOpenDt = accOpenDt;
	}

	public String getAccStatus() {
		return this.accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public String getAccSubTyp() {
		return this.accSubTyp;
	}

	public void setAccSubTyp(String accSubTyp) {
		this.accSubTyp = accSubTyp;
	}

	public String getAccTyp() {
		return this.accTyp;
	}

	public void setAccTyp(String accTyp) {
		this.accTyp = accTyp;
	}

	public String getDormantInd() {
		return this.dormantInd;
	}

	public void setDormantInd(String dormantInd) {
		this.dormantInd = dormantInd;
	}

	public Date getLastDormantDt() {
		return this.lastDormantDt;
	}

	public void setLastDormantDt(Date lastDormantDt) {
		this.lastDormantDt = lastDormantDt;
	}

	public String getLinkedAccNum() {
		return this.linkedAccNum;
	}

	public void setLinkedAccNum(String linkedAccNum) {
		this.linkedAccNum = linkedAccNum;
	}

	public String getLinkedAccRelation() {
		return this.linkedAccRelation;
	}

	public void setLinkedAccRelation(String linkedAccRelation) {
		this.linkedAccRelation = linkedAccRelation;
	}

	public String getMailingAddrCity() {
		return this.mailingAddrCity;
	}

	public void setMailingAddrCity(String mailingAddrCity) {
		this.mailingAddrCity = mailingAddrCity;
	}

	public String getMailingAddrCntryCd() {
		return this.mailingAddrCntryCd;
	}

	public void setMailingAddrCntryCd(String mailingAddrCntryCd) {
		this.mailingAddrCntryCd = mailingAddrCntryCd;
	}

	public String getMailingAddrCntryName() {
		return this.mailingAddrCntryName;
	}

	public void setMailingAddrCntryName(String mailingAddrCntryName) {
		this.mailingAddrCntryName = mailingAddrCntryName;
	}

	public String getMailingAddrLine1() {
		return this.mailingAddrLine1;
	}

	public void setMailingAddrLine1(String mailingAddrLine1) {
		this.mailingAddrLine1 = mailingAddrLine1;
	}

	public String getMailingAddrLine2() {
		return this.mailingAddrLine2;
	}

	public void setMailingAddrLine2(String mailingAddrLine2) {
		this.mailingAddrLine2 = mailingAddrLine2;
	}

	public String getMailingAddrLine3() {
		return this.mailingAddrLine3;
	}

	public void setMailingAddrLine3(String mailingAddrLine3) {
		this.mailingAddrLine3 = mailingAddrLine3;
	}

	public String getMailingAddrPostalCd() {
		return this.mailingAddrPostalCd;
	}

	public void setMailingAddrPostalCd(String mailingAddrPostalCd) {
		this.mailingAddrPostalCd = mailingAddrPostalCd;
	}

	public String getMailingAddrState() {
		return this.mailingAddrState;
	}

	public void setMailingAddrState(String mailingAddrState) {
		this.mailingAddrState = mailingAddrState;
	}

	public Date getMaturityDt() {
		return this.maturityDt;
	}

	public void setMaturityDt(Date maturityDt) {
		this.maturityDt = maturityDt;
	}

	public double getOriginalLoanAmtVal() {
		return this.originalLoanAmtVal;
	}

	public void setOriginalLoanAmtVal(double originalLoanAmtVal) {
		this.originalLoanAmtVal = originalLoanAmtVal;
	}

	public String getProductCatName() {
		return this.productCatName;
	}

	public void setProductCatName(String productCatName) {
		this.productCatName = productCatName;
	}

	public String getProductSubCatCd1() {
		return this.productSubCatCd1;
	}

	public void setProductSubCatCd1(String productSubCatCd1) {
		this.productSubCatCd1 = productSubCatCd1;
	}

	public String getProductSubCatCd2() {
		return this.productSubCatCd2;
	}

	public void setProductSubCatCd2(String productSubCatCd2) {
		this.productSubCatCd2 = productSubCatCd2;
	}

	public String getSegmentName() {
		return this.segmentName;
	}

	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}

	public String getTaxId() {
		return this.taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public List<NonFinTranFactNcore> getNonFinTranFactNcores() {
		return this.nonFinTranFactNcores;
	}

	public void setNonFinTranFactNcores(List<NonFinTranFactNcore> nonFinTranFactNcores) {
		this.nonFinTranFactNcores = nonFinTranFactNcores;
	}

	public List<FinTranFactNcore> getFinTranFactNcores() {
		return this.finTranFactNcores;
	}

	public void setFinTranFactNcores(List<FinTranFactNcore> finTranFactNcores) {
		this.finTranFactNcores = finTranFactNcores;
	}

	public FinTranFactNcore addFinTranFactNcore(FinTranFactNcore finTranFactNcore) {
		getFinTranFactNcores().add(finTranFactNcore);
		finTranFactNcore.setAccDimNcore(this);

		return finTranFactNcore;
	}

	public FinTranFactNcore removeFinTranFactNcore(FinTranFactNcore finTranFactNcore) {
		getFinTranFactNcores().remove(finTranFactNcore);
		finTranFactNcore.setAccDimNcore(null);

		return finTranFactNcore;
	}
	
	public NonFinTranFactNcore addNonFinTranFactNcore(NonFinTranFactNcore nonFinTranFactNcore)
	{
		getNonFinTranFactNcores().add(nonFinTranFactNcore);
		nonFinTranFactNcore.setAccDimNcore(this);
		return nonFinTranFactNcore;
	}
	
	public NonFinTranFactNcore removeNonFinTranFactNcore(NonFinTranFactNcore nonFinTranFactNcore)
	{
		getNonFinTranFactNcores().remove(nonFinTranFactNcore);
		nonFinTranFactNcore.setAccDimNcore(null);
		return nonFinTranFactNcore;
	}

	public Set<CustDimNcore> getCustDimNcores() {
		return custDimNcores;
	}

	public void setCustDimNcores(Set<CustDimNcore> custDimNcores) {
		this.custDimNcores = custDimNcores;
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