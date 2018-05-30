package com.sas.sanction.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sas.sanction.entities.AccDimNcore;

@Repository
public interface AccDimNcoreDao extends JpaRepository<AccDimNcore, Double>{
	public AccDimNcore findByAccNum(String accountNumber);

}
