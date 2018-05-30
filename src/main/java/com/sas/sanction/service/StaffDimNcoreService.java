package com.sas.sanction.service;

import com.sas.sanction.entities.StaffDimNcore;

public interface StaffDimNcoreService 
{
	public StaffDimNcore findByStaffNum(String staffNumber);
}
