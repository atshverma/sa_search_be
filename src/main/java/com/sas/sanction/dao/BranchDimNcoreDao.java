package com.sas.sanction.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sas.sanction.entities.BranchDimNcore;

@Repository
public interface BranchDimNcoreDao extends JpaRepository<BranchDimNcore, Double>
{
	public BranchDimNcore findByBranchNum(String branchNumber);
}
