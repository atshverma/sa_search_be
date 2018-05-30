package com.sas.sanction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.sanction.dao.MatchingCriteriaDao;
import com.sas.sanction.dao.MatchingCriteriaVersionDao;
import com.sas.sanction.dto.MatchingStrengthDto;
import com.sas.sanction.entities.MatchingAttributeConfig;
import com.sas.sanction.entities.MatchingAttributeConfigVersion;
import com.sas.sanction.helper.MatchingStrengthHelper;
import com.sas.sanction.service.MatchingStrengthService;

@Service
public class MatchingStrengthServiceImpl implements MatchingStrengthService {

	@Autowired
	MatchingCriteriaDao criteriaDao;
	
	@Autowired
	MatchingStrengthHelper strengthHelper;
	
	@Autowired
	MatchingCriteriaVersionDao criteriaVersionDao;
	
	
	@Override
	public List<MatchingStrengthDto> getAllMatchingStrength() {

		List<MatchingAttributeConfig> matchingStrengthList = criteriaDao.findAll();
		if(matchingStrengthList!=null && !matchingStrengthList.isEmpty()){
			return strengthHelper.convertEntityToResponse(matchingStrengthList);
		}
			return null;
	}

	@Override
	public void submitMatchingCriteria(List<MatchingStrengthDto> matchingStrengthList) {
		for (MatchingStrengthDto matchingStrengthDto : matchingStrengthList) {
			if(matchingStrengthDto.isUpdated()){
				
				MatchingAttributeConfig attribute = criteriaDao.findByMacSno(matchingStrengthDto.getUniqueSno());
			
				MatchingAttributeConfigVersion version = strengthHelper.generateAttributeVersion(attribute,"UPDATE");
				criteriaVersionDao.save(version);
				
				attribute = strengthHelper.generateMatchingCriteriaUpdate(attribute,matchingStrengthDto);
				criteriaDao.save(attribute);
			}
		}
	}

}
