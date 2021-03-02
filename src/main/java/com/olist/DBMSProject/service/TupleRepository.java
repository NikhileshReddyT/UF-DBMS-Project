package com.olist.DBMSProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.olist.DBMSProject.model.ToleranceDifference;

@Repository
public class TupleRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ToleranceDifference> showTuple()
	{
		String sql = "select TABLE_NAME as X,num_rows as Y from user_tables where table_name like '%OLIST%'";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ToleranceDifference.class));
	}
}
