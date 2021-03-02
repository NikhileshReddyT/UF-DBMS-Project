package com.olist.DBMSProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.olist.DBMSProject.model.Location;
import com.olist.DBMSProject.model.RevenueLoacation;

@Repository
public class LocationRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	public List<Location> sellerlocations(){
		System.out.println("Debug: "+jdbcTemplate);
		//jdbcTemplate=new JdbcTemplate();
		String sql="select a.geolocation_lat as lat,a.geolocaiton_lng as lng from jyotik.olist_geolocation a,jyotik.olist_seller b where a.geolocation_zip_code_prefix=b.seller_zip_code_prefix";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Location.class));
	}
	
	public List<Location> customerlocations(){
		String sql=
				"SELECT\n" + 
				"    geolocation_lat,\n" + 
				"    geolocaiton_lng,\n" + 
				"    COUNT(*)\n" + 
				"FROM\n" + 
				"    (\n" + 
				"        SELECT\n" + 
				"            a.geolocation_lat,\n" + 
				"            a.geolocaiton_lng\n" + 
				"        FROM\n" + 
				"            jyotik.olist_geolocation   a,\n" + 
				"            jyotik.olist_customer      b\n" + 
				"        WHERE\n" + 
				"            a.geolocation_zip_code_prefix = b.customer_zip_code_prefix\n" + 
				"    )\n" + 
				"GROUP BY\n" + 
				"    geolocation_lat,\n" + 
				"    geolocaiton_lng\n" ;
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Location.class));
				
		
	}
	
	
	//"    COUNT(*)\n" + 
	public List<Location> orderLocation(){
		
		String sql="SELECT a.geolocation_lat as lat, a.geolocaiton_lng as lng FROM jyotik.olist_geolocation a, jyotik.olist_customer b, jyotik.olist_customer_order c WHERE a.geolocation_zip_code_prefix = b.customer_zip_code_prefix AND b.customer_unique_id = c.customer_unique_id";
		
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Location.class));		
	}
	

	
	public List<RevenueLoacation> revenuelocation(){
		String sql="SELECT geolocation_lat as lat,geolocaiton_lng as lng,CAST((SUM(price)/5) as INTEGER) as count FROM ("+
	       " SELECT"+
	            " a.geolocation_lat,"+
	            "a.geolocaiton_lng,"+
	            "e.price"+
	        " FROM"+
	            " jyotik.olist_geolocation a,"+
	            "jyotik.olist_customer b,"+
	            "jyotik.olist_customer_order c,"+
	            "jyotik.olist_order d,"+
	           " jyotik.olist_order_item  e"+
	       " WHERE"+
	            " a.geolocation_zip_code_prefix = b.customer_zip_code_prefix"+
	            " AND b.customer_unique_id = c.customer_unique_id"+
	            " AND c.customer_id=d.customer_id"+
	            " AND d.order_id=e.order_id"+
	   " )"+
	" GROUP BY"+
	   " geolocation_lat,"+
	   " geolocaiton_lng";
		
		System.out.println(sql);
		 return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(RevenueLoacation.class));
		
	}
	
}
