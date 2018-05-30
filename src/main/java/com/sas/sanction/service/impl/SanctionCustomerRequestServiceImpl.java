package com.sas.sanction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.sanction.dao.SanctionCustomerRequestDao;
import com.sas.sanction.entities.SanctionCustomerRequest;
import com.sas.sanction.service.SanctionCustomerRequestService;

@Service
public class SanctionCustomerRequestServiceImpl implements SanctionCustomerRequestService
{

	@Autowired
	private SanctionCustomerRequestDao sanctionCustomerRequestDao;
	
	@Override
	public SanctionCustomerRequest insertSanctionCustomerRequest(SanctionCustomerRequest sanctionCustomerRequest) 
	{
		return sanctionCustomerRequestDao.save(sanctionCustomerRequest);
	}

}
