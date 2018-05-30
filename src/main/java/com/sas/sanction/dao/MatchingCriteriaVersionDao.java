package com.sas.sanction.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sas.sanction.entities.MatchingAttributeConfigVersion;

@Repository
public interface MatchingCriteriaVersionDao extends JpaRepository<MatchingAttributeConfigVersion, String>{

	List<MatchingAttributeConfigVersion> findByMatchingAttributeConfigMacSno(int macSno);

}
