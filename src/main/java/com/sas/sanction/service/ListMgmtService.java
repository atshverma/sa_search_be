package com.sas.sanction.service;

import java.util.List;
import java.util.Set;

import com.sas.sanction.dto.ListMasterDto;
import com.sas.sanction.dto.ListMgmtSearchRequestDto;
import com.sas.sanction.dto.ListMgmtUpdateRequestDto;
import com.sas.sanction.dto.ListMgmtResponseDto;

public interface ListMgmtService {

	List<ListMgmtResponseDto> searchListData(ListMgmtSearchRequestDto listMgmtSearchDto);

	List<ListMasterDto> fetchListNames(String listType);

	Set<String> fetchListTypes();

	String updateListData(ListMgmtUpdateRequestDto listMgmtSearchDto);

}
