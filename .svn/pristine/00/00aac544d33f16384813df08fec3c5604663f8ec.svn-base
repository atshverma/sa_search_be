package com.sas.sanction.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sas.sanction.dto.Result;
import com.sas.sanction.dto.TransactionSearchRequestDto;
import com.sas.sanction.dto.TransactionSearchResponseDto;
import com.sas.sanction.service.TransactionSearchService;
import com.sas.sanction.utils.BuildResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path="/v1/api/transaction")
public class TransactionSearchAPIController {

	@Autowired
	TransactionSearchService transactionSearchService;
	
	private static Logger logger =  Logger.getLogger(TransactionSearchAPIController.class);
	
	
	@RequestMapping(path="/transactionSearch",method=RequestMethod.POST)
	@ApiOperation(value="API to search Sanction_Customer on the basis of Transactions ")
	public Result transactionSearch(@RequestBody TransactionSearchRequestDto transactionSearchRequestDto) {
		System.out.println("TRANSACTION SEARCHED");
		logger.info("Transaction searched");

		List<TransactionSearchResponseDto> transactionResults = transactionSearchService.getTransactionResults(transactionSearchRequestDto);
		
		if(transactionResults!=null && !transactionResults.isEmpty()){
			return BuildResponse.buildSuccessResponse(transactionResults);
		}else{
			return BuildResponse.buildNullResponse("No Results");
		}
	}
	
	
}
