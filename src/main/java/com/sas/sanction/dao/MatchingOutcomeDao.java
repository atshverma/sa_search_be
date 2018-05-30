package com.sas.sanction.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sas.sanction.entities.MatchingOutcome;

@Repository
public interface MatchingOutcomeDao extends JpaRepository<MatchingOutcome, String>{

	List<MatchingOutcome> findBySanctionCustomerCustomerId(String customerId);

	List<MatchingOutcome> findBySanctionCustomerTransactionNo(String trasactionNo);

}
