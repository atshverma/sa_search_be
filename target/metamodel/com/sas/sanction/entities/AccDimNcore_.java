package com.sas.sanction.entities;

import java.sql.Date;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AccDimNcore.class)
public abstract class AccDimNcore_ {

	public static volatile SingularAttribute<AccDimNcore, String> mailingAddrState;
	public static volatile SingularAttribute<AccDimNcore, String> accCurrCd;
	public static volatile SingularAttribute<AccDimNcore, String> productSubCatCd1;
	public static volatile SingularAttribute<AccDimNcore, String> productSubCatCd2;
	public static volatile SingularAttribute<AccDimNcore, Timestamp> updatedDtTm;
	public static volatile SingularAttribute<AccDimNcore, String> mailingAddrCity;
	public static volatile SingularAttribute<AccDimNcore, String> accCurrName;
	public static volatile SingularAttribute<AccDimNcore, String> updatedBy;
	public static volatile SingularAttribute<AccDimNcore, String> mailingAddrLine1;
	public static volatile SingularAttribute<AccDimNcore, String> segmentName;
	public static volatile SingularAttribute<AccDimNcore, String> mailingAddrLine2;
	public static volatile SingularAttribute<AccDimNcore, String> dormantInd;
	public static volatile SingularAttribute<AccDimNcore, String> mailingAddrLine3;
	public static volatile SingularAttribute<AccDimNcore, String> productCatName;
	public static volatile SingularAttribute<AccDimNcore, String> accStatus;
	public static volatile SingularAttribute<AccDimNcore, Date> updatedDt;
	public static volatile ListAttribute<AccDimNcore, FinTranFactNcore> finTranFactNcores;
	public static volatile SingularAttribute<AccDimNcore, String> mailingAddrCntryName;
	public static volatile ListAttribute<AccDimNcore, NonFinTranFactNcore> nonFinTranFactNcores;
	public static volatile SingularAttribute<AccDimNcore, String> accOpenBranchName;
	public static volatile SingularAttribute<AccDimNcore, java.util.Date> lastDormantDt;
	public static volatile SingularAttribute<AccDimNcore, Timestamp> createdDtTm;
	public static volatile SingularAttribute<AccDimNcore, java.util.Date> accOpenDt;
	public static volatile SingularAttribute<AccDimNcore, String> mailingAddrCntryCd;
	public static volatile SingularAttribute<AccDimNcore, Double> originalLoanAmtVal;
	public static volatile SingularAttribute<AccDimNcore, java.util.Date> maturityDt;
	public static volatile SingularAttribute<AccDimNcore, String> mailingAddrPostalCd;
	public static volatile SingularAttribute<AccDimNcore, String> createdBy;
	public static volatile SingularAttribute<AccDimNcore, String> taxId;
	public static volatile SingularAttribute<AccDimNcore, String> accNum;
	public static volatile SingularAttribute<AccDimNcore, String> accName;
	public static volatile SingularAttribute<AccDimNcore, java.util.Date> accCloseDt;
	public static volatile SingularAttribute<AccDimNcore, String> accSubTyp;
	public static volatile SingularAttribute<AccDimNcore, String> accTyp;
	public static volatile SingularAttribute<AccDimNcore, Long> accSno;
	public static volatile SetAttribute<AccDimNcore, CustDimNcore> custDimNcores;
	public static volatile SingularAttribute<AccDimNcore, String> linkedAccNum;
	public static volatile SingularAttribute<AccDimNcore, Date> createdDt;
	public static volatile SingularAttribute<AccDimNcore, String> linkedAccRelation;

}

