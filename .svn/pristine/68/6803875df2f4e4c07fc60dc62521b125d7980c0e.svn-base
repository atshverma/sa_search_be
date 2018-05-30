package com.sas.sanction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.sanction.dao.ApplDimNcoreDao;
import com.sas.sanction.entities.ApplDimNcore;
import com.sas.sanction.service.ApplDimNcoreService;

@Service
public class ApplDimNcoreServiceImpl implements ApplDimNcoreService
{
	@Autowired
	private ApplDimNcoreDao applDimNcoreDao;
	
	@Override
	public ApplDimNcore findByCustomerId(String customerId) 
	{
		return applDimNcoreDao.findByCustNum(customerId);
	}

	@Override
	public ApplDimNcore insertApplDimNcore(ApplDimNcore applDimNcore) 
	{
		return applDimNcoreDao.save(applDimNcore);
	}

}
