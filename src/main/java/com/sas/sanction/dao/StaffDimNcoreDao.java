package com.sas.sanction.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sas.sanction.entities.StaffDimNcore;

@Repository
public interface StaffDimNcoreDao extends JpaRepository<StaffDimNcore, Double>
{
	public StaffDimNcore findByStaffNum(String staffNumber);
}
