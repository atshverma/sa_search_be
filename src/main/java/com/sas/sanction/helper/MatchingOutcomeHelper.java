package com.sas.sanction.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sas.sanction.dto.MatchingOutcomeResponseDto;
import com.sas.sanction.entities.MatchingOutcome;

@Component
public class MatchingOutcomeHelper {

	public List<MatchingOutcomeResponseDto> convertEntitiesToResponseDto(List<MatchingOutcome> matchingOutcomeList) {
		List<MatchingOutcomeResponseDto> responseList = new ArrayList<>();
		for (MatchingOutcome outcome : matchingOutcomeList) {
			responseList.add(convertEntitiesToSingleMatchingOutcome(outcome));
		}
		return responseList;
	}
	
	
	public MatchingOutcomeResponseDto convertEntitiesToSingleMatchingOutcome(MatchingOutcome outcome) {
		MatchingOutcomeResponseDto response = new MatchingOutcomeResponseDto();
			response.setListName(outcome.getListName());
			response.setMatchingInformation(outcome.getMatchedValue());
			response.setMatchingInformationList(outcome.getListName());
			response.setMatchStrength(outcome.getMatchStrength());
			response.setMatchType(outcome.getMatchType());
			response.setCustomerInformation(outcome.getSanctionCustomer().getFullName());
			return response;		
	}
}
