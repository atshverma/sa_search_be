package com.sas.sanction.controller;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sas.sanction.dto.ListMasterDto;
import com.sas.sanction.dto.ListMgmtResponseDto;
import com.sas.sanction.dto.ListMgmtSearchRequestDto;
import com.sas.sanction.dto.ListMgmtUpdateRequestDto;
import com.sas.sanction.dto.Result;
import com.sas.sanction.service.ListMgmtService;
import com.sas.sanction.utils.BuildResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path="/v1/api/listMgmt")
public class ListMgmtAPIController {
	
	private static Logger logger =  Logger.getLogger(ListMgmtAPIController.class);
	
	@Autowired
	ListMgmtService listMgmtService;
	
	
	@RequestMapping(path="/searchListData",method=RequestMethod.POST)
	@ApiOperation(value="API to search the List_Data, accepts search params in JSON format")
	public Result searchListData(@RequestBody ListMgmtSearchRequestDto listMgmtSearchDto) {
		System.out.println("searchListData method called");
		logger.info("searchListData method called");

		 List<ListMgmtResponseDto> searchListData = listMgmtService.searchListData(listMgmtSearchDto);
		
		if(searchListData!=null && !searchListData.isEmpty()){
			return BuildResponse.buildSuccessResponse(searchListData);
		}else{
			return BuildResponse.buildNullResponse("No Results");
		}
	}

	@RequestMapping(path="/updateListData",method=RequestMethod.POST)
	@ApiOperation(value="Search results can be updated via this API, along with version creation")
	public Result updateListData(@RequestBody ListMgmtUpdateRequestDto listMgmtSearchDto) {
		System.out.println("updateListData method called");
		logger.info("updateListData method called");
		
		if(StringUtils.isEmpty(listMgmtSearchDto.getListDataUniqueSno())){
			return BuildResponse.buildNullResponse("Missing listDataUniqueSno");
		}
		
		 String updateListData = listMgmtService.updateListData(listMgmtSearchDto);
		
		 if(updateListData.equals("success")){
				return BuildResponse.buildSuccessResponse("Data has been updated successfully");
		 }else if(updateListData.equals("failed")){
				return BuildResponse.buildErrorResponse("Error while saving records");
		 }
		return null;
	}

	
	@RequestMapping(path="/fetchListTypes",method=RequestMethod.GET)
	@ApiOperation(value="API to list down distinct List Type available in List_Master")
	public Result fetchListTypes() {
		
		Set<String> fetchListTypes = listMgmtService.fetchListTypes();
		if(fetchListTypes!=null && !fetchListTypes.isEmpty()){
			return BuildResponse.buildSuccessResponse(fetchListTypes);
		}else{
			return BuildResponse.buildNullResponse("No Results");
		}
	}
	
	@RequestMapping(path="/fetchListNames/{listType}",method=RequestMethod.GET)
	@ApiOperation(value="API to fetch list names on the basis of List Type")
	public Result fetchListNames(@PathVariable String listType) {
		List<ListMasterDto> fetchListNames = listMgmtService.fetchListNames(listType);
		if(fetchListNames!=null && !fetchListNames.isEmpty()){
			return BuildResponse.buildSuccessResponse(fetchListNames);
		}else{
			return BuildResponse.buildNullResponse("No Results");
		}
	}
	
}
