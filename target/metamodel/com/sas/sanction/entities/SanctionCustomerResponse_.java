package com.sas.sanction.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SanctionCustomerResponse.class)
public abstract class SanctionCustomerResponse_ extends com.sas.sanction.entities.BaseEntity_ {

	public static volatile SingularAttribute<SanctionCustomerResponse, String> responseCode;
	public static volatile SingularAttribute<SanctionCustomerResponse, String> listName;
	public static volatile SingularAttribute<SanctionCustomerResponse, String> customerId;
	public static volatile SingularAttribute<SanctionCustomerResponse, Integer> sno;
	public static volatile SingularAttribute<SanctionCustomerResponse, String> responseDesc;
	public static volatile SingularAttribute<SanctionCustomerResponse, String> status;
	public static volatile SingularAttribute<SanctionCustomerResponse, String> caseId;
	public static volatile SingularAttribute<SanctionCustomerResponse, String> transactionNo;

}

