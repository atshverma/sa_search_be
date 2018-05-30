package com.sas.sanction.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CntryCurrLkpNcore.class)
public abstract class CntryCurrLkpNcore_ {

	public static volatile SingularAttribute<CntryCurrLkpNcore, Long> currCdSno;
	public static volatile SingularAttribute<CntryCurrLkpNcore, String> currCd;
	public static volatile SingularAttribute<CntryCurrLkpNcore, String> cntryCd;
	public static volatile SingularAttribute<CntryCurrLkpNcore, Double> cntryNum;
	public static volatile ListAttribute<CntryCurrLkpNcore, FinTranFactNcore> finTranFactNcores;
	public static volatile SingularAttribute<CntryCurrLkpNcore, String> cntryName;
	public static volatile SingularAttribute<CntryCurrLkpNcore, String> cntryCd3;

}

