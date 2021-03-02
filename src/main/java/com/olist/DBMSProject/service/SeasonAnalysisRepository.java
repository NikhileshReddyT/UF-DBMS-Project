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

import com.olist.DBMSProject.model.SeasonAnalysis;
import com.olist.DBMSProject.model.Users;
import com.olist.DBMSProject.model.orderstatus;

@Repository
public class SeasonAnalysisRepository {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
        public List<SeasonAnalysis> showeachordertype(){
        	
        	String sql="SELECT year,season,PRODUCT_CATEGORY_NAME_ENGLISH,sum(count) as total\n" + 
        			"FROM(\n" + 
        			"(select year,month,PRODUCT_CATEGORY_NAME_ENGLISH,count,total,'Fall' as season from (select EXTRACT(YEAR FROM ORDER_PURCHASE_TIMESTAMP) as year,EXTRACT(MONTH FROM ORDER_PURCHASE_TIMESTAMP) as month,PRODUCT_CATEGORY_NAME_ENGLISH,count,total FROM (SELECT JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP,\n" + 
        			"       COUNT(*) as count, SUM(JYOTIK.OLIST_ORDER_ITEM.PRICE) as total\n" + 
        			"FROM JYOTIK.OLIST_ORDER,JYOTIK.OLIST_ORDER_ITEM,JYOTIK.OLIST_PRODUCT,JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION\n" + 
        			"WHERE JYOTIK.OLIST_ORDER.ORDER_ID = JYOTIK.OLIST_ORDER_ITEM.ORDER_ID\n" + 
        			"AND JYOTIK.OLIST_ORDER_ITEM.PRODUCT_ID = JYOTIK.OLIST_PRODUCT.PRODUCT_ID\n" + 
        			"AND JYOTIK.OLIST_PRODUCT.PRODUCT_CATEGORY_NAME = JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME\n" + 
        			"\n" + 
        			"GROUP BY JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP\n" + 
        			"ORDER BY JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP)) where MONTH>6 and MONTH<10)\n" + 
        			"UNION\n" + 
        			"\n" + 
        			"(select year,month,PRODUCT_CATEGORY_NAME_ENGLISH,count,total,'Spring' as season from (select EXTRACT(YEAR FROM ORDER_PURCHASE_TIMESTAMP) as year,EXTRACT(MONTH FROM ORDER_PURCHASE_TIMESTAMP) as month,PRODUCT_CATEGORY_NAME_ENGLISH,count,total FROM (SELECT JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP,\n" + 
        			"       COUNT(*) as count, SUM(JYOTIK.OLIST_ORDER_ITEM.PRICE) as total\n" + 
        			"FROM JYOTIK.OLIST_ORDER,JYOTIK.OLIST_ORDER_ITEM,JYOTIK.OLIST_PRODUCT,JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION\n" + 
        			"WHERE JYOTIK.OLIST_ORDER.ORDER_ID = JYOTIK.OLIST_ORDER_ITEM.ORDER_ID\n" + 
        			"AND JYOTIK.OLIST_ORDER_ITEM.PRODUCT_ID = JYOTIK.OLIST_PRODUCT.PRODUCT_ID\n" + 
        			"AND JYOTIK.OLIST_PRODUCT.PRODUCT_CATEGORY_NAME = JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME\n" + 
        			"\n" + 
        			"GROUP BY JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP\n" + 
        			"ORDER BY JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP)) where MONTH>0 and MONTH<4)\n" + 
        			"\n" + 
        			"UNION\n" + 
        			"(select year,month,PRODUCT_CATEGORY_NAME_ENGLISH,count,total,'Summer' as season from (select EXTRACT(YEAR FROM ORDER_PURCHASE_TIMESTAMP) as year,EXTRACT(MONTH FROM ORDER_PURCHASE_TIMESTAMP) as month,PRODUCT_CATEGORY_NAME_ENGLISH,count,total FROM (SELECT JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP,\n" + 
        			"       COUNT(*) as count, SUM(JYOTIK.OLIST_ORDER_ITEM.PRICE) as total\n" + 
        			"FROM JYOTIK.OLIST_ORDER,JYOTIK.OLIST_ORDER_ITEM,JYOTIK.OLIST_PRODUCT,JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION\n" + 
        			"WHERE JYOTIK.OLIST_ORDER.ORDER_ID = JYOTIK.OLIST_ORDER_ITEM.ORDER_ID\n" + 
        			"AND JYOTIK.OLIST_ORDER_ITEM.PRODUCT_ID = JYOTIK.OLIST_PRODUCT.PRODUCT_ID\n" + 
        			"AND JYOTIK.OLIST_PRODUCT.PRODUCT_CATEGORY_NAME = JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME\n" + 
        			"\n" + 
        			"GROUP BY JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP\n" + 
        			"ORDER BY JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP)) where MONTH>9 and MONTH<13)\n" + 
        			"UNION\n" + 
        			"(select year,month,PRODUCT_CATEGORY_NAME_ENGLISH,count,total,'Winter' as season from (select EXTRACT(YEAR FROM ORDER_PURCHASE_TIMESTAMP) as year,EXTRACT(MONTH FROM ORDER_PURCHASE_TIMESTAMP) as month,PRODUCT_CATEGORY_NAME_ENGLISH,count,total FROM (SELECT JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP,\n" + 
        			"       COUNT(*) as count, SUM(JYOTIK.OLIST_ORDER_ITEM.PRICE) as total\n" + 
        			"FROM JYOTIK.OLIST_ORDER,JYOTIK.OLIST_ORDER_ITEM,JYOTIK.OLIST_PRODUCT,JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION\n" + 
        			"WHERE JYOTIK.OLIST_ORDER.ORDER_ID = JYOTIK.OLIST_ORDER_ITEM.ORDER_ID\n" + 
        			"AND JYOTIK.OLIST_ORDER_ITEM.PRODUCT_ID = JYOTIK.OLIST_PRODUCT.PRODUCT_ID\n" + 
        			"AND JYOTIK.OLIST_PRODUCT.PRODUCT_CATEGORY_NAME = JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME\n" + 
        			"\n" + 
        			"GROUP BY PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP\n" + 
        			"ORDER BY PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP)) where MONTH>3 and MONTH<7)\n" + 
        			")\n" + 
        			"where PRODUCT_CATEGORY_NAME_ENGLISH in('air_conditioning','sports_leisure','furniture_decor','health_beauty','baby','stationery','electronics','air_conditioning')\n" + 
        			"\n" + 
        			"GROUP BY year,season,PRODUCT_CATEGORY_NAME_ENGLISH\n" + 
        			"\n" + 
        			"ORDER BY year asc,season,PRODUCT_CATEGORY_NAME_ENGLISH";
        	 return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SeasonAnalysis.class));
        	
        }
		public List<SeasonAnalysis> showrankwiseorder() {
			String sql="SELECT year,season,sum(count) as count,sum(total) as total\n" + 
					"FROM(\n" + 
					"(select year,month,PRODUCT_CATEGORY_NAME_ENGLISH,count,total,'Fall' as season from (select EXTRACT(YEAR FROM ORDER_PURCHASE_TIMESTAMP) as year,EXTRACT(MONTH FROM ORDER_PURCHASE_TIMESTAMP) as month,PRODUCT_CATEGORY_NAME_ENGLISH,count,total FROM (SELECT JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP,\n" + 
					"       COUNT(*) as count, SUM(JYOTIK.OLIST_ORDER_ITEM.PRICE) as total\n" + 
					"FROM JYOTIK.OLIST_ORDER,JYOTIK.OLIST_ORDER_ITEM,JYOTIK.OLIST_PRODUCT,JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION\n" + 
					"WHERE JYOTIK.OLIST_ORDER.ORDER_ID = JYOTIK.OLIST_ORDER_ITEM.ORDER_ID\n" + 
					"AND JYOTIK.OLIST_ORDER_ITEM.PRODUCT_ID = JYOTIK.OLIST_PRODUCT.PRODUCT_ID\n" + 
					"AND JYOTIK.OLIST_PRODUCT.PRODUCT_CATEGORY_NAME = JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME\n" + 
					"\n" + 
					"GROUP BY JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP\n" + 
					"ORDER BY JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP)) where MONTH>6 and MONTH<10)\n" + 
					"UNION\n" + 
					"\n" + 
					"(select year,month,PRODUCT_CATEGORY_NAME_ENGLISH,count,total,'Spring' as season from (select EXTRACT(YEAR FROM ORDER_PURCHASE_TIMESTAMP) as year,EXTRACT(MONTH FROM ORDER_PURCHASE_TIMESTAMP) as month,PRODUCT_CATEGORY_NAME_ENGLISH,count,total FROM (SELECT JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP,\n" + 
					"       COUNT(*) as count, SUM(JYOTIK.OLIST_ORDER_ITEM.PRICE) as total\n" + 
					"FROM JYOTIK.OLIST_ORDER,JYOTIK.OLIST_ORDER_ITEM,JYOTIK.OLIST_PRODUCT,JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION\n" + 
					"WHERE JYOTIK.OLIST_ORDER.ORDER_ID = JYOTIK.OLIST_ORDER_ITEM.ORDER_ID\n" + 
					"AND JYOTIK.OLIST_ORDER_ITEM.PRODUCT_ID = JYOTIK.OLIST_PRODUCT.PRODUCT_ID\n" + 
					"AND JYOTIK.OLIST_PRODUCT.PRODUCT_CATEGORY_NAME = JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME\n" + 
					"\n" + 
					"GROUP BY JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP\n" + 
					"ORDER BY JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP)) where MONTH>0 and MONTH<4)\n" + 
					"\n" + 
					"UNION\n" + 
					"(select year,month,PRODUCT_CATEGORY_NAME_ENGLISH,count,total,'Summer' as season from (select EXTRACT(YEAR FROM ORDER_PURCHASE_TIMESTAMP) as year,EXTRACT(MONTH FROM ORDER_PURCHASE_TIMESTAMP) as month,PRODUCT_CATEGORY_NAME_ENGLISH,count,total FROM (SELECT JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP,\n" + 
					"       COUNT(*) as count, SUM(JYOTIK.OLIST_ORDER_ITEM.PRICE) as total\n" + 
					"FROM JYOTIK.OLIST_ORDER,JYOTIK.OLIST_ORDER_ITEM,JYOTIK.OLIST_PRODUCT,JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION\n" + 
					"WHERE JYOTIK.OLIST_ORDER.ORDER_ID = JYOTIK.OLIST_ORDER_ITEM.ORDER_ID\n" + 
					"AND JYOTIK.OLIST_ORDER_ITEM.PRODUCT_ID = JYOTIK.OLIST_PRODUCT.PRODUCT_ID\n" + 
					"AND JYOTIK.OLIST_PRODUCT.PRODUCT_CATEGORY_NAME = JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME\n" + 
					"\n" + 
					"GROUP BY JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP\n" + 
					"ORDER BY JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP)) where MONTH>9 and MONTH<13)\n" + 
					"UNION\n" + 
					"(select year,month,PRODUCT_CATEGORY_NAME_ENGLISH,count,total,'Winter' as season from (select EXTRACT(YEAR FROM ORDER_PURCHASE_TIMESTAMP) as year,EXTRACT(MONTH FROM ORDER_PURCHASE_TIMESTAMP) as month,PRODUCT_CATEGORY_NAME_ENGLISH,count,total FROM (SELECT JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP,\n" + 
					"       COUNT(*) as count, SUM(JYOTIK.OLIST_ORDER_ITEM.PRICE) as total\n" + 
					"FROM JYOTIK.OLIST_ORDER,JYOTIK.OLIST_ORDER_ITEM,JYOTIK.OLIST_PRODUCT,JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION\n" + 
					"WHERE JYOTIK.OLIST_ORDER.ORDER_ID = JYOTIK.OLIST_ORDER_ITEM.ORDER_ID\n" + 
					"AND JYOTIK.OLIST_ORDER_ITEM.PRODUCT_ID = JYOTIK.OLIST_PRODUCT.PRODUCT_ID\n" + 
					"AND JYOTIK.OLIST_PRODUCT.PRODUCT_CATEGORY_NAME = JYOTIK.OLIST_CATEGORY_NAME_TRANSLATION.PRODUCT_CATEGORY_NAME\n" + 
					"\n" + 
					"GROUP BY PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP\n" + 
					"ORDER BY PRODUCT_CATEGORY_NAME_ENGLISH, JYOTIK.OLIST_ORDER.ORDER_PURCHASE_TIMESTAMP)) where MONTH>3 and MONTH<7)\n" + 
					")\n" + 
					"\n" + 
					"GROUP BY year,season\n" + 
					"\n" + 
					"ORDER BY year asc,season\n" + 
					"";
					
			     System.out.println(sql);
             return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SeasonAnalysis.class));
		}
		
		public List<orderstatus> showorderstatus() 
		{
			
			String sql="select ORDER_STATUS as status,count(*) as orders from jyotik.OLIST_ORDER group by ORDER_STATUS";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(orderstatus.class));
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
