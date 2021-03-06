package com.sas.sanction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.sanction.dao.MatchingOutcomeDao;
import com.sas.sanction.dto.MatchingOutcomeResponseDto;
import com.sas.sanction.entities.MatchingOutcome;
import com.sas.sanction.helper.MatchingOutcomeHelper;
import com.sas.sanction.service.MatchingOutcomeService;

@Service
public class MatchingOutcomeServiceImpl implements MatchingOutcomeService {

	@Autowired
	private MatchingOutcomeDao matchingDao;
	
	@Autowired
	private MatchingOutcomeHelper matchingOutcomeHelper;
	
	@Override
	public List<MatchingOutcomeResponseDto> getCustomerMatchingOutcome(String customerSno) {
		List<MatchingOutcomeResponseDto> responseList = null;
		
		List<MatchingOutcome> matchingOutcomeList = matchingDao.findBySanctionCustomerCustomerId(customerSno);
		
		if(matchingOutcomeList!=null && !matchingOutcomeList.isEmpty()){
			responseList = matchingOutcomeHelper.convertEntitiesToResponseDto(matchingOutcomeList);
		}
		
		return responseList;
	}

	@Override
	public List<MatchingOutcomeResponseDto> getTransactionMatchingOutcome(String trasactionNo) {
		List<MatchingOutcomeResponseDto>  responseList = null;
		
		List<MatchingOutcome> matchingOutcome = matchingDao.findBySanctionCustomerTransactionNo(trasactionNo);
		
		if(matchingOutcome!=null ){
			responseList = matchingOutcomeHelper.convertEntitiesToResponseDto(matchingOutcome);
		}
		
		return responseList;
	}

}
