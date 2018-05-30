/*package com.sas.sanction.test.controller;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sas.sanction.controller.CustomerSearchAPIController;
import com.sas.sanction.dto.CustomerSearchRequestDto;
import com.sas.sanction.dto.CustomerSearchResponseDto;

@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest(CustomerSearchAPIController.class)
public class CustomerSearchTests {

//	@Autowired
//	private MockMvc mockMvc;
	
	@Autowired
	private CustomerSearchAPIController customerSearchAPIController; 
	
	@Test
	public void searchCustomerByCustomerNo() throws Exception{
		CustomerSearchResponseDto dto = new CustomerSearchResponseDto();
		
		List<CustomerSearchResponseDto> customerNoList = singletonList(dto);
		
		CustomerSearchRequestDto request= new CustomerSearchRequestDto(); 
		request.setCustomerNumber("Cust1");
		
		when(customerSearchAPIController.customerSearch(request)).thenReturn(customerNoList);
		
		mockMvc.perform(get("http://localhost:8080/v1/api/customer/customerSearch"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("", is(dto.getCustomerNumber())));
	}
	
	
	
	
}
*/