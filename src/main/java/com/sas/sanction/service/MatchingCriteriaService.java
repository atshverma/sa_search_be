package com.sas.sanction.service;

import java.util.List;

import com.sas.sanction.dto.MatchingCriteriaDto;

public interface MatchingCriteriaService {

	List<MatchingCriteriaDto> getAllMatchingCriteria();

	List<MatchingCriteriaDto> actionsOnMatchingCriteria(List<MatchingCriteriaDto> matchingCriteriaRequestDtoList);

	List<String> fetchAttributeLookup();

}
