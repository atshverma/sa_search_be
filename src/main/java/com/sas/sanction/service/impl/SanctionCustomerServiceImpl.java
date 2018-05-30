package com.sas.sanction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.sanction.dao.SanctionCustomerDao;
import com.sas.sanction.entities.SanctionCustomer;
import com.sas.sanction.service.SanctionCustomerService;

@Service
public class SanctionCustomerServiceImpl implements SanctionCustomerService
{
	@Autowired
	private SanctionCustomerDao sanctionCustomerDao;

	@Override
	public SanctionCustomer getSanctionCustomerByCustomerId(String customerId) 
	{
		return sanctionCustomerDao.findByCustomerId(customerId);
	}

	@Override
	public SanctionCustomer insertSanctionCustomer(SanctionCustomer sanctionCustomer) 
	{
		return sanctionCustomerDao.save(sanctionCustomer);
	}
	
	

}
