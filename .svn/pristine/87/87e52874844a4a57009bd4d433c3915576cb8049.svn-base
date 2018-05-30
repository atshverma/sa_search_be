package com.sas.sanction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.sanction.dao.MatchingAttributeConfigDao;
import com.sas.sanction.entities.MatchingAttributeConfig;
import com.sas.sanction.service.MatchingAttributeConfigService;

@Service
public class MatchingAttributeConfigServiceImpl implements MatchingAttributeConfigService
{
	@Autowired
	private MatchingAttributeConfigDao matchingAttributeConfigDao;
	
	@Override
	public List<MatchingAttributeConfig> getAllMatchingAttributes() 
	{
		return matchingAttributeConfigDao.findAll();
	}

}
