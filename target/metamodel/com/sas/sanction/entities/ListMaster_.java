package com.sas.sanction.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ListMaster.class)
public abstract class ListMaster_ extends com.sas.sanction.entities.BaseEntity_ {

	public static volatile ListAttribute<ListMaster, ListVersion> listVersions;
	public static volatile SingularAttribute<ListMaster, String> listSubType;
	public static volatile SingularAttribute<ListMaster, String> listName;
	public static volatile SingularAttribute<ListMaster, Integer> listMasterSno;
	public static volatile ListAttribute<ListMaster, ListDataVersion> listDataVersion;
	public static volatile SingularAttribute<ListMaster, String> listType;
	public static volatile ListAttribute<ListMaster, ListData> listData;
	public static volatile SingularAttribute<ListMaster, Integer> listOrder;

}

