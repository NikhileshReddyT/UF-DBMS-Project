package com.olist.DBMSProject.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.olist.DBMSProject.model.TotalSalesPerMonth;
import com.olist.DBMSProject.model.TotalSalesPerYear;
//import com.olist.DBMSProject.model.Users;
//import com.olist.DBMSProject.model.orderstatus;

@Repository
public class TotalSalesVsTimeRepository
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	public List<TotalSalesPerYear> showSalesVsYear()
	{
		String sql="SELECT SUM(PRICE) as Sales, Year FROM (SELECT PRICE, EXTRACT(YEAR FROM ORDER_PURCHASE_TIMESTAMP) as Year FROM JYOTIK.OLIST_ORDER, JYOTIK.OLIST_ORDER_ITEM WHERE JYOTIK.OLIST_ORDER.ORDER_ID = JYOTIK.OLIST_ORDER_ITEM.ORDER_ID) GROUP BY Year ORDER BY Year";
//		System.out.println(sql);
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TotalSalesPerYear.class));
	}
	public List<TotalSalesPerMonth> showSalesVsMonth()
	{
		String sql="SELECT t1.Year as Years, t1.Month as Months, NVL(t2.Sales, 0) as Monthwise_Sales from ((SELECT * FROM (SELECT DISTINCT(Year) as Year FROM (SELECT EXTRACT(YEAR FROM ORDER_PURCHASE_TIMESTAMP) as Year FROM JYOTIK.OLIST_ORDER)) CROSS JOIN (SELECT DISTINCT(Month) FROM (SELECT EXTRACT(MONTH FROM ORDER_PURCHASE_TIMESTAMP) as Month FROM JYOTIK.OLIST_ORDER)) ORDER BY Month, Year) t1 LEFT OUTER JOIN (SELECT * FROM (SELECT Year, Month, SUM(PRICE) as Sales FROM (SELECT PRICE, EXTRACT(MONTH FROM ORDER_PURCHASE_TIMESTAMP) as Month, EXTRACT(YEAR FROM ORDER_PURCHASE_TIMESTAMP) as Year FROM JYOTIK.OLIST_ORDER, JYOTIK.OLIST_ORDER_ITEM WHERE JYOTIK.OLIST_ORDER.ORDER_ID = JYOTIK.OLIST_ORDER_ITEM.ORDER_ID) GROUP BY Year, Month ORDER BY Month)) t2 ON t1.Year = t2.Year and t1.month=t2.month)";
//		System.out.println(sql);
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TotalSalesPerMonth.class));
	}			
}