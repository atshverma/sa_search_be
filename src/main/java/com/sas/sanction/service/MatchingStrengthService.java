package com.sas.sanction.service;

import java.util.List;

import com.sas.sanction.dto.MatchingStrengthDto;

public interface MatchingStrengthService {

	List<MatchingStrengthDto> getAllMatchingStrength();

	void submitMatchingCriteria(List<MatchingStrengthDto> matchingStrengthList);

}
