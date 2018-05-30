package com.sas.sanction.entities;

import java.sql.Date;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CustPtyMapNcore.class)
public abstract class CustPtyMapNcore_ {

	public static volatile SingularAttribute<CustPtyMapNcore, ExtPartyDimNcore> extPartyDimNcore;
	public static volatile SingularAttribute<CustPtyMapNcore, CustDimNcore> custDimNcore;
	public static volatile SingularAttribute<CustPtyMapNcore, String> relationshipCodeDescription;
	public static volatile SingularAttribute<CustPtyMapNcore, Integer> mapId;
	public static volatile SingularAttribute<CustPtyMapNcore, String> relationshipCode;
	public static volatile SingularAttribute<CustPtyMapNcore, String> createdBy;
	public static volatile SingularAttribute<CustPtyMapNcore, Timestamp> updatedDtTm;
	public static volatile SingularAttribute<CustPtyMapNcore, String> relatedPartyCustomerFlag;
	public static volatile SingularAttribute<CustPtyMapNcore, Date> updatedDt;
	public static volatile SingularAttribute<CustPtyMapNcore, Date> createdDt;
	public static volatile SingularAttribute<CustPtyMapNcore, Timestamp> createdDtTm;
	public static volatile SingularAttribute<CustPtyMapNcore, String> updatedBy;

}

