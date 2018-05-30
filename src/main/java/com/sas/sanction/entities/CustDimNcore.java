package com.sas.sanction.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the cust_dim_ncore database table.
 * 
 */
@Entity
@Table(name="cust_dim_ncore", schema="rskncore")
@NamedQuery(name="CustDimNcore.findAll", query="SELECT c FROM CustDimNcore c")
public class CustDimNcore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CUST_SNO")
	private long custSno;

	@Column(name="ANNUAL_INCOME")
	private double annualIncome;

	@Column(name="CNTRY_OF_CITIZENSHIP_1_CD")
	private String cntryOfCitizenship1Cd;

	@Column(name="CNTRY_OF_CITIZENSHIP_1_NAME")
	private String cntryOfCitizenship1Name;

	@Column(name="CNTRY_OF_CITIZENSHIP_2_CD")
	private String cntryOfCitizenship2Cd;

	@Column(name="CNTRY_OF_CITIZENSHIP_2_NAME")
	private String cntryOfCitizenship2Name;

	@Column(name="CNTRY_OF_RESIDENCY_CD")
	private String cntryOfResidencyCd;

	@Column(name="CNTRY_OF_RESIDENCY_NAME")
	private String cntryOfResidencyName;

	@Column(name="CONTACT_NUM_1")
	private double contactNum1;

	@Column(name="CONTACT_NUM_2")
	private double contactNum2;

	@Column(name="CUST_CAT")
	private String custCat;

	@Column(name="CUST_NUM")
	private String custNum;

	@Column(name="CUST_SINCE_DT")
	private Date custSinceDt;

	@Column(name="CUST_SUB_CAT")
	private String custSubCat;

	@Column(name="DOB")
	private Date dob;

	@Column(name="EMAIL_ID")
	private String emailId;

	@Column(name="EMPLOYMENT_TYP_CAT")
	private String employmentTypCat;

	@Column(name="EMPLOYMENT_TYP_SUB_CAT")
	private String employmentTypSubCat;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="FOURTH_NAME")
	private String fourthName;

	@Column(name="FULL_NAME")
	private String fullName;

	@Column(name="ID_NUM_1")
	private String idNum1;

	@Column(name="ID_NUM_2")
	private String idNum2;

	@Column(name="ID_TYP_1")
	private String idTyp1;

	@Column(name="ID_TYP_2")
	private String idTyp2;

	@Column(name="LAST_CONTACT_DT")
	private Date lastContactDt;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="LAST_RISK_ASSESSMENT_DT")
	private Date lastRiskAssessmentDt;

	@Column(name="LAST_SUSPICIOUS_ACTIVITY_RPT_DT")
	private Date lastSuspiciousActivityRptDt;

	@Column(name="LAST_SUSPICIOUS_TXN_RPT_DT")
	private Date lastSuspiciousTxnRptDt;

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

	@Column(name="MARITAL_STATUS")
	private String maritalStatus;

	@Column(name="NET_WORTH_VAL")
	private double netWorthVal;

	@Column(name="ORG_1_NAME")
	private String org1Name;

	@Column(name="ORG_1_REGISTRATION_NUM")
	private String org1RegistrationNum;

	@Column(name="ORG_2_NAME")
	private String org2Name;

	@Column(name="ORG_2_REGISTRATION_NUM")
	private String org2RegistrationNum;

	@Column(name="PEP_FLAG")
	private String pepFlag;

	@Column(name="RESIDENTIAL_ADDR_CITY")
	private String residentialAddrCity;

	@Column(name="RESIDENTIAL_ADDR_CNTRY_CD")
	private String residentialAddrCntryCd;

	@Column(name="RESIDENTIAL_ADDR_CNTRY_NAME")
	private String residentialAddrCntryName;

	@Column(name="RESIDENTIAL_ADDR_LINE_1")
	private String residentialAddrLine1;

	@Column(name="RESIDENTIAL_ADDR_LINE_2")
	private String residentialAddrLine2;

	@Column(name="RESIDENTIAL_ADDR_LINE_3")
	private String residentialAddrLine3;

	@Column(name="RESIDENTIAL_ADDR_POSTAL_CD")
	private String residentialAddrPostalCd;

	@Column(name="RESIDENTIAL_ADDR_STATE")
	private String residentialAddrState;

	@Column(name="RISK_CAT")
	private String riskCat;

	@Column(name="SECOND_NAME")
	private String secondName;

	@Column(name="SEGMENT_NAME")
	private String segmentName;

	@Column(name="STAFF_FLAG")
	private String staffFlag;

	@Column(name="TAX_ID")
	private String taxId;

	@Column(name="THIRD_NAME")
	private String thirdName;

	//bi-directional many-to-one association to NonFinTranFactNcore
	@OneToMany(mappedBy="custDimNcore")
	private List<NonFinTranFactNcore> nonFinTranFactNcores;

	@OneToMany(mappedBy="custDimNcore")
	private List<FinTranFactNcore> finTranFactNcores;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "cust_acc_map_ncore",
	joinColumns = {@JoinColumn(name = "CUST_SNO")},
	inverseJoinColumns = {@JoinColumn(name = "ACC_SNO")})
	private Set<AccDimNcore> accDimNcores = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "cust_pty_map_ncore",
	joinColumns = {@JoinColumn(name = "CUST_SNO")},
	inverseJoinColumns = {@JoinColumn(name = "RELATED_PARTY_SNO")})
	private Set<ExtPartyDimNcore> extPartyDimNcores = new HashSet<>();
	
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

	
	public CustDimNcore() {
	}

	public long getCustSno() {
		return this.custSno;
	}

	public void setCustSno(long custSno) {
		this.custSno = custSno;
	}

	public double getAnnualIncome() {
		return this.annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getCntryOfCitizenship1Cd() {
		return this.cntryOfCitizenship1Cd;
	}

	public void setCntryOfCitizenship1Cd(String cntryOfCitizenship1Cd) {
		this.cntryOfCitizenship1Cd = cntryOfCitizenship1Cd;
	}

	public String getCntryOfCitizenship1Name() {
		return this.cntryOfCitizenship1Name;
	}

	public void setCntryOfCitizenship1Name(String cntryOfCitizenship1Name) {
		this.cntryOfCitizenship1Name = cntryOfCitizenship1Name;
	}

	public String getCntryOfCitizenship2Cd() {
		return this.cntryOfCitizenship2Cd;
	}

	public void setCntryOfCitizenship2Cd(String cntryOfCitizenship2Cd) {
		this.cntryOfCitizenship2Cd = cntryOfCitizenship2Cd;
	}

	public String getCntryOfCitizenship2Name() {
		return this.cntryOfCitizenship2Name;
	}

	public void setCntryOfCitizenship2Name(String cntryOfCitizenship2Name) {
		this.cntryOfCitizenship2Name = cntryOfCitizenship2Name;
	}

	public String getCntryOfResidencyCd() {
		return this.cntryOfResidencyCd;
	}

	public void setCntryOfResidencyCd(String cntryOfResidencyCd) {
		this.cntryOfResidencyCd = cntryOfResidencyCd;
	}

	public String getCntryOfResidencyName() {
		return this.cntryOfResidencyName;
	}

	public void setCntryOfResidencyName(String cntryOfResidencyName) {
		this.cntryOfResidencyName = cntryOfResidencyName;
	}

	public double getContactNum1() {
		return this.contactNum1;
	}

	public void setContactNum1(double contactNum1) {
		this.contactNum1 = contactNum1;
	}

	public double getContactNum2() {
		return this.contactNum2;
	}

	public void setContactNum2(double contactNum2) {
		this.contactNum2 = contactNum2;
	}

	public String getCustCat() {
		return this.custCat;
	}

	public void setCustCat(String custCat) {
		this.custCat = custCat;
	}

	public String getCustNum() {
		return this.custNum;
	}

	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}

	public Date getCustSinceDt() {
		return this.custSinceDt;
	}

	public void setCustSinceDt(Date custSinceDt) {
		this.custSinceDt = custSinceDt;
	}

	public String getCustSubCat() {
		return this.custSubCat;
	}

	public void setCustSubCat(String custSubCat) {
		this.custSubCat = custSubCat;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmploymentTypCat() {
		return this.employmentTypCat;
	}

	public void setEmploymentTypCat(String employmentTypCat) {
		this.employmentTypCat = employmentTypCat;
	}

	public String getEmploymentTypSubCat() {
		return this.employmentTypSubCat;
	}

	public void setEmploymentTypSubCat(String employmentTypSubCat) {
		this.employmentTypSubCat = employmentTypSubCat;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFourthName() {
		return this.fourthName;
	}

	public void setFourthName(String fourthName) {
		this.fourthName = fourthName;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIdNum1() {
		return this.idNum1;
	}

	public void setIdNum1(String idNum1) {
		this.idNum1 = idNum1;
	}

	public String getIdNum2() {
		return this.idNum2;
	}

	public void setIdNum2(String idNum2) {
		this.idNum2 = idNum2;
	}

	public String getIdTyp1() {
		return this.idTyp1;
	}

	public void setIdTyp1(String idTyp1) {
		this.idTyp1 = idTyp1;
	}

	public String getIdTyp2() {
		return this.idTyp2;
	}

	public void setIdTyp2(String idTyp2) {
		this.idTyp2 = idTyp2;
	}

	public Date getLastContactDt() {
		return this.lastContactDt;
	}

	public void setLastContactDt(Date lastContactDt) {
		this.lastContactDt = lastContactDt;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLastRiskAssessmentDt() {
		return this.lastRiskAssessmentDt;
	}

	public void setLastRiskAssessmentDt(Date lastRiskAssessmentDt) {
		this.lastRiskAssessmentDt = lastRiskAssessmentDt;
	}

	public Date getLastSuspiciousActivityRptDt() {
		return this.lastSuspiciousActivityRptDt;
	}

	public void setLastSuspiciousActivityRptDt(Date lastSuspiciousActivityRptDt) {
		this.lastSuspiciousActivityRptDt = lastSuspiciousActivityRptDt;
	}

	public Date getLastSuspiciousTxnRptDt() {
		return this.lastSuspiciousTxnRptDt;
	}

	public void setLastSuspiciousTxnRptDt(Date lastSuspiciousTxnRptDt) {
		this.lastSuspiciousTxnRptDt = lastSuspiciousTxnRptDt;
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

	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public double getNetWorthVal() {
		return this.netWorthVal;
	}

	public void setNetWorthVal(double netWorthVal) {
		this.netWorthVal = netWorthVal;
	}

	public String getOrg1Name() {
		return this.org1Name;
	}

	public void setOrg1Name(String org1Name) {
		this.org1Name = org1Name;
	}

	public String getOrg1RegistrationNum() {
		return this.org1RegistrationNum;
	}

	public void setOrg1RegistrationNum(String org1RegistrationNum) {
		this.org1RegistrationNum = org1RegistrationNum;
	}

	public String getOrg2Name() {
		return this.org2Name;
	}

	public void setOrg2Name(String org2Name) {
		this.org2Name = org2Name;
	}

	public String getOrg2RegistrationNum() {
		return this.org2RegistrationNum;
	}

	public void setOrg2RegistrationNum(String org2RegistrationNum) {
		this.org2RegistrationNum = org2RegistrationNum;
	}

	public String getPepFlag() {
		return this.pepFlag;
	}

	public void setPepFlag(String pepFlag) {
		this.pepFlag = pepFlag;
	}

	public String getResidentialAddrCity() {
		return this.residentialAddrCity;
	}

	public void setResidentialAddrCity(String residentialAddrCity) {
		this.residentialAddrCity = residentialAddrCity;
	}

	public String getResidentialAddrCntryCd() {
		return this.residentialAddrCntryCd;
	}

	public void setResidentialAddrCntryCd(String residentialAddrCntryCd) {
		this.residentialAddrCntryCd = residentialAddrCntryCd;
	}

	public String getResidentialAddrCntryName() {
		return this.residentialAddrCntryName;
	}

	public void setResidentialAddrCntryName(String residentialAddrCntryName) {
		this.residentialAddrCntryName = residentialAddrCntryName;
	}

	public String getResidentialAddrLine1() {
		return this.residentialAddrLine1;
	}

	public void setResidentialAddrLine1(String residentialAddrLine1) {
		this.residentialAddrLine1 = residentialAddrLine1;
	}

	public String getResidentialAddrLine2() {
		return this.residentialAddrLine2;
	}

	public void setResidentialAddrLine2(String residentialAddrLine2) {
		this.residentialAddrLine2 = residentialAddrLine2;
	}

	public String getResidentialAddrLine3() {
		return this.residentialAddrLine3;
	}

	public void setResidentialAddrLine3(String residentialAddrLine3) {
		this.residentialAddrLine3 = residentialAddrLine3;
	}

	public String getResidentialAddrPostalCd() {
		return this.residentialAddrPostalCd;
	}

	public void setResidentialAddrPostalCd(String residentialAddrPostalCd) {
		this.residentialAddrPostalCd = residentialAddrPostalCd;
	}

	public String getResidentialAddrState() {
		return this.residentialAddrState;
	}

	public void setResidentialAddrState(String residentialAddrState) {
		this.residentialAddrState = residentialAddrState;
	}

	public String getRiskCat() {
		return this.riskCat;
	}

	public void setRiskCat(String riskCat) {
		this.riskCat = riskCat;
	}

	public String getSecondName() {
		return this.secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getSegmentName() {
		return this.segmentName;
	}

	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}

	public String getStaffFlag() {
		return this.staffFlag;
	}

	public void setStaffFlag(String staffFlag) {
		this.staffFlag = staffFlag;
	}

	public String getTaxId() {
		return this.taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getThirdName() {
		return this.thirdName;
	}

	public void setThirdName(String thirdName) {
		this.thirdName = thirdName;
	}

	public List<NonFinTranFactNcore> getNonFinTranFactNcores() {
		return this.nonFinTranFactNcores;
	}

	public void setNonFinTranFactNcores(List<NonFinTranFactNcore> nonFinTranFactNcores) {
		this.nonFinTranFactNcores = nonFinTranFactNcores;
	}

	public NonFinTranFactNcore addNonFinTranFactNcore(NonFinTranFactNcore nonFinTranFactNcore) {
		getNonFinTranFactNcores().add(nonFinTranFactNcore);
		nonFinTranFactNcore.setCustDimNcore(this);

		return nonFinTranFactNcore;
	}

	public NonFinTranFactNcore removeNonFinTranFactNcore(NonFinTranFactNcore nonFinTranFactNcore) {
		getNonFinTranFactNcores().remove(nonFinTranFactNcore);
		nonFinTranFactNcore.setCustDimNcore(null);

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
		finTranFactNcore.setCustDimNcore(this);

		return finTranFactNcore;
	}

	public FinTranFactNcore removeFinTranFactNcore(FinTranFactNcore finTranFactNcore) {
		getFinTranFactNcores().remove(finTranFactNcore);
		finTranFactNcore.setCustDimNcore(null);

		return finTranFactNcore;
	}

	

	public Set<AccDimNcore> getAccDimNcores() {
		return accDimNcores;
	}

	public void setAccDimNcores(Set<AccDimNcore> accDimNcores) {
		this.accDimNcores = accDimNcores;
	}

	public Set<ExtPartyDimNcore> getExtPartyDimNcores() {
		return extPartyDimNcores;
	}

	public void setExtPartyDimNcores(Set<ExtPartyDimNcore> extPartyDimNcores) {
		this.extPartyDimNcores = extPartyDimNcores;
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