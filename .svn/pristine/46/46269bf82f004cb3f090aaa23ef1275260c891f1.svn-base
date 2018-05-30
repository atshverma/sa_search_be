package com.sas.sanction.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sas.sanction.entities.ListMaster;

@Repository
public interface ListMasterDao extends JpaRepository<ListMaster, String>{

	List<ListMaster> findDistinctListNameByListType(String listType);

	List<ListMaster> findByListType(String listType);

}
