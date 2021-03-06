package com.sas.sanction.service;

import java.util.List;

import com.sas.sanction.dto.CustomerSearchRequestDto;
import com.sas.sanction.dto.CustomerSearchResponseDto;
import com.sas.sanction.webservices.SanctionRequest;
import com.sas.sanction.webservices.SanctionResponse;

public interface CustomerSearchService {

	List<CustomerSearchResponseDto> getCustomerSearchResults(CustomerSearchRequestDto customerSearchRequestDto);
	public SanctionResponse getSanctionDataResponse(SanctionRequest getSanctionDataRequest);
	

}
