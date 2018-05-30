package com.sas.sanction.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.sanction.dao.AccDimNcoreDao;
import com.sas.sanction.dao.BranchDimNcoreDao;
import com.sas.sanction.dao.CntryCurrLkpNcoreDao;
import com.sas.sanction.dao.CustDimNcoreDao;
import com.sas.sanction.dao.ExtPartyDimNcoreDao;
import com.sas.sanction.dao.FinTranFactNcoreDao;
import com.sas.sanction.dao.NonFinTranFactNcoreDao;
import com.sas.sanction.dao.StaffDimNcoreDao;
import com.sas.sanction.dao.TranDimNcoreDao;
import com.sas.sanction.dao.TxnFactNcoreDao;
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
import com.sas.sanction.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private CustDimNcoreDao custDimNcoreDao;
	
	@Autowired
	private AccDimNcoreDao accDimNcoreDao;
	
	@Autowired
	private BranchDimNcoreDao branchDimNcoreDao;
	
	@Autowired
	private StaffDimNcoreDao staffDimNcoreDao;
	
	@Autowired
	private ExtPartyDimNcoreDao extPartyDimNcoreDao;
	
	@Autowired
	private TranDimNcoreDao tranDimNcoreDao;
	
	@Autowired
	private FinTranFactNcoreDao finTranFactNcoreDao;
	
	@Autowired
	private NonFinTranFactNcoreDao nonFinTranFactDao;
	
	@Override
	@Transactional
	public void saveFinancialTransaction(CustDimNcore custDimNcore,
			AccDimNcore accDimNcore, BranchDimNcore branchDimNcore, StaffDimNcore staffDimNcore,
			ExtPartyDimNcore extPartyDimNcore, TranDimNcore tranDimNcore, FinTranFactNcore finTranFactNcore) {
		
		custDimNcoreDao.save(custDimNcore);
		accDimNcoreDao.save(accDimNcore);
		branchDimNcoreDao.save(branchDimNcore);
		staffDimNcoreDao.save(staffDimNcore);
		extPartyDimNcoreDao.save(extPartyDimNcore);
		tranDimNcoreDao.save(tranDimNcore);
		finTranFactNcoreDao.save(finTranFactNcore);
		
	}

	@Override
	public void saveNonFinancialTransaction(AccDimNcore accDimNcore, BranchDimNcore branchDimNcore,
			CustDimNcore custDimNcore, ExtPartyDimNcore extPartyDimNcore, StaffDimNcore staffDimNcore,
			TranDimNcore tranDimNcore, NonFinTranFactNcore nonFinFactNcore) {
		accDimNcoreDao.save(accDimNcore);
		branchDimNcoreDao.save(branchDimNcore);
		custDimNcoreDao.save(custDimNcore);
		extPartyDimNcoreDao.save(extPartyDimNcore);
		staffDimNcoreDao.save(staffDimNcore);
		tranDimNcoreDao.save(tranDimNcore);
		nonFinTranFactDao.save(nonFinFactNcore);
		
		
	}

}
