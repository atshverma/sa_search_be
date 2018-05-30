package com.sas.sanction.helper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sas.sanction.dto.MatchingCriteriaDto;
import com.sas.sanction.entities.MatchingAttributeConfig;
import com.sas.sanction.entities.MatchingAttributeConfigVersion;

@Component
public class MatchingCriteriaHelper {

	public List<MatchingCriteriaDto> convertEntityToResponse(List<MatchingAttributeConfig> matchingCriteriaList) {
		List<MatchingCriteriaDto> responseList = new ArrayList<>();
		
		for (MatchingAttributeConfig attributes : matchingCriteriaList) {
			MatchingCriteriaDto response =  new MatchingCriteriaDto();
			
			response.setUniqueSno(attributes.getMacSno());
			response.setMatchingField(attributes.getRequestAttributeName());
			response.setMatchType(attributes.getMatchType());
			response.setMatchingStrength(attributes.getMatchStrength());
			
			responseList.add(response);
		}
		
		return responseList;
	}

	public MatchingAttributeConfig generateUpdateMatchingAttribute( MatchingCriteriaDto criteria, MatchingAttributeConfig attribute) {
		Date now = new Date();
		attribute.setMatchType(criteria.getMatchType());
		if(criteria.getMatchType().equalsIgnoreCase("FUZZY")){
			attribute.setMatchStrength("0");
		}else if(criteria.getMatchType().equalsIgnoreCase("DIRECT")){
			attribute.setMatchStrength("100");
		}
		attribute.setRequestAttributeName(criteria.getMatchingField());
		attribute.setUpdatedDt(new java.sql.Date(now.getTime()));
		attribute.setUpdatedDttm(new Timestamp(now.getTime()));
		attribute.setUpdatedBy("User");
		
		return attribute;
	}

	public MatchingAttributeConfigVersion generateAttributeVersion(MatchingAttributeConfig attribute,String action) {
		
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

	public MatchingAttributeConfig generateNewMatchingAttributeConfig(MatchingCriteriaDto criteria) {
		MatchingAttributeConfig attribute = new MatchingAttributeConfig();
		attribute.setMatchType(criteria.getMatchType());
		if(criteria.getMatchType().equalsIgnoreCase("FUZZY")){
			attribute.setMatchStrength("0");
		}else if(criteria.getMatchType().equalsIgnoreCase("DIRECT")){
			attribute.setMatchStrength("100");
		}
		attribute.setRequestAttributeName(criteria.getMatchingField());
		attribute.setMatchStrength("100");// default 100 %
		attribute.setCreatedBy("User");
		attribute.setUpdatedBy("User");
		return attribute;
	}

}