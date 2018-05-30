package com.sas.sanction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.sanction.dao.AccDimNcoreDao;
import com.sas.sanction.entities.AccDimNcore;
import com.sas.sanction.service.AccDimNcoreService;

@Service
public class AccDimNcoreServiceImpl implements AccDimNcoreService
{

	@Autowired
	private AccDimNcoreDao accDimNcoreDao;
	
	@Override
	public AccDimNcore findByAccNum(String accountNumber) 
	{
		return accDimNcoreDao.findByAccNum(accountNumber);
	}

}
