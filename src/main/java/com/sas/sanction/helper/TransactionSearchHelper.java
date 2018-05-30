package com.sas.sanction.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sas.sanction.dto.TransactionSearchRequestDto;
import com.sas.sanction.dto.TransactionSearchResponseDto;
import com.sas.sanction.entities.SanctionCustomer;
import com.sas.sanction.utils.SanctionUtils;

@Component
public class TransactionSearchHelper {


	public List<TransactionSearchResponseDto> convertSearchResultsToResponse(List<SanctionCustomer> transactionList) {
		List<TransactionSearchResponseDto> list =  new ArrayList<TransactionSearchResponseDto>();
		
		for (SanctionCustomer transaction : transactionList) {
			TransactionSearchResponseDto dto = new TransactionSearchResponseDto();
			dto.setCurrentSanctionStatus(transaction.getStatus());
			dto.setRefNumber(transaction.getTransactionNo());
			dto.setType(transaction.getTransactionType());
			dto.setTransactionDateTime(transaction.getCreatedDt());
			dto.setAmount(new BigDecimal(transaction.getTransactionAmount()));
			dto.setTransactionSanctionStatus(transaction.getStatus());
			dto.setLastScreeningDate(transaction.getCreatedDt());
			dto.setName(transaction.getFullName());
			
			list.add(dto);
		}
		return list;
	}

	public boolean isTransactionSearchRequestDtoEmpty(TransactionSearchRequestDto transactionSearchRequestDto) {

		if(SanctionUtils.isStringNotNullorEmpty(transactionSearchRequestDto.getTransactionRefNumber()) || 
				SanctionUtils.isStringNotNullorEmpty(transactionSearchRequestDto.getCurrentSanctionStatus()) ||
				SanctionUtils.isStringNotNullorEmpty(transactionSearchRequestDto.getTransactionType()) ||
//				transactionSearchRequestDto.getTransactionDate()!=null ||
				//transactionSearchRequestDto.getTransactionStartDate()!=null ||
				//		transactionSearchRequestDto.getTransactionEndDate()!=null ||
				(transactionSearchRequestDto.getTransactionDateTime()!=null && transactionSearchRequestDto.getTransactionDateTime().length!=0)||
					transactionSearchRequestDto.getAmountLess()!=null ||
						transactionSearchRequestDto.getAmountGreater()!=null) 
		{
			return true;
		}
		
		return false;
	}

}
