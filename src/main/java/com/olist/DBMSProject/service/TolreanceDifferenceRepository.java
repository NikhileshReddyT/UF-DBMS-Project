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

import com.olist.DBMSProject.model.ToleranceDifference;
import com.olist.DBMSProject.model.Users;
import com.olist.DBMSProject.model.orderstatus;

@Repository
public class TolreanceDifferenceRepository {


	@Autowired
	JdbcTemplate jdbcTemplate;

//		public int showtotalorders() {
//			String sql="select count(*) from JYOTIK.OLIST_ORDER";
//			 int numOfCars = jdbcTemplate.queryForObject(sql, Integer.class);
//
//			return numOfCars;
//		}

		public List<ToleranceDifference> showReviewString()
		{
			String sql="SELECT PRODUCT_CATEGORY_NAME_ENGLISH AS X,Y FROM ( SELECT PRODUCT_CATEGORY_NAME_ENGLISH,AVG(AVGSCORE) AS Y FROM ( SELECT ORDER_ID,ORDER_ITEM_ID,PRODUCT_CATEGORY_NAME_ENGLISH,AVG(REVIEW_SCORE) AS AVGSCORE FROM (SELECT JYOTIK.OLIST_ORDER.ORDER_ID,ORDER_ITEM_ID,PRODUCT_CATEGORY_NAME_ENGLISH,REVIEW_ID,REVIEW_SCORE FROM JYOTIK.OLIST_ORDER_REVIEW_TEMP1,JYOTIK.OLIST_ORDER,JYOTIK.OLIST_ORDER_ITEM,JYOTIK.OLIST_PRODUCT,JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION WHERE JYOTIK.OLIST_ORDER_REVIEW_TEMP1.ORDER_ID = JYOTIK.OLIST_ORDER.ORDER_ID AND JYOTIK.OLIST_ORDER.ORDER_ID = JYOTIK.OLIST_ORDER_ITEM.ORDER_ID AND JYOTIK.OLIST_ORDER_ITEM.PRODUCT_ID = JYOTIK.OLIST_PRODUCT.PRODUCT_ID AND JYOTIK.OLIST_PRODUCT.PRODUCT_CATEGORY_NAME = JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME AND (ORDER_ESTIMATED_DELIVERY_DATE-ORDER_DELIVERED_CUSTOMER_DATE) > 0 AND (ORDER_ESTIMATED_DELIVERY_DATE-ORDER_DELIVERED_CUSTOMER_DATE) < (SELECT AVG(LATE) FROM (SELECT (ORDER_DELIVERED_CUSTOMER_DATE-ORDER_ESTIMATED_DELIVERY_DATE) AS LATE FROM JYOTIK.OLIST_ORDER_REVIEW_TEMP1,JYOTIK.OLIST_ORDER WHERE JYOTIK.OLIST_ORDER_REVIEW_TEMP1.ORDER_ID = JYOTIK.OLIST_ORDER.ORDER_ID AND ORDER_DELIVERED_CUSTOMER_DATE-ORDER_ESTIMATED_DELIVERY_DATE IS NOT NULL AND ORDER_DELIVERED_CUSTOMER_DATE-ORDER_ESTIMATED_DELIVERY_DATE > 0) ) ) GROUP BY ORDER_ID,ORDER_ITEM_ID,PRODUCT_CATEGORY_NAME_ENGLISH ) GROUP BY PRODUCT_CATEGORY_NAME_ENGLISH )\n";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ToleranceDifference.class));
		}

//public float showrepeatrate() {
//	
//	String sql="SELECT a.repeat/b.total * 100 AS repeatrate FROM" + 
//			"    (" + 
//			"        SELECT" + 
//			"            COUNT(*) AS repeat" + 
//			"        FROM" + 
//			"            (" + 
//			"                SELECT" + 
//			"                    *" + 
//			"                FROM" + 
//			"                    (" + 
//			"                        SELECT" + 
//			"                            customer_unique_id," + 
//			"                            COUNT(*) AS count" + 
//			"                        FROM" + 
//			"                            jyotik.olist_customer_order" + 
//			"                        GROUP BY" + 
//			"                            customer_unique_id" + 
//			"                    )" + 
//			"                ORDER BY" + 
//			"                    count DESC" + 
//			"            )" + 
//			"        WHERE" + 
//			"            count > 1" + 
//			"    ) a, " + 
//			"    (" + 
//			"        SELECT" + 
//			"            COUNT(*) AS total" + 
//			"        FROM" + 
//			"            (" + 
//			"                SELECT" + 
//			"                    *" + 
//			"                FROM" + 
//			"                    (" + 
//			"                        SELECT" + 
//			"                            customer_unique_id," + 
//			"                            COUNT(*) AS count" + 
//			"                        FROM" + 
//			"                            jyotik.olist_customer_order" + 
//			"                        GROUP BY" + 
//			"                            customer_unique_id" + 
//			"                    )" + 
//			"                ORDER BY" + 
//			"                    count DESC" + 
//			"            )" + 
//			"    ) b" ;
//	
//	return jdbcTemplate.queryForObject(sql, Float.class);
//
//			
//}

}
