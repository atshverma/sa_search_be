package com.sas.sanction.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MatchingAttributeConfigVersion.class)
public abstract class MatchingAttributeConfigVersion_ extends com.sas.sanction.entities.BaseEntity_ {

	public static volatile SingularAttribute<MatchingAttributeConfigVersion, String> matchType;
	public static volatile SingularAttribute<MatchingAttributeConfigVersion, String> action;
	public static volatile SingularAttribute<MatchingAttributeConfigVersion, String> matchStrength;
	public static volatile SingularAttribute<MatchingAttributeConfigVersion, MatchingAttributeConfig> matchingAttributeConfig;
	public static volatile SingularAttribute<MatchingAttributeConfigVersion, Integer> macVerSno;
	public static volatile SingularAttribute<MatchingAttributeConfigVersion, String> requestAttributeName;

}

