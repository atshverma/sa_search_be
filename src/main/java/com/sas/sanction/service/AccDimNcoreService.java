package com.sas.sanction.service;

import com.sas.sanction.entities.AccDimNcore;

public interface AccDimNcoreService 
{
	public AccDimNcore findByAccNum(String accountNumber);
}
