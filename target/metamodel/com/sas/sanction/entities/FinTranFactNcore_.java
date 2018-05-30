package com.sas.sanction.entities;

import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FinTranFactNcore.class)
public abstract class FinTranFactNcore_ {

	public static volatile SingularAttribute<FinTranFactNcore, CustDimNcore> custDimNcore;
	public static volatile SingularAttribute<FinTranFactNcore, Double> transactionAmountLocalCurrency;
	public static volatile SingularAttribute<FinTranFactNcore, Timestamp> updatedDtTm;
	public static volatile SingularAttribute<FinTranFactNcore, Double> transactionDestinationCountryNumber;
	public static volatile SingularAttribute<FinTranFactNcore, Date> transactionExecutedDate;
	public static volatile SingularAttribute<FinTranFactNcore, String> customerNumber;
	public static volatile SingularAttribute<FinTranFactNcore, Double> transactionAmountAccountCurrency;
	public static volatile SingularAttribute<FinTranFactNcore, String> updatedBy;
	public static volatile SingularAttribute<FinTranFactNcore, String> accountNumber;
	public static volatile SingularAttribute<FinTranFactNcore, Integer> sNumber;
	public static volatile SingularAttribute<FinTranFactNcore, ExtPartyDimNcore> extParyDimNcore;
	public static volatile SingularAttribute<FinTranFactNcore, Character> creditDebitFlag;
	public static volatile SingularAttribute<FinTranFactNcore, Double> transactionOriginatingCountryNumber;
	public static volatile SingularAttribute<FinTranFactNcore, java.sql.Date> updatedDt;
	public static volatile SingularAttribute<FinTranFactNcore, Date> transactionPostedTime;
	public static volatile SingularAttribute<FinTranFactNcore, TranDimNcore> tranDimNcore;
	public static volatile SingularAttribute<FinTranFactNcore, Double> secondaryAccountSNumber;
	public static volatile SingularAttribute<FinTranFactNcore, Date> transactionExecutedTime;
	public static volatile SingularAttribute<FinTranFactNcore, StaffDimNcore> staffDimNcore;
	public static volatile SingularAttribute<FinTranFactNcore, Timestamp> createdDtTm;
	public static volatile SingularAttribute<FinTranFactNcore, BranchDimNcore> branchDimNcore;
	public static volatile SingularAttribute<FinTranFactNcore, Character> relatedInd;
	public static volatile SingularAttribute<FinTranFactNcore, String> createdBy;
	public static volatile SingularAttribute<FinTranFactNcore, AccDimNcore> accDimNcore;
	public static volatile SingularAttribute<FinTranFactNcore, Double> transactionAmountTransactionCurrency;
	public static volatile SingularAttribute<FinTranFactNcore, Date> transactionPostedDate;
	public static volatile SingularAttribute<FinTranFactNcore, TxnFactNcore> txnFactNcore;
	public static volatile SingularAttribute<FinTranFactNcore, java.sql.Date> createdDt;
	public static volatile SingularAttribute<FinTranFactNcore, CntryCurrLkpNcore> cntryCurrLkpNcore;

}

