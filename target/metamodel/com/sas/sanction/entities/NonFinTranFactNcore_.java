package com.sas.sanction.entities;

import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NonFinTranFactNcore.class)
public abstract class NonFinTranFactNcore_ {

	public static volatile SingularAttribute<NonFinTranFactNcore, ExtPartyDimNcore> extPartyDimNcore;
	public static volatile SingularAttribute<NonFinTranFactNcore, CustDimNcore> custDimNcore;
	public static volatile SingularAttribute<NonFinTranFactNcore, Date> transactionExecutedDate;
	public static volatile SingularAttribute<NonFinTranFactNcore, Double> transactionDestinationCountryNumber;
	public static volatile SingularAttribute<NonFinTranFactNcore, Timestamp> updatedDtTm;
	public static volatile SingularAttribute<NonFinTranFactNcore, String> customerNumber;
	public static volatile SingularAttribute<NonFinTranFactNcore, String> secondaryAccountNumber;
	public static volatile SingularAttribute<NonFinTranFactNcore, String> updatedBy;
	public static volatile SingularAttribute<NonFinTranFactNcore, String> accountNumber;
	public static volatile SingularAttribute<NonFinTranFactNcore, Double> transactionOriginatingCountryNumber;
	public static volatile SingularAttribute<NonFinTranFactNcore, java.sql.Date> updatedDt;
	public static volatile SingularAttribute<NonFinTranFactNcore, Date> transactionPostedTime;
	public static volatile SingularAttribute<NonFinTranFactNcore, TranDimNcore> tranDimNcore;
	public static volatile SingularAttribute<NonFinTranFactNcore, Double> secondaryAccountSNumber;
	public static volatile SingularAttribute<NonFinTranFactNcore, Integer> sNo;
	public static volatile SingularAttribute<NonFinTranFactNcore, Date> transactionExecutedTime;
	public static volatile SingularAttribute<NonFinTranFactNcore, StaffDimNcore> staffDimNcore;
	public static volatile SingularAttribute<NonFinTranFactNcore, Timestamp> createdDtTm;
	public static volatile SingularAttribute<NonFinTranFactNcore, BranchDimNcore> branchDimNcore;
	public static volatile SingularAttribute<NonFinTranFactNcore, Character> relatedInd;
	public static volatile SingularAttribute<NonFinTranFactNcore, AccDimNcore> accDimNcore;
	public static volatile SingularAttribute<NonFinTranFactNcore, String> createdBy;
	public static volatile SingularAttribute<NonFinTranFactNcore, Date> transactionPostedDate;
	public static volatile SingularAttribute<NonFinTranFactNcore, TxnFactNcore> txnFactNcore;
	public static volatile SingularAttribute<NonFinTranFactNcore, String> secondaryPartyNumber;
	public static volatile SingularAttribute<NonFinTranFactNcore, java.sql.Date> createdDt;

}

