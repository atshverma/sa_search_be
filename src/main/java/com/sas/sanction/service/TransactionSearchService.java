package com.sas.sanction.service;

import java.util.List;

import com.sas.sanction.dto.TransactionSearchRequestDto;
import com.sas.sanction.dto.TransactionSearchResponseDto;

public interface TransactionSearchService {

	List<TransactionSearchResponseDto> getTransactionResults(TransactionSearchRequestDto transactionSearchRequestDto);

}
