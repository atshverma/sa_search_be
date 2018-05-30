package com.sas.sanction.entities;

import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CustDimNcore.class)
public abstract class CustDimNcore_ {

	public static volatile SingularAttribute<CustDimNcore, String> employmentTypCat;
	public static volatile SingularAttribute<CustDimNcore, Timestamp> updatedDtTm;
	public static volatile SingularAttribute<CustDimNcore, String> cntryOfCitizenship2Name;
	public static volatile SingularAttribute<CustDimNcore, String> residentialAddrState;
	public static volatile SingularAttribute<CustDimNcore, Date> lastContactDt;
	public static volatile SingularAttribute<CustDimNcore, String> cntryOfResidencyName;
	public static volatile SingularAttribute<CustDimNcore, String> org1Name;
	public static volatile SingularAttribute<CustDimNcore, String> segmentName;
	public static volatile SingularAttribute<CustDimNcore, String> emailId;
	public static volatile SingularAttribute<CustDimNcore, String> staffFlag;
	public static volatile SingularAttribute<CustDimNcore, String> org2RegistrationNum;
	public static volatile SingularAttribute<CustDimNcore, String> pepFlag;
	public static volatile SingularAttribute<CustDimNcore, java.sql.Date> updatedDt;
	public static volatile SingularAttribute<CustDimNcore, Date> lastRiskAssessmentDt;
	public static volatile SingularAttribute<CustDimNcore, Date> custSinceDt;
	public static volatile SingularAttribute<CustDimNcore, String> residentialAddrCntryName;
	public static volatile ListAttribute<CustDimNcore, NonFinTranFactNcore> nonFinTranFactNcores;
	public static volatile SingularAttribute<CustDimNcore, String> lastName;
	public static volatile SingularAttribute<CustDimNcore, String> cntryOfCitizenship2Cd;
	public static volatile SingularAttribute<CustDimNcore, String> residentialAddrPostalCd;
	public static volatile SingularAttribute<CustDimNcore, String> employmentTypSubCat;
	public static volatile SingularAttribute<CustDimNcore, String> mailingAddrPostalCd;
	public static volatile SingularAttribute<CustDimNcore, Date> lastSuspiciousTxnRptDt;
	public static volatile SingularAttribute<CustDimNcore, String> createdBy;
	public static volatile SingularAttribute<CustDimNcore, String> custCat;
	public static volatile SingularAttribute<CustDimNcore, Date> lastSuspiciousActivityRptDt;
	public static volatile SingularAttribute<CustDimNcore, String> taxId;
	public static volatile SingularAttribute<CustDimNcore, Double> contactNum1;
	public static volatile SetAttribute<CustDimNcore, AccDimNcore> accDimNcores;
	public static volatile SingularAttribute<CustDimNcore, Double> contactNum2;
	public static volatile SingularAttribute<CustDimNcore, String> cntryOfResidencyCd;
	public static volatile SingularAttribute<CustDimNcore, String> residentialAddrCntryCd;
	public static volatile SingularAttribute<CustDimNcore, String> mailingAddrState;
	public static volatile SingularAttribute<CustDimNcore, String> org1RegistrationNum;
	public static volatile SingularAttribute<CustDimNcore, String> mailingAddrCity;
	public static volatile SingularAttribute<CustDimNcore, String> maritalStatus;
	public static volatile SingularAttribute<CustDimNcore, String> updatedBy;
	public static volatile SingularAttribute<CustDimNcore, String> cntryOfCitizenship1Cd;
	public static volatile SingularAttribute<CustDimNcore, Double> annualIncome;
	public static volatile SingularAttribute<CustDimNcore, String> mailingAddrLine1;
	public static volatile SingularAttribute<CustDimNcore, String> mailingAddrLine2;
	public static volatile SingularAttribute<CustDimNcore, String> mailingAddrLine3;
	public static volatile SingularAttribute<CustDimNcore, String> residentialAddrLine2;
	public static volatile SingularAttribute<CustDimNcore, String> residentialAddrLine1;
	public static volatile SingularAttribute<CustDimNcore, String> secondName;
	public static volatile SingularAttribute<CustDimNcore, String> residentialAddrLine3;
	public static volatile ListAttribute<CustDimNcore, FinTranFactNcore> finTranFactNcores;
	public static volatile SingularAttribute<CustDimNcore, String> firstName;
	public static volatile SingularAttribute<CustDimNcore, String> cntryOfCitizenship1Name;
	public static volatile SingularAttribute<CustDimNcore, String> mailingAddrCntryName;
	public static volatile SingularAttribute<CustDimNcore, String> custSubCat;
	public static volatile SingularAttribute<CustDimNcore, String> custNum;
	public static volatile SingularAttribute<CustDimNcore, String> residentialAddrCity;
	public static volatile SingularAttribute<CustDimNcore, String> idNum2;
	public static volatile SingularAttribute<CustDimNcore, String> org2Name;
	public static volatile SingularAttribute<CustDimNcore, String> riskCat;
	public static volatile SingularAttribute<CustDimNcore, String> idNum1;
	public static volatile SingularAttribute<CustDimNcore, Timestamp> createdDtTm;
	public static volatile SingularAttribute<CustDimNcore, String> fourthName;
	public static volatile SingularAttribute<CustDimNcore, String> mailingAddrCntryCd;
	public static volatile SingularAttribute<CustDimNcore, String> thirdName;
	public static volatile SingularAttribute<CustDimNcore, Long> custSno;
	public static volatile SingularAttribute<CustDimNcore, String> idTyp2;
	public static volatile SingularAttribute<CustDimNcore, String> idTyp1;
	public static volatile SingularAttribute<CustDimNcore, Date> dob;
	public static volatile SingularAttribute<CustDimNcore, Double> netWorthVal;
	public static volatile SetAttribute<CustDimNcore, ExtPartyDimNcore> extPartyDimNcores;
	public static volatile SingularAttribute<CustDimNcore, String> fullName;
	public static volatile SingularAttribute<CustDimNcore, java.sql.Date> createdDt;

}

