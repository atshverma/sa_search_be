package com.sas.sanction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sas.sanction.dao.MatchingOutcomeDao;
import com.sas.sanction.dto.MatchingOutcomeResponseDto;
import com.sas.sanction.dto.Result;
import com.sas.sanction.service.MatchingOutcomeService;
import com.sas.sanction.utils.BuildResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/api/matchOutcome")
public class MatchingOutcomeAPIController {

	@Autowired
	MatchingOutcomeService matchingOutcomeService;
	
	@Autowired
	MatchingOutcomeDao outcomeDao;
	
	@RequestMapping(path="/viewTransactionMatchingOutcome/{trasactionNo}",method=RequestMethod.GET)
	@ApiOperation(value="API to view the records for transaction from Sanction_Customer")
	public Result getTransactionMatchingOutcome(@PathVariable String trasactionNo) {
		
		
		List<MatchingOutcomeResponseDto> transactionMatchingOutcome = matchingOutcomeService.getTransactionMatchingOutcome(trasactionNo);
		
		if(transactionMatchingOutcome!=null && !transactionMatchingOutcome.isEmpty()){
			return BuildResponse.buildSuccessResponse(transactionMatchingOutcome);
		}else{
			return BuildResponse.buildNullResponse("No Results");
		}
		
	}
	

	@RequestMapping(path="/viewCustomerMatchingOutcome/{customerNumber}",method=RequestMethod.GET)
	@ApiOperation(value="API to view the records for customer from Sanction_Customer")
	public Result getCustomerMatchingOutcome(@PathVariable String customerNumber) {
				
		List<MatchingOutcomeResponseDto> customerMatchingOutcome = matchingOutcomeService.getCustomerMatchingOutcome(customerNumber);

		if(customerMatchingOutcome!=null && !customerMatchingOutcome.isEmpty()){
			return BuildResponse.buildSuccessResponse(customerMatchingOutcome);
		}else{
			return BuildResponse.buildNullResponse("No Results");
		}
	}
	
}
