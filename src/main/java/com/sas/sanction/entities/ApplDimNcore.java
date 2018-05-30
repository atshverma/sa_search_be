package com.sas.sanction.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the appl_dim_ncore database table.
 * 
 */
@Entity
@Table(name="appl_dim_ncore", schema="rskncore")
@NamedQuery(name="ApplDimNcore.findAll", query="SELECT a FROM ApplDimNcore a")
public class ApplDimNcore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="APPL_SNO")
	private long applSno;

	@Column(name="ACC_NUM")
	private String accNum;

	@Column(name="ANNUAL_INCOME")
	private double annualIncome;

	@Column(name="APPL_APPROVAL_REJECT_DTTM")
	private Timestamp applApprovalRejectDttm;

	@Column(name="APPL_FULL_NAME")
	private String applFullName;

	@Column(name="APPL_IDENTIFICATION_ID")
	private String applIdentificationId;

	@Column(name="APPL_IDENTIFICATION_TYP")
	private String applIdentificationTyp;

	@Column(name="APPL_MOD_DTTM")
	private Timestamp applModDttm;

	@Column(name="APPL_NUM")
	private String applNum;

	@Column(name="APPL_REQUEST_DTTM")
	private Timestamp applRequestDttm;

	@Column(name="APPL_STATUS_CAT")
	private String applStatusCat;

	@Column(name="APPL_STATUS_SUB_CAT")
	private String applStatusSubCat;

	@Column(name="APPL_TYP")
	private String applTyp;

	@Column(name="APPROVED_BY_USER_ID")
	private String approvedByUserId;

	@Column(name="CHANNEL_ID")
	private String channelId;

	@Column(name="CHANNEL_NAME")
	private String channelName;

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

	@Column(name="CUST_NUM")
	private String custNum;

	@Column(name="DESIGNATION")
	private String designation;

	@Column(name="DOB")
	private Date dob;

	@Column(name="EMAIL_ID")
	private String emailId;

	@Column(name="EMPLOYER_CAT")
	private String employerCat;

	@Column(name="EMPLOYER_NAME")
	private String employerName;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="FOURTH_NAME")
	private String fourthName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="LINKED_ACC_NUM")
	private String linkedAccNum;

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

	@Column(name="MONTHLY_SALARY")
	private double monthlySalary;

	@Column(name="NATIONALITY")
	private String nationality;

	@Column(name="OCCUPATION")
	private String occupation;

	@Column(name="OCCUPATION_TYPE")
	private String occupationType;

	@Column(name="OFFICE_CONTACT_NUMBER")
	private double officeContactNumber;

	@Column(name="PERIOD_OF_SERVICE")
	private String periodOfService;

	@Column(name="REJECTED_BY_USER_ID")
	private String rejectedByUserId;

	@Column(name="RESIDENT_ID")
	private String residentId;

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

	@Column(name="SECOND_NAME")
	private String secondName;

	@Column(name="THIRD_NAME")
	private String thirdName;
	
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

	public ApplDimNcore() {
	}

	public long getApplSno() {
		return this.applSno;
	}

	public void setApplSno(long applSno) {
		this.applSno = applSno;
	}

	public String getAccNum() {
		return this.accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public double getAnnualIncome() {
		return this.annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public Timestamp getApplApprovalRejectDttm() {
		return this.applApprovalRejectDttm;
	}

	public void setApplApprovalRejectDttm(Timestamp applApprovalRejectDttm) {
		this.applApprovalRejectDttm = applApprovalRejectDttm;
	}

	public String getApplFullName() {
		return this.applFullName;
	}

	public void setApplFullName(String applFullName) {
		this.applFullName = applFullName;
	}

	public String getApplIdentificationId() {
		return this.applIdentificationId;
	}

	public void setApplIdentificationId(String applIdentificationId) {
		this.applIdentificationId = applIdentificationId;
	}

	public String getApplIdentificationTyp() {
		return this.applIdentificationTyp;
	}

	public void setApplIdentificationTyp(String applIdentificationTyp) {
		this.applIdentificationTyp = applIdentificationTyp;
	}

	public Timestamp getApplModDttm() {
		return this.applModDttm;
	}

	public void setApplModDttm(Timestamp applModDttm) {
		this.applModDttm = applModDttm;
	}

	public String getApplNum() {
		return this.applNum;
	}

	public void setApplNum(String applNum) {
		this.applNum = applNum;
	}

	public Timestamp getApplRequestDttm() {
		return this.applRequestDttm;
	}

	public void setApplRequestDttm(Timestamp applRequestDttm) {
		this.applRequestDttm = applRequestDttm;
	}

	public String getApplStatusCat() {
		return this.applStatusCat;
	}

	public void setApplStatusCat(String applStatusCat) {
		this.applStatusCat = applStatusCat;
	}

	public String getApplStatusSubCat() {
		return this.applStatusSubCat;
	}

	public void setApplStatusSubCat(String applStatusSubCat) {
		this.applStatusSubCat = applStatusSubCat;
	}

	public String getApplTyp() {
		return this.applTyp;
	}

	public void setApplTyp(String applTyp) {
		this.applTyp = applTyp;
	}

	public String getApprovedByUserId() {
		return this.approvedByUserId;
	}

	public void setApprovedByUserId(String approvedByUserId) {
		this.approvedByUserId = approvedByUserId;
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

	public String getCustNum() {
		return this.custNum;
	}

	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

	public String getEmployerCat() {
		return this.employerCat;
	}

	public void setEmployerCat(String employerCat) {
		this.employerCat = employerCat;
	}

	public String getEmployerName() {
		return this.employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
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

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLinkedAccNum() {
		return this.linkedAccNum;
	}

	public void setLinkedAccNum(String linkedAccNum) {
		this.linkedAccNum = linkedAccNum;
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

	public double getMonthlySalary() {
		return this.monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getOccupationType() {
		return this.occupationType;
	}

	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}

	public double getOfficeContactNumber() {
		return this.officeContactNumber;
	}

	public void setOfficeContactNumber(double officeContactNumber) {
		this.officeContactNumber = officeContactNumber;
	}

	public String getPeriodOfService() {
		return this.periodOfService;
	}

	public void setPeriodOfService(String periodOfService) {
		this.periodOfService = periodOfService;
	}

	public String getRejectedByUserId() {
		return this.rejectedByUserId;
	}

	public void setRejectedByUserId(String rejectedByUserId) {
		this.rejectedByUserId = rejectedByUserId;
	}

	public String getResidentId() {
		return this.residentId;
	}

	public void setResidentId(String residentId) {
		this.residentId = residentId;
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

	public String getSecondName() {
		return this.secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getThirdName() {
		return this.thirdName;
	}

	public void setThirdName(String thirdName) {
		this.thirdName = thirdName;
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