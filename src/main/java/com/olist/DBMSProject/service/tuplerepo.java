package com.olist.DBMSProject.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.olist.DBMSProject.model.Users;
import com.olist.DBMSProject.model.orderstatus;

@Repository
public class tuplerepo {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;

		public int showtotalorders() {
			String sql="select count(*) from JYOTIK.OLIST_ORDER";
			 int numOfCars = jdbcTemplate.queryForObject(sql, Integer.class);

			return numOfCars;
		}
		
		public List<orderstatus> showorderstatus() 
		{
			
			String sql="select ORDER_STATUS as status,count(*) as orders from jyotik.OLIST_ORDER group by ORDER_STATUS";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(orderstatus.class));
		}
		
		public double showReviewScore()
		{
			String sql="";
			return jdbcTemplate.queryForObject(sql, Integer.class);
		}
		

public float showrepeatrate() {
	
	String sql="SELECT a.repeat/b.total * 100 AS repeatrate FROM" + 
			"    (" + 
			"        SELECT" + 
			"            COUNT(*) AS repeat" + 
			"        FROM" + 
			"            (" + 
			"                SELECT" + 
			"                    *" + 
			"                FROM" + 
			"                    (" + 
			"                        SELECT" + 
			"                            customer_unique_id," + 
			"                            COUNT(*) AS count" + 
			"                        FROM" + 
			"                            jyotik.olist_customer_order" + 
			"                        GROUP BY" + 
			"                            customer_unique_id" + 
			"                    )" + 
			"                ORDER BY" + 
			"                    count DESC" + 
			"            )" + 
			"        WHERE" + 
			"            count > 1" + 
			"    ) a, " + 
			"    (" + 
			"        SELECT" + 
			"            COUNT(*) AS total" + 
			"        FROM" + 
			"            (" + 
			"                SELECT" + 
			"                    *" + 
			"                FROM" + 
			"                    (" + 
			"                        SELECT" + 
			"                            customer_unique_id," + 
			"                            COUNT(*) AS count" + 
			"                        FROM" + 
			"                            jyotik.olist_customer_order" + 
			"                        GROUP BY" + 
			"                            customer_unique_id" + 
			"                    )" + 
			"                ORDER BY" + 
			"                    count DESC" + 
			"            )" + 
			"    ) b" ;
	
	return jdbcTemplate.queryForObject(sql, Float.class);

			
}

}
