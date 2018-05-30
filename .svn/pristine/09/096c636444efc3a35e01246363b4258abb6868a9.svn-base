package com.sas.sanction.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.sas.sanction.dto.CustomerSearchRequestDto;
import com.sas.sanction.dto.CustomerSearchResponseDto;
import com.sas.sanction.entities.SanctionCustomer;


@Component
public class CustomerSearchHelper {

	public List<CustomerSearchResponseDto> convertSearchResultsToResponse(List<SanctionCustomer> sanctionList) {
		List<CustomerSearchResponseDto> list =  new ArrayList<CustomerSearchResponseDto>();
		
		for (SanctionCustomer sanction : sanctionList) {
			CustomerSearchResponseDto dto = new CustomerSearchResponseDto();
			dto.setCurrentSanctionStatus(sanction.getStatus());
			dto.setCustomerNumber(sanction.getCustomerId());
			dto.setDob(sanction.getDateOfBirth());
			dto.setFullName(sanction.getFullName());
			dto.setLastScreeningDateTime(sanction.getCreatedDt());
			dto.setNationalId(sanction.getUniqueId1());
			
			list.add(dto);
		}
		return list;
	}

	public boolean isCustomerSearchRequestDtoEmpty(CustomerSearchRequestDto customerSearchRequestDto) {

		if(!Strings.isNullOrEmpty(customerSearchRequestDto.getNationalId()) || 
				!Strings.isNullOrEmpty(customerSearchRequestDto.getCurrentSanctionStatus()) ||
				!Strings.isNullOrEmpty(customerSearchRequestDto.getCustomerNumber()) ||
				!Strings.isNullOrEmpty(customerSearchRequestDto.getFullname()) ||
				(customerSearchRequestDto.getScreeningDateTime()!=null && customerSearchRequestDto.getScreeningDateTime().length!=0)|| 
				customerSearchRequestDto.getDob()!=null ) 
		{
			return true;
		}
		
		return false;
	}

	
}
