package com.sas.sanction.service;

import com.sas.sanction.entities.AccDimNcore;
import com.sas.sanction.entities.BranchDimNcore;
import com.sas.sanction.entities.CntryCurrLkpNcore;
import com.sas.sanction.entities.CustDimNcore;
import com.sas.sanction.entities.ExtPartyDimNcore;
import com.sas.sanction.entities.FinTranFactNcore;
import com.sas.sanction.entities.NonFinTranFactNcore;
import com.sas.sanction.entities.StaffDimNcore;
import com.sas.sanction.entities.TranDimNcore;
import com.sas.sanction.entities.TxnFactNcore;

public interface TransactionService {
	public void saveFinancialTransaction(CustDimNcore custDimNcore,
			AccDimNcore accDimNcore, BranchDimNcore branchDimNcore, StaffDimNcore staffDimNcore,
			ExtPartyDimNcore extPartyDimNcore, TranDimNcore tranDimNcore, FinTranFactNcore finTranFactNcore);

	public void saveNonFinancialTransaction(AccDimNcore accDimNcore, BranchDimNcore branchDimNcore,
			CustDimNcore custDimNcore, ExtPartyDimNcore extPartyDimNcore, StaffDimNcore staffDimNcore,
			TranDimNcore tranDimNcore, NonFinTranFactNcore nonFinFactNcore);

}
