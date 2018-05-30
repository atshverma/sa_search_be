package com.sas.sanction.entities;

import java.sql.Date;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BranchDimNcore.class)
public abstract class BranchDimNcore_ {

	public static volatile ListAttribute<BranchDimNcore, NonFinTranFactNcore> nonFinTranFactNcores;
	public static volatile SingularAttribute<BranchDimNcore, Timestamp> updatedDtTm;
	public static volatile SingularAttribute<BranchDimNcore, String> branchNum;
	public static volatile SingularAttribute<BranchDimNcore, String> addrCntryName;
	public static volatile SingularAttribute<BranchDimNcore, String> addrState;
	public static volatile SingularAttribute<BranchDimNcore, String> branchSubCat;
	public static volatile SingularAttribute<BranchDimNcore, Timestamp> createdDtTm;
	public static volatile SingularAttribute<BranchDimNcore, String> updatedBy;
	public static volatile SingularAttribute<BranchDimNcore, Long> branchSno;
	public static volatile SingularAttribute<BranchDimNcore, String> addrLine1;
	public static volatile SingularAttribute<BranchDimNcore, String> addrLine2;
	public static volatile SingularAttribute<BranchDimNcore, String> segmentName;
	public static volatile SingularAttribute<BranchDimNcore, String> addrLine3;
	public static volatile SingularAttribute<BranchDimNcore, String> addrPostalCd;
	public static volatile SingularAttribute<BranchDimNcore, String> createdBy;
	public static volatile SingularAttribute<BranchDimNcore, String> branchCat;
	public static volatile SingularAttribute<BranchDimNcore, String> addrCity;
	public static volatile SingularAttribute<BranchDimNcore, String> branchName;
	public static volatile SingularAttribute<BranchDimNcore, String> addrCntryCd;
	public static volatile SingularAttribute<BranchDimNcore, Double> branchContactNum;
	public static volatile SingularAttribute<BranchDimNcore, Date> updatedDt;
	public static volatile ListAttribute<BranchDimNcore, FinTranFactNcore> finTranFactNcores;
	public static volatile SingularAttribute<BranchDimNcore, Date> createdDt;
	public static volatile SingularAttribute<BranchDimNcore, String> branchContactName;

}

