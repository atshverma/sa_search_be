package com.sas.sanction.entities;

import java.sql.Date;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExtPartyDimNcore.class)
public abstract class ExtPartyDimNcore_ {

	public static volatile SingularAttribute<ExtPartyDimNcore, Long> extPartySno;
	public static volatile SingularAttribute<ExtPartyDimNcore, Timestamp> updatedDtTm;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> cntryOfCitizenship2Name;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> addrCntryName;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> cntryOfResidencyName;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> updatedBy;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> cntryOfCitizenship1Cd;
	public static volatile SingularAttribute<ExtPartyDimNcore, Double> annualIncome;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> segmentName;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> emailId;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> extPartyNum;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> pepFlag;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> addrCity;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> secondName;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> addrCntryCd;
	public static volatile SingularAttribute<ExtPartyDimNcore, Date> updatedDt;
	public static volatile ListAttribute<ExtPartyDimNcore, FinTranFactNcore> finTranFactNcores;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> cntryOfCitizenship1Name;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> extPartySubCat;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> firstName;
	public static volatile ListAttribute<ExtPartyDimNcore, NonFinTranFactNcore> nonFinTranFactNcores;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> lastName;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> orgRegisterationNum;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> cntryOfCitizenship2Cd;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> riskCat;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> idNum1;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> orgName;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> addrState;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> riskSubCat;
	public static volatile SingularAttribute<ExtPartyDimNcore, Timestamp> createdDtTm;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> addrLine1;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> fourthName;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> thirdName;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> addrLine2;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> addrPostalCd;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> addrLine3;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> extPartyCat;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> createdBy;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> contactNum;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> idTyp1;
	public static volatile SingularAttribute<ExtPartyDimNcore, java.util.Date> dob;
	public static volatile SingularAttribute<ExtPartyDimNcore, Double> netWorthVal;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> fullName;
	public static volatile SetAttribute<ExtPartyDimNcore, CustDimNcore> custDimNcores;
	public static volatile SingularAttribute<ExtPartyDimNcore, Date> createdDt;
	public static volatile SingularAttribute<ExtPartyDimNcore, String> cntryOfResidencyCd;

}

