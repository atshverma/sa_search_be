package com.sas.sanction.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sas.sanction.entities.SanctionCustomerVersion;

@Repository
public interface SanctionCustomerVersionDao extends JpaRepository<SanctionCustomerVersion, String>, JpaSpecificationExecutor<SanctionCustomerVersion>{

	List<SanctionCustomerVersion> findByCustomerId(String customerNo);

	List<SanctionCustomerVersion> findBySanctionCustomerCustomerId(String customerNumber);

}
