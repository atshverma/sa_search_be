package com.sas.sanction.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ListVersion.class)
public abstract class ListVersion_ extends com.sas.sanction.entities.BaseEntity_ {

	public static volatile SingularAttribute<ListVersion, String> listSubType;
	public static volatile SingularAttribute<ListVersion, String> listName;
	public static volatile SingularAttribute<ListVersion, ListMaster> listMaster;
	public static volatile SingularAttribute<ListVersion, String> listType;
	public static volatile SingularAttribute<ListVersion, Integer> listVerSno;
	public static volatile SingularAttribute<ListVersion, Integer> listOrder;

}

