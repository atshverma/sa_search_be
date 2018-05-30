package com.sas.sanction.entities;

import java.sql.Date;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TxnFactNcore.class)
public abstract class TxnFactNcore_ {

	public static volatile ListAttribute<TxnFactNcore, NonFinTranFactNcore> nonFinTranFactNcores;
	public static volatile SingularAttribute<TxnFactNcore, String> channelName;
	public static volatile SingularAttribute<TxnFactNcore, Timestamp> updatedDtTm;
	public static volatile SingularAttribute<TxnFactNcore, String> txnTypFlag;
	public static volatile SingularAttribute<TxnFactNcore, String> productMed;
	public static volatile SingularAttribute<TxnFactNcore, Timestamp> createdDtTm;
	public static volatile SingularAttribute<TxnFactNcore, String> updatedBy;
	public static volatile SingularAttribute<TxnFactNcore, Long> txnTypNum;
	public static volatile SingularAttribute<TxnFactNcore, String> serviceName;
	public static volatile SingularAttribute<TxnFactNcore, String> createdBy;
	public static volatile SingularAttribute<TxnFactNcore, String> txnCat;
	public static volatile SingularAttribute<TxnFactNcore, String> channelMed;
	public static volatile SingularAttribute<TxnFactNcore, Date> updatedDt;
	public static volatile ListAttribute<TxnFactNcore, FinTranFactNcore> finTranFactNcores;
	public static volatile SingularAttribute<TxnFactNcore, String> productName;
	public static volatile SingularAttribute<TxnFactNcore, Date> createdDt;

}

