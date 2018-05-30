package com.sas.sanction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sas.sanction.dto.MatchingStrengthDto;
import com.sas.sanction.dto.Result;
import com.sas.sanction.service.MatchingStrengthService;
import com.sas.sanction.utils.BuildResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("v1/api/matchingStrength")
public class MatchingStrengthAPIController {

	@Autowired
	MatchingStrengthService matchingStrengthservice;
	
	
	@RequestMapping(path="/listAllMatchingStrength",method=RequestMethod.GET)
	@ApiOperation(value="API to get matching Strength from Matching_Attribute_Config")
	public Result getAllMatchingStrength() {
		
		List<MatchingStrengthDto> allMatchingStrength = matchingStrengthservice.getAllMatchingStrength();
		
		if(allMatchingStrength!=null && !allMatchingStrength.isEmpty()){
			return BuildResponse.buildSuccessResponse(allMatchingStrength);
		}else{
			return BuildResponse.buildNullResponse("No Results");
		}
	}
	
	@RequestMapping(path="/submitMatchingStrength",method=RequestMethod.POST)
	@ApiOperation(value="API to update the Matching Strength in Matching_Attribute_Config, along with version creation")
	public Result submitMatchingCriteria(@RequestBody List<MatchingStrengthDto> matchingStrengthList){
		
		matchingStrengthservice.submitMatchingCriteria(matchingStrengthList);
		
		 List<MatchingStrengthDto> allMatchingStrength = matchingStrengthservice.getAllMatchingStrength();
		 
		 if(allMatchingStrength!=null && !allMatchingStrength.isEmpty()){
				return BuildResponse.buildSuccessResponse(allMatchingStrength);
			}else{
				return BuildResponse.buildNullResponse("No Results");
			}
	}
	
}
