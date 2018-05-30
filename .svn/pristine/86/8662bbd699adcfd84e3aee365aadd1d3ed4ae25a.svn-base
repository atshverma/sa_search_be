package com.sas.sanction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.sanction.dao.ExtPartyDimNcoreDao;
import com.sas.sanction.entities.ExtPartyDimNcore;
import com.sas.sanction.service.ExtPartyDimNcoreService;

@Service
public class ExtPartyDimNcoreServiceImpl implements ExtPartyDimNcoreService
{

	@Autowired
	private ExtPartyDimNcoreDao extPartyDimNcoreDao;
	
	@Override
	public ExtPartyDimNcore findByExtPartyNum(String extPartyNumber) 
	{
		return extPartyDimNcoreDao.findByExtPartyNum(extPartyNumber);
	}

}
