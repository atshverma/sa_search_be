package com.sas.sanction.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sas.sanction.dto.ListMasterDto;
import com.sas.sanction.dto.ListMgmtResponseDto;
import com.sas.sanction.dto.ListMgmtSearchRequestDto;
import com.sas.sanction.entities.ListData;
import com.sas.sanction.entities.ListDataVersion;
import com.sas.sanction.entities.ListMaster;
import com.sas.sanction.utils.SanctionUtils;

@Component
public class ListMgmtHelper {

	@Autowired
	ModelMapper mapper ;
	
	
	public Set<String> convertListMasterToListTypes(List<ListMaster> listMasterList) {
		Set<String> masterDtoList = new HashSet<String>();
		for (ListMaster listMaster : listMasterList) {
			masterDtoList.add(listMaster.getListType());
		}
		return masterDtoList;
	}

	public List<ListMasterDto> convertListMasterToListNames(List<ListMaster> listMasterList) {
		List<ListMasterDto> masterDtoList = new ArrayList<ListMasterDto>();
		for (ListMaster listMaster : listMasterList) {
			ListMasterDto master = new ListMasterDto();
			master.setListType(listMaster.getListType());
			master.setListName(listMaster.getListName());
			master.setListNameUniqueSno(String.valueOf(listMaster.getListMasterSno()));
			masterDtoList.add(master);
		}
		return masterDtoList;
	}

	public List<ListMgmtResponseDto> convertListDataToDto(List<ListData> listData) {
		List<ListMgmtResponseDto> mgmtDtoList = new ArrayList<>();
		
		for (ListData data : listData) {
			ListMgmtResponseDto dto = new ListMgmtResponseDto();
			dto.setCustomerNumber(data.getCustomerId());
			dto.setDob(data.getDob());
			dto.setFullName(data.getFullName());
			dto.setListName(data.getListName());
			dto.setListType(data.getListMaster().getListType());
			dto.setNationalId(data.getIdNum1());
			dto.setListNameUniqueSno(String.valueOf(data.getListMaster().getListMasterSno()));
			dto.setListDataUniqueSno(String.valueOf(data.getListDataSno()));
			
			mgmtDtoList.add(dto);
		}
		return mgmtDtoList;
	}
	
	public ListDataVersion convertListDataToVersion(ListData data) {
		ListDataVersion version = mapper.map(data, ListDataVersion.class);
		
		return version;
	}

	public boolean isListMgmtSearchDtoEmpty(ListMgmtSearchRequestDto listMgmtSearchDto) {

		if(SanctionUtils.isStringNotNullorEmpty(listMgmtSearchDto.getCustomerName())|| 
				SanctionUtils.isStringNotNullorEmpty(listMgmtSearchDto.getListNameUniqueSno()) ||
						SanctionUtils.isStringNotNullorEmpty(listMgmtSearchDto.getNationalId()) ||
								listMgmtSearchDto.getDob()!=null ||  
								SanctionUtils.isStringNotNullorEmpty(listMgmtSearchDto.getListType())
				){
			return true;
		}
		
		return false;
	}

}
