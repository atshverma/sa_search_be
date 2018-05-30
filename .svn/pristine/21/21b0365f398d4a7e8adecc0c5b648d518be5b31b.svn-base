package com.sas.sanction.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ListDataDaoImpl 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> getListDataForFuzzyLogic(String sql)
	{
		return jdbcTemplate.queryForList(sql);
	}
}
