package com.sas.sanction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.sanction.dao.ListDataDao;
import com.sas.sanction.dao.ListDataVersionDao;
import com.sas.sanction.dao.ListMasterDao;
import com.sas.sanction.dao.SanctionCustomerDao;
import com.sas.sanction.dao.SanctionCustomerVersionDao;
import com.sas.sanction.dto.AuditCustomerVersionResponseDto;
import com.sas.sanction.dto.AuditTransactionVersionResponseDto;
import com.sas.sanction.dto.CustomerSearchRequestDto;
import com.sas.sanction.dto.CustomerSearchResponseDto;
import com.sas.sanction.dto.ListMgmtResponseDto;
import com.sas.sanction.dto.ListMgmtSearchRequestDto;
import com.sas.sanction.entities.ListData;
import com.sas.sanction.entities.ListDataVersion;
import com.sas.sanction.entities.ListMaster;
import com.sas.sanction.entities.SanctionCustomer;
import com.sas.sanction.entities.SanctionCustomerVersion;
import com.sas.sanction.helper.AuditSearchHelper;
import com.sas.sanction.helper.CustomerSearchHelper;
import com.sas.sanction.helper.ListMgmtHelper;
import com.sas.sanction.service.AuditSearchService;
import com.sas.sanction.specification.ListMgmtDataSpec;
import com.sas.sanction.specification.SanctionCustomerDataSpec;
import com.sas.sanction.utils.SanctionUtils;

@Service
public class AuditSearchServiceImpl implements AuditSearchService {

	@Autowired
	SanctionCustomerDao sanctionCustomerDao;
	
	@Autowired
	SanctionCustomerVersionDao sanctionCustomerVersionDao;
	
	@Autowired
	AuditSearchHelper auditHelper;
	
	@Autowired
	ListMasterDao listMasterDao; 
	
	@Autowired
	ListDataDao listDataDao;
	
	@Autowired
	ListDataVersionDao listDataVersionDao; 
	
	@Autowired
	ListMgmtHelper listMgmtHelper;
	
	@Autowired
	CustomerSearchHelper customerSearchHelper;
	
	@Override
	public List<CustomerSearchResponseDto> getAuditCustomerSearch(CustomerSearchRequestDto auditSearchRequestDto) {
		
		List<CustomerSearchResponseDto> responseList = null;
		
		boolean shouldSearch =  auditHelper.isCustomerVersionSearchRequestDtoEmpty(auditSearchRequestDto);
		if(shouldSearch){
			SanctionCustomerDataSpec sanctionRequestData = new SanctionCustomerDataSpec(auditSearchRequestDto);
			List<SanctionCustomer> sanctionList = sanctionCustomerDao.findAll(sanctionRequestData);
			
			if(!sanctionList.isEmpty() && sanctionList!=null) {
				 responseList = customerSearchHelper.convertSearchResultsToResponse(sanctionList);
			}
		}
		return responseList;
	}
	
	
	@Override
	public List<ListMgmtResponseDto> getAuditListSearch(ListMgmtSearchRequestDto auditSearchRequestDto) {
		List<ListMgmtResponseDto> listMgmtDtoList = null;
		List<ListMaster> listTypes = null;
		
		boolean shouldSearch = auditHelper.isListMgmtVersionSearchDtoEmpty(auditSearchRequestDto);
		
		if(shouldSearch){
			if(SanctionUtils.isStringNotNullorEmpty(auditSearchRequestDto.getListType())){
				 listTypes = listMasterDao.findByListType(auditSearchRequestDto.getListType());
			}
			
			ListMgmtDataSpec listMgmtDataSpec = new ListMgmtDataSpec(auditSearchRequestDto, listTypes);
			List<ListData> listData = listDataDao.findAll(listMgmtDataSpec);
			
			if(listData!=null && !listData.isEmpty()){
				listMgmtDtoList = listMgmtHelper.convertListDataToDto(listData);
			}
		}
		
		return listMgmtDtoList;
	}


	@Override
	public List<AuditCustomerVersionResponseDto> getCustomerVersionMatchingOutcome(String customerNumber) {
		List<AuditCustomerVersionResponseDto> responseDtoList = null;
		
		SanctionCustomer customer = sanctionCustomerDao.findByCustomerId(customerNumber);  
		
		if(customer!=null){
			List<SanctionCustomerVersion> sanctionCustomerVersionList = sanctionCustomerVersionDao.findBySanctionCustomerCustomerId(customerNumber);
			
			if(sanctionCustomerVersionList!=null && !sanctionCustomerVersionList.isEmpty()){
				responseDtoList = auditHelper.convertCustomerVersionResultsToOutcomeResponse(sanctionCustomerVersionList);
			}
		}
		
		
		return responseDtoList;
	}


	@Override
	public List<AuditTransactionVersionResponseDto> getListVersionMatchingOutcome(String customerNumber) {
		 List<AuditTransactionVersionResponseDto> responseDtoList = null;
		 
		ListData data =  listDataDao.findByCustomerId(customerNumber);
		 
		if(data!=null){
			 List<ListDataVersion> listDataVersionList  = listDataVersionDao.findByListDataListDataSno(data.getListDataSno());
			 
			 if(listDataVersionList!=null && !listDataVersionList.isEmpty()){
				 responseDtoList =  auditHelper.convertListVersionResultsToOutcomeResponse(listDataVersionList);
			 }
		}
		return responseDtoList;
	}


}
