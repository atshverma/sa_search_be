package com.sas.sanction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.sanction.dao.CustDimNcoreDao;
import com.sas.sanction.entities.CustDimNcore;
import com.sas.sanction.service.CustDimNcoreService;

@Service
public class CustDimNcoreServiceImpl implements CustDimNcoreService
{
	@Autowired
	private CustDimNcoreDao custDimNcoreDao;
	
	@Override
	public CustDimNcore findByCustomerId(String customerId) 
	{
		return custDimNcoreDao.findByCustNum(customerId);
	}

}
