package com.sas.sanction.entities;

import java.sql.Date;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CustAccMapNcore.class)
public abstract class CustAccMapNcore_ {

	public static volatile SingularAttribute<CustAccMapNcore, CustDimNcore> custDimNcore;
	public static volatile SingularAttribute<CustAccMapNcore, String> accOwnershipCat;
	public static volatile SingularAttribute<CustAccMapNcore, Integer> mapId;
	public static volatile SingularAttribute<CustAccMapNcore, String> createdBy;
	public static volatile SingularAttribute<CustAccMapNcore, AccDimNcore> accDimNcore;
	public static volatile SingularAttribute<CustAccMapNcore, Timestamp> updatedDtTm;
	public static volatile SingularAttribute<CustAccMapNcore, Date> updatedDt;
	public static volatile SingularAttribute<CustAccMapNcore, Date> createdDt;
	public static volatile SingularAttribute<CustAccMapNcore, Timestamp> createdDtTm;
	public static volatile SingularAttribute<CustAccMapNcore, String> updatedBy;

}

