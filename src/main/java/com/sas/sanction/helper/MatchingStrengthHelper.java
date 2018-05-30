package com.sas.sanction.helper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sas.sanction.dto.MatchingStrengthDto;
import com.sas.sanction.entities.MatchingAttributeConfig;
import com.sas.sanction.entities.MatchingAttributeConfigVersion;

@Component
public class MatchingStrengthHelper {

	public List<MatchingStrengthDto> convertEntityToResponse(List<MatchingAttributeConfig> matchingStrengthList) {
		List<MatchingStrengthDto> responseList = new ArrayList<>();
		
		for (MatchingAttributeConfig attributes : matchingStrengthList) {
			MatchingStrengthDto response =  new MatchingStrengthDto();
			
			response.setUniqueSno(attributes.getMacSno());
			response.setMatchingFieldName(attributes.getRequestAttributeName());
			response.setMatchType(attributes.getMatchType());
			response.setMatchingStrength(attributes.getMatchStrength());
			
			responseList.add(response);
		}
		
		return responseList;
	}

	public MatchingAttributeConfig generateMatchingCriteriaUpdate(MatchingAttributeConfig attribute, MatchingStrengthDto matchingStrengthDto) {
		Date now = new Date();
		attribute.setUpdatedDt(new java.sql.Date(now.getTime()));
		attribute.setUpdatedDttm(new Timestamp(now.getTime()));
		attribute.setUpdatedBy("User");
		attribute.setMatchStrength(matchingStrengthDto.getMatchingStrength());
		
		return attribute;
	}

	public MatchingAttributeConfigVersion generateAttributeVersion(MatchingAttributeConfig attribute, String action) {
		
		MatchingAttributeConfigVersion version = new MatchingAttributeConfigVersion();
			version.setRequestAttributeName(attribute.getRequestAttributeName());
			version.setMatchStrength(attribute.getMatchStrength());
			version.setMatchType(attribute.getMatchType());
			version.setMatchingAttributeConfig(attribute);
			version.setAction(action);
			version.setCreatedBy("User");
			version.setUpdatedBy("User");
			
		return version;
	}

}
