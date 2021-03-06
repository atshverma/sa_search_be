package com.sas.sanction.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.sanction.dao.SanctionCustomerDao;
import com.sas.sanction.dto.CustomerSearchRequestDto;
import com.sas.sanction.dto.CustomerSearchResponseDto;
import com.sas.sanction.entities.SanctionCustomer;
import com.sas.sanction.helper.CustomerSearchHelper;
import com.sas.sanction.service.CustomerSearchService;
import com.sas.sanction.specification.SanctionCustomerDataSpec;
import com.sas.sanction.webservices.SanctionRequest;
import com.sas.sanction.webservices.SanctionResponse;

@Service
public class CustomerSearchServiceImpl implements CustomerSearchService{

	@Autowired
	SanctionCustomerDao sanctionDao; 

	@Autowired
	CustomerSearchHelper customerHelper;
	
	private static Logger logger =  Logger.getLogger(CustomerSearchServiceImpl.class);
	
	@Override
	public List<CustomerSearchResponseDto> getCustomerSearchResults(CustomerSearchRequestDto customerSearchRequestDto) {
		
		List<CustomerSearchResponseDto> responseList = null;
		
		boolean shouldSearch = customerHelper.isCustomerSearchRequestDtoEmpty(customerSearchRequestDto);
		
		if(shouldSearch){
			SanctionCustomerDataSpec sanctionRequestData = new SanctionCustomerDataSpec(customerSearchRequestDto);
			List<SanctionCustomer> sanctionList = sanctionDao.findAll(sanctionRequestData);
			
			if(!sanctionList.isEmpty() && sanctionList!=null) {
				 responseList = customerHelper.convertSearchResultsToResponse(sanctionList);
			}
			logger.info("Response sent");
		}
		return responseList;
	}

	@Override
	public SanctionResponse getSanctionDataResponse(SanctionRequest getSanctionDataRequest) 
	{
		SanctionResponse response = new SanctionResponse();
		//String status = sanctionDao.findByCustomerId(getSanctionDataRequest.getCustomerId()).getStatus();
//		if(status != null)
//			response.setStatus(status);
		//else
			
		return response;
	}

	

}
