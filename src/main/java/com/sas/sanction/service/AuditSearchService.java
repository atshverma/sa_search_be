package com.sas.sanction.service;

import java.util.List;

import com.sas.sanction.dto.AuditCustomerVersionResponseDto;
import com.sas.sanction.dto.AuditTransactionVersionResponseDto;
import com.sas.sanction.dto.CustomerSearchRequestDto;
import com.sas.sanction.dto.CustomerSearchResponseDto;
import com.sas.sanction.dto.ListMgmtResponseDto;
import com.sas.sanction.dto.ListMgmtSearchRequestDto;

public interface AuditSearchService {

	List<CustomerSearchResponseDto> getAuditCustomerSearch(CustomerSearchRequestDto auditSearchRequestDto);

	List<ListMgmtResponseDto> getAuditListSearch(ListMgmtSearchRequestDto auditSearchRequestDto);

	List<AuditCustomerVersionResponseDto> getCustomerVersionMatchingOutcome(String customerNumber);

	List<AuditTransactionVersionResponseDto> getListVersionMatchingOutcome(String customerNumber);

}
