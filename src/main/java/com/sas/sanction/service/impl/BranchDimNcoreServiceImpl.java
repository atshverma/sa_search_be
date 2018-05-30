package com.sas.sanction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.sanction.dao.BranchDimNcoreDao;
import com.sas.sanction.entities.BranchDimNcore;
import com.sas.sanction.service.BranchDimNcoreService;

@Service
public class BranchDimNcoreServiceImpl implements BranchDimNcoreService
{
	
	@Autowired
	private BranchDimNcoreDao branchDimNcoreDao;

	@Override
	public BranchDimNcore findByBranchNum(String branchNumber) 
	{
		return branchDimNcoreDao.findByBranchNum(branchNumber);
	}

}
