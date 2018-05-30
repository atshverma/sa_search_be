package com.sas.sanction.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sas.sanction.dto.CustomerSearchRequestDto;
import com.sas.sanction.dto.CustomerSearchResponseDto;
import com.sas.sanction.dto.Result;
import com.sas.sanction.service.CustomerSearchService;
import com.sas.sanction.service.MatchingOutcomeService;
import com.sas.sanction.utils.BuildResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path="/v1/api/customer")
public class CustomerSearchAPIController {

	private static Logger logger =  Logger.getLogger(CustomerSearchAPIController.class);
	
	@Autowired
	CustomerSearchService customerSearchService;
	
	@Autowired
	MatchingOutcomeService matchingOutcomeService;
	
	@RequestMapping(path="/customerSearch",method=RequestMethod.POST)
	@ApiOperation(value="API to search for customers from Sanction_Customer, will accept search data in JSON format")
	public Result customerSearch( @RequestBody CustomerSearchRequestDto customerSearchRequestDto) {
		System.out.println("method called");
		logger.info("method called");
		
		List<CustomerSearchResponseDto> customerSearchResults = customerSearchService.getCustomerSearchResults(customerSearchRequestDto);
		if(customerSearchResults!=null && !customerSearchResults.isEmpty()){
			return BuildResponse.buildSuccessResponse(customerSearchResults);
		}else{
			return BuildResponse.buildNullResponse("No Results");
		}
	}
	
	
}
