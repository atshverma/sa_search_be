package com.sas.sanction.service;

import com.sas.sanction.entities.ApplDimNcore;

public interface ApplDimNcoreService 
{
	public ApplDimNcore findByCustomerId(String customerId);
	public ApplDimNcore insertApplDimNcore(ApplDimNcore applDimNcore);
}
