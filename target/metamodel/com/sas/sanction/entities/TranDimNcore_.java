package com.sas.sanction.entities;

import java.sql.Date;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TranDimNcore.class)
public abstract class TranDimNcore_ {

	public static volatile SingularAttribute<TranDimNcore, String> narrative1;
	public static volatile SingularAttribute<TranDimNcore, String> channelName;
	public static volatile SingularAttribute<TranDimNcore, Long> txnSno;
	public static volatile SingularAttribute<TranDimNcore, Timestamp> updatedDtTm;
	public static volatile SingularAttribute<TranDimNcore, String> channelId;
	public static volatile SingularAttribute<TranDimNcore, String> narrative3;
	public static volatile SingularAttribute<TranDimNcore, String> narrative2;
	public static volatile SingularAttribute<TranDimNcore, NonFinTranFactNcore> nonFinTranFactNcore;
	public static volatile SingularAttribute<TranDimNcore, String> txnStatus;
	public static volatile SingularAttribute<TranDimNcore, Timestamp> createdDtTm;
	public static volatile SingularAttribute<TranDimNcore, String> updatedBy;
	public static volatile SingularAttribute<TranDimNcore, String> createdBy;
	public static volatile SingularAttribute<TranDimNcore, FinTranFactNcore> finTranFactNcore;
	public static volatile SingularAttribute<TranDimNcore, Date> updatedDt;
	public static volatile SingularAttribute<TranDimNcore, String> txnPtrnNum;
	public static volatile SingularAttribute<TranDimNcore, String> txnRefNum;
	public static volatile SingularAttribute<TranDimNcore, Date> createdDt;

}

