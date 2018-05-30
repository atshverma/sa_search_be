package com.sas.sanction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.sanction.dao.StaffDimNcoreDao;
import com.sas.sanction.entities.StaffDimNcore;
import com.sas.sanction.service.StaffDimNcoreService;

@Service
public class StaffDimNcoreServiceImpl implements StaffDimNcoreService 
{
	@Autowired
	private StaffDimNcoreDao staffDimNcoreDao;

	@Override
	public StaffDimNcore findByStaffNum(String staffNumber) 
	{
		return staffDimNcoreDao.findByStaffNum(staffNumber);
	}
	
}
