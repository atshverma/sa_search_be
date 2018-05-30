package com.sas.sanction.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MatchingOutcome.class)
public abstract class MatchingOutcome_ extends com.sas.sanction.entities.BaseEntity_ {

	public static volatile SingularAttribute<MatchingOutcome, String> listName;
	public static volatile SingularAttribute<MatchingOutcome, String> transactionSno;
	public static volatile SingularAttribute<MatchingOutcome, String> matchingAttributeValue;
	public static volatile SingularAttribute<MatchingOutcome, Integer> moSno;
	public static volatile SingularAttribute<MatchingOutcome, String> matchType;
	public static volatile SingularAttribute<MatchingOutcome, String> matchedValue;
	public static volatile SingularAttribute<MatchingOutcome, SanctionCustomer> sanctionCustomer;
	public static volatile SingularAttribute<MatchingOutcome, String> matchStrength;
	public static volatile SingularAttribute<MatchingOutcome, String> matchingAttribute;

}

