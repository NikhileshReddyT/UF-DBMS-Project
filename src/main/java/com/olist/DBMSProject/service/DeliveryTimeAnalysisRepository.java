package com.olist.DBMSProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.olist.DBMSProject.model.Location;
import com.olist.DBMSProject.model.ProductDelayPercentage;
import com.olist.DBMSProject.model.SellerDelay;

@Repository
public class DeliveryTimeAnalysisRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<SellerDelay> showSellerDeliveryDelay()
	{
		String sql = "select * from (select SELLER_ID,COUNTDELAY*DELAY as para,COUNTDELAY as delayCount ,DELAY as delayTime  from ((SELECT seller_id, COUNT(*) AS countdelay FROM ( SELECT seller_id, order_id, order_purchase_timestamp FROM jyotik.olist_order NATURAL JOIN jyotik.olist_order_item WHERE order_delivered_customer_date > order_estimated_delivery_date ) GROUP BY seller_id ORDER BY countdelay DESC)  NATURAL JOIN ( SELECT seller_id, avg(delay) AS delay FROM ( SELECT seller_id, order_id, order_purchase_timestamp, order_delivered_customer_date-order_estimated_delivery_date as delay FROM jyotik.olist_order NATURAL JOIN jyotik.olist_order_item WHERE order_delivered_customer_date > order_estimated_delivery_date ) GROUP BY seller_id ORDER BY delay DESC ) ) order by para desc     ) where rownum <=10";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SellerDelay.class));
	}
	
	public List<ProductDelayPercentage> showProductDelayPrecentage()
	{
		String sql = "SELECT a.year, a.month, ( a.latecount / b.totalcount ) * 100 AS delayPercentage FROM ( SELECT year, month, COUNT(*) AS latecount FROM ( SELECT seller_id, order_id, EXTRACT(YEAR FROM order_purchase_timestamp) AS year, EXTRACT(MONTH FROM order_purchase_timestamp) AS month FROM jyotik.olist_order NATURAL JOIN jyotik.olist_order_item WHERE order_delivered_customer_date > order_estimated_delivery_date ) GROUP BY year, month ORDER BY year, month ) a, ( SELECT year, month, COUNT(*) AS totalcount FROM ( SELECT seller_id, order_id, EXTRACT(YEAR FROM order_purchase_timestamp) AS year, EXTRACT(MONTH FROM order_purchase_timestamp) AS month FROM jyotik.olist_order NATURAL JOIN jyotik.olist_order_item ) GROUP BY year, month ORDER BY year, month ) b WHERE a.year = b.year AND a.month = b.month";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductDelayPercentage.class));

	}
	
	public List<Location> showDelayOrder()
	{
		String sql = "select b.GEOLOCATION_LAT as lat,b.GEOLOCAITON_LNG as lng from (SELECT order_id, customer_id, customer_unique_id, CUSTOMER_ZIP_CODE_PREFIX FROM jyotik.olist_order  NATURAL JOIN jyotik.olist_customer_order  NATURAL JOIN jyotik.olist_customer where ORDER_DELIVERED_CUSTOMER_DATE > ORDER_ESTIMATED_DELIVERY_DATE) a,jyotik.OLIST_GEOLOCATION b where a.customer_ZIP_CODE_PREFIX=b.GEOLOCATION_ZIP_CODE_PREFIX";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Location.class));
	}
}

