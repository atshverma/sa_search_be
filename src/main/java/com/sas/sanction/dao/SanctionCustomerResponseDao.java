package com.sas.sanction.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sas.sanction.entities.SanctionCustomerResponse;

@Repository
public interface SanctionCustomerResponseDao extends JpaRepository<SanctionCustomerResponse, Integer>{

}
