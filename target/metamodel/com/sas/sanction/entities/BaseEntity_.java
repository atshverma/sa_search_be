package com.sas.sanction.entities;

import java.sql.Date;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BaseEntity.class)
public abstract class BaseEntity_ {

	public static volatile SingularAttribute<BaseEntity, Timestamp> updatedDttm;
	public static volatile SingularAttribute<BaseEntity, Timestamp> createdDttm;
	public static volatile SingularAttribute<BaseEntity, String> createdBy;
	public static volatile SingularAttribute<BaseEntity, Date> updatedDt;
	public static volatile SingularAttribute<BaseEntity, Date> createdDt;
	public static volatile SingularAttribute<BaseEntity, String> updatedBy;

}

