package com.sas.sanction.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sas.sanction.entities.SanctionCustomer;

@Repository
public interface SanctionCustomerDao extends JpaRepository<SanctionCustomer, String>, JpaSpecificationExecutor<SanctionCustomer>{

	SanctionCustomer findByCustomerId(String customerNumber);
	//public SanctionRequestData findByCustomerId(String customerId);

	
}
