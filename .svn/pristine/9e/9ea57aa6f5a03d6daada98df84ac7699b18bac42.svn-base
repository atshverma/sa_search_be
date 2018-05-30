package com.sas.sanction.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sas.sanction.dto.AuditCustomerVersionResponseDto;
import com.sas.sanction.dto.AuditTransactionVersionResponseDto;
import com.sas.sanction.dto.CustomerSearchRequestDto;
import com.sas.sanction.dto.CustomerSearchResponseDto;
import com.sas.sanction.dto.ListMgmtResponseDto;
import com.sas.sanction.dto.ListMgmtSearchRequestDto;
import com.sas.sanction.dto.Result;
import com.sas.sanction.service.AuditSearchService;
import com.sas.sanction.utils.BuildResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/v1/api/audit")
public class AuditSearchAPIController {

	private Logger logger = Logger.getLogger(AuditSearchAPIController.class);
	
	@Autowired
	AuditSearchService auditSearchService;
	
	@RequestMapping(path="/customerSearch",method=RequestMethod.POST)
	@ApiOperation(value="API to search for customers from Sanction_Customer_Version, will accept search data in JSON format")
	public Result auditCustomerSearch(@RequestBody CustomerSearchRequestDto auditSearchRequestDto) {
		System.out.println("method called");
		logger.info("method called");
		List<CustomerSearchResponseDto> auditCustomerSearch = auditSearchService.getAuditCustomerSearch(auditSearchRequestDto);
		
		if(auditCustomerSearch!=null && !auditCustomerSearch.isEmpty()){
			return BuildResponse.buildSuccessResponse(auditCustomerSearch);
		}else{
			return BuildResponse.buildNullResponse("No Results");
		}
	}
	

	@RequestMapping(path="/listSearch",method=RequestMethod.POST)
	@ApiOperation(value="API to search for customers from List_Data_Version, will accept search data in JSON format")
	public Result auditListSearch(@RequestBody ListMgmtSearchRequestDto auditSearchRequestDto) {
		System.out.println("method called");
		logger.info("method called");

		List<ListMgmtResponseDto> auditListSearch = auditSearchService.getAuditListSearch(auditSearchRequestDto);
		if(auditListSearch!=null && !auditListSearch.isEmpty()){
			return BuildResponse.buildSuccessResponse(auditListSearch);
		}else{
			return BuildResponse.buildNullResponse("No Results");
		}
	}
	
	
	@RequestMapping(path="/viewAuditCustomerMatchingOutcome/{customerNumber}",method=RequestMethod.GET)
	@ApiOperation(value="API to view the records for transaction from Sanction_Customer_Version")
	public Result getCustomerMatchingOutcome(@PathVariable String customerNumber) {

		List<AuditCustomerVersionResponseDto> customerVersionMatchingOutcome = auditSearchService.getCustomerVersionMatchingOutcome(customerNumber);
		
		if(customerVersionMatchingOutcome!=null && !customerVersionMatchingOutcome.isEmpty()){
			return BuildResponse.buildSuccessResponse(customerVersionMatchingOutcome);
		}else{
			return BuildResponse.buildNullResponse("No Results");
		}
	}
	

	@RequestMapping(path="/viewAuditListMatchingOutcome/{customerNumber}",method=RequestMethod.GET)
	@ApiOperation(value="API to view the records for customer from List_Data_Version")
	public Result getListVersionMatchingOutcome(@PathVariable String customerNumber) {
			List<AuditTransactionVersionResponseDto> listVersionMatchingOutcome = auditSearchService.getListVersionMatchingOutcome(customerNumber);
			
			if(listVersionMatchingOutcome!=null && !listVersionMatchingOutcome.isEmpty()){
				return BuildResponse.buildSuccessResponse(listVersionMatchingOutcome);
			}else{
				return BuildResponse.buildNullResponse("No Results");
			}
	}
	
	
}