package com.sas.sanction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sas.sanction.dto.MatchingCriteriaDto;
import com.sas.sanction.dto.Result;
import com.sas.sanction.service.MatchingCriteriaService;
import com.sas.sanction.utils.BuildResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("v1/api/matchCriteria")
public class MatchingCriteriaAPIController {

	@Autowired
	MatchingCriteriaService criteriaService;
	
	@RequestMapping(path="/listAllMatchingCriteria",method=RequestMethod.GET)
	@ApiOperation(value="API to List All matching criteria from Matching_Attribute_Config")
	public Result getAllMatchingCriteria() {
		
		List<MatchingCriteriaDto> allMatchingCriteria = criteriaService.getAllMatchingCriteria();
		 if(allMatchingCriteria!=null && !allMatchingCriteria.isEmpty()){
				return BuildResponse.buildSuccessResponse(allMatchingCriteria);
			}else{
				return BuildResponse.buildNullResponse("No Results");
		}
	}
	
	@RequestMapping(path="/fetchAttributeLookup",method=RequestMethod.GET)
	@ApiOperation(value="API to List All field names from Matching_Attribute_LookUp")
	public Result fetchAttributeLookup(){
		
		List<String> fetchAttributeLookup = criteriaService.fetchAttributeLookup();
		 if(fetchAttributeLookup!=null && !fetchAttributeLookup.isEmpty()){
				return BuildResponse.buildSuccessResponse(fetchAttributeLookup);
			}else{
				return BuildResponse.buildNullResponse("No Results");
		}
	}
	
	@RequestMapping(path="/submitMatchingCriteria",method=RequestMethod.POST)
	@ApiOperation(value="API to update Matching Criteria in Matching_Attribute_Config, along with version creation")
	public Result updateMatchingCriteria(@RequestBody List<MatchingCriteriaDto> matchingCriteriaRequestDtoList){
		
		List<MatchingCriteriaDto> actionsOnMatchingCriteria = criteriaService.actionsOnMatchingCriteria(matchingCriteriaRequestDtoList);
		 if(actionsOnMatchingCriteria!=null && !actionsOnMatchingCriteria.isEmpty()){
				return BuildResponse.buildSuccessResponse(actionsOnMatchingCriteria);
			}else{
				return BuildResponse.buildNullResponse("No Results");
		}
	}
	
}
