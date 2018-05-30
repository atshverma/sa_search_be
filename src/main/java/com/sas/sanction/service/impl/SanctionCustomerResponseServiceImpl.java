package com.sas.sanction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.sanction.dao.SanctionCustomerResponseDao;
import com.sas.sanction.entities.SanctionCustomerResponse;
import com.sas.sanction.service.SanctionCustomerResponseService;

@Service
public class SanctionCustomerResponseServiceImpl implements SanctionCustomerResponseService
{
	@Autowired
	SanctionCustomerResponseDao sanctionCustomerResponseDao;
	@Override
	public SanctionCustomerResponse insertSanctionCustomerResponse(SanctionCustomerResponse sanctionCustomerResponse)
	{
		return sanctionCustomerResponseDao.save(sanctionCustomerResponse);
	}

}
