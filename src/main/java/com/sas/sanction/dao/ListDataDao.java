package com.sas.sanction.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sas.sanction.entities.ListData;

public interface ListDataDao extends JpaRepository<ListData, String>, JpaSpecificationExecutor<ListData>{

	ListData findByListDataSno(int parseInt);

	ListData findByCustomerId(String customerNumber);

}
