package com.sas.sanction.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MatchingAttributeConfig.class)
public abstract class MatchingAttributeConfig_ extends com.sas.sanction.entities.BaseEntity_ {

	public static volatile ListAttribute<MatchingAttributeConfig, MatchingAttributeConfigVersion> matchingAttributeConfigVersions;
	public static volatile SingularAttribute<MatchingAttributeConfig, String> matchType;
	public static volatile SingularAttribute<MatchingAttributeConfig, String> matchStrength;
	public static volatile SingularAttribute<MatchingAttributeConfig, String> requestAttributeName;
	public static volatile SingularAttribute<MatchingAttributeConfig, Integer> macSno;

}

