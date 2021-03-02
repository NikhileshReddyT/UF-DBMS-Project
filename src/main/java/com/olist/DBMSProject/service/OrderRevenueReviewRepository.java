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

import com.olist.DBMSProject.model.OrderRevenueReview;
import com.olist.DBMSProject.model.SeasonAnalysis;
import com.olist.DBMSProject.model.Users;
import com.olist.DBMSProject.model.orderstatus;

@Repository
public class OrderRevenueReviewRepository {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
        public List<OrderRevenueReview> showeachordertype(){
        	
        	String sql="SELECT\n" + 
        			"    product_category_name_english,\n" + 
        			"    revenue,\n" + 
        			"    orders,\n" + 
        			"    rating\n" + 
        			"FROM\n" + 
        			"    (\n" + 
        			"        SELECT\n" + 
        			"            product_category_name,\n" + 
        			"            SUM(price) AS revenue,\n" + 
        			"            COUNT(order_id) AS orders,\n" + 
        			"            AVG(review_score) AS rating\n" + 
        			"        FROM\n" + 
        			"            (\n" + 
        			"                SELECT\n" + 
        			"                    *\n" + 
        			"                FROM\n" + 
        			"                    (\n" + 
        			"                        SELECT\n" + 
        			"                            *\n" + 
        			"                        FROM\n" + 
        			"                            ( (\n" + 
        			"                                SELECT\n" + 
        			"                                    seller_id,\n" + 
        			"                                    price,\n" + 
        			"                                    product_id,\n" + 
        			"                                    order_id\n" + 
        			"                                FROM\n" + 
        			"                                    jyotik.olist_order_item\n" + 
        			"                            )\n" + 
        			"                            NATURAL JOIN (\n" + 
        			"                                SELECT\n" + 
        			"                                    product_id,\n" + 
        			"                                    seller_id,\n" + 
        			"                                    product_category_name\n" + 
        			"                                FROM\n" + 
        			"                                    jyotik.olist_product\n" + 
        			"                            ) )\n" + 
        			"                    )\n" + 
        			"                    NATURAL JOIN (\n" + 
        			"                        SELECT\n" + 
        			"                            order_id,\n" + 
        			"                            review_score\n" + 
        			"                        FROM\n" + 
        			"                            jyotik.olist_order_review_temp1\n" + 
        			"                    )\n" + 
        			"            )\n" + 
        			"        GROUP BY\n" + 
        			"            product_category_name\n" + 
        			"    ) a,\n" + 
        			"    jyotik.olist_category_name_translation b\n" + 
        			"WHERE\n" + 
        			"    a.product_category_name = b.product_category_name";
        	 return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(OrderRevenueReview.class));
        	
        }
		

}
