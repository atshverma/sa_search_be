package com.sas.sanction.service;

import com.sas.sanction.entities.ExtPartyDimNcore;

public interface ExtPartyDimNcoreService 
{
	public ExtPartyDimNcore findByExtPartyNum(String extPartyNumber);
}
