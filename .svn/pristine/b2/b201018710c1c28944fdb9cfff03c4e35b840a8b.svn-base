package com.sas.sanction.service;

import java.util.List;
import java.util.Map;

import com.sas.sanction.entities.ListData;
import com.sas.sanction.entities.MatchingAttributeConfig;
import com.sas.sanction.entities.SanctionCustomer;

public interface ListDataService 
{
	public ListData getListDataByCustomerId(String customerId);
	public List<Map<String, Object>> getListDataForFuzzyLogic(String sql, List<MatchingAttributeConfig> configList, Map<String, String> xmlValues, SanctionCustomer sanctionCustomer, String transactionSno);
	
}
