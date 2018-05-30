package com.sas.sanction.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sas.sanction.entities.ApplDimNcore;

@Repository
public interface ApplDimNcoreDao extends JpaRepository<ApplDimNcore, Long>
{
	public ApplDimNcore findByCustNum(String custNo);
}
