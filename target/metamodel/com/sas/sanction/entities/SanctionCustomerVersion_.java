package com.sas.sanction.entities;

import java.math.BigDecimal;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SanctionCustomerVersion.class)
public abstract class SanctionCustomerVersion_ extends com.sas.sanction.entities.BaseEntity_ {

	public static volatile SingularAttribute<SanctionCustomerVersion, String> resAddressZipCode;
	public static volatile SingularAttribute<SanctionCustomerVersion, Date> dateOfBirth;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> resAddressCity;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> secondaryEmail;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> countryOfBirth;
	public static volatile SingularAttribute<SanctionCustomerVersion, Integer> sanCustVerSno;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> customerId;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> secondName;
	public static volatile SingularAttribute<SanctionCustomerVersion, SanctionCustomer> sanctionCustomer;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> firstName;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> mailAddressZipCode;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> mailAddressStreetLine3;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> lastName;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> mailAddressStreetLine2;
	public static volatile SingularAttribute<SanctionCustomerVersion, BigDecimal> transactionAmount;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> mailAddressStreetLine1;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> status;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> resAddressStreetLine2;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> resAddressStreetLine1;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> phoneNumber2;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> resAddressStreetLine3;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> phoneNumber1;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> mailAddressCity;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> countryOfNationality;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> countryOfCitizenship1;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> primaryEmail;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> countryOfCitizenship2;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> fourthName;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> transactionType;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> thirdName;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> uniqueId2;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> resAddressState;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> caseId;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> mailAddressCountry;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> uniqueId1;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> mailAddressState;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> fullName;
	public static volatile SingularAttribute<SanctionCustomerVersion, String> resAddressCountry;

}

