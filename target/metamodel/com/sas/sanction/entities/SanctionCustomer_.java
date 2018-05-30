package com.sas.sanction.entities;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SanctionCustomer.class)
public abstract class SanctionCustomer_ extends com.sas.sanction.entities.BaseEntity_ {

	public static volatile SingularAttribute<SanctionCustomer, String> resAddressZipCode;
	public static volatile SingularAttribute<SanctionCustomer, Date> dateOfBirth;
	public static volatile SingularAttribute<SanctionCustomer, String> listName;
	public static volatile SingularAttribute<SanctionCustomer, String> resAddressCity;
	public static volatile SingularAttribute<SanctionCustomer, String> secondaryEmail;
	public static volatile SingularAttribute<SanctionCustomer, String> countryOfBirth;
	public static volatile SingularAttribute<SanctionCustomer, String> customerId;
	public static volatile ListAttribute<SanctionCustomer, MatchingOutcome> matchingOutcomes;
	public static volatile SingularAttribute<SanctionCustomer, String> secondName;
	public static volatile SingularAttribute<SanctionCustomer, String> firstName;
	public static volatile SingularAttribute<SanctionCustomer, String> mailAddressZipCode;
	public static volatile ListAttribute<SanctionCustomer, SanctionCustomerVersion> sanctionCustomerVersions;
	public static volatile SingularAttribute<SanctionCustomer, Integer> sanCustSno;
	public static volatile SingularAttribute<SanctionCustomer, String> mailAddressStreetLine3;
	public static volatile SingularAttribute<SanctionCustomer, String> lastName;
	public static volatile SingularAttribute<SanctionCustomer, String> mailAddressStreetLine2;
	public static volatile SingularAttribute<SanctionCustomer, Double> transactionAmount;
	public static volatile SingularAttribute<SanctionCustomer, String> mailAddressStreetLine1;
	public static volatile SingularAttribute<SanctionCustomer, String> status;
	public static volatile SingularAttribute<SanctionCustomer, String> resAddressStreetLine2;
	public static volatile SingularAttribute<SanctionCustomer, String> resAddressStreetLine1;
	public static volatile SingularAttribute<SanctionCustomer, String> phoneNumber2;
	public static volatile SingularAttribute<SanctionCustomer, String> resAddressStreetLine3;
	public static volatile SingularAttribute<SanctionCustomer, String> phoneNumber1;
	public static volatile SingularAttribute<SanctionCustomer, String> mailAddressCity;
	public static volatile SingularAttribute<SanctionCustomer, String> countryOfNationality;
	public static volatile SingularAttribute<SanctionCustomer, String> countryOfCitizenship1;
	public static volatile SingularAttribute<SanctionCustomer, String> primaryEmail;
	public static volatile SingularAttribute<SanctionCustomer, String> countryOfCitizenship2;
	public static volatile SingularAttribute<SanctionCustomer, String> fourthName;
	public static volatile SingularAttribute<SanctionCustomer, String> transactionType;
	public static volatile SingularAttribute<SanctionCustomer, String> thirdName;
	public static volatile SingularAttribute<SanctionCustomer, String> uniqueId2;
	public static volatile SingularAttribute<SanctionCustomer, String> resAddressState;
	public static volatile SingularAttribute<SanctionCustomer, String> caseId;
	public static volatile SingularAttribute<SanctionCustomer, String> mailAddressCountry;
	public static volatile SingularAttribute<SanctionCustomer, String> uniqueId1;
	public static volatile SingularAttribute<SanctionCustomer, String> mailAddressState;
	public static volatile SingularAttribute<SanctionCustomer, String> fullName;
	public static volatile SingularAttribute<SanctionCustomer, String> transactionNo;
	public static volatile SingularAttribute<SanctionCustomer, String> resAddressCountry;

}

