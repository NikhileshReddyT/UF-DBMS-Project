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

import com.olist.DBMSProject.model.CategorywiseProductSales;
import com.olist.DBMSProject.model.PdtCategorySalesPerMonth;
//import com.olist.DBMSProject.model.PdtCategorySalesPerMonth;
//import com.olist.DBMSProject.model.PdtCategorySalesPerYear;
//import com.olist.DBMSProject.model.TotalSalesPerMonth;
//import com.olist.DBMSProject.model.TotalSalesPerYear;
//import com.olist.DBMSProject.model.Users;
//import com.olist.DBMSProject.model.orderstatus;

@Repository
public class ProductCategorySalesVsTimeRepository
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	public List<CategorywiseProductSales> ProductCategoryVsSales()
	{
		String sql="SELECT * FROM (SELECT Category, SUM(PRICE) AS Sales from (SELECT item.PRICE, pdt.product_category_name as Category, EXTRACT(YEAR FROM ORDER_PURCHASE_TIMESTAMP) as Year from JYOTIK.OLIST_ORDER_ITEM item, JYOTIK.OLIST_PRODUCT pdt, JYOTIK.OLIST_ORDER order1 WHERE item.product_id = pdt.product_id and item.order_id = order1.order_id) group by category ORDER BY Sales DESC) WHERE ROWNUM < 13";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CategorywiseProductSales.class));
	}
//	public List<PdtCategorySalesPerYear> pdtCategorySalesVsYear()
//	{
//		String sql="SELECT Year, Category, SUM(PRICE) AS Sales from (SELECT item.PRICE, pdt.product_category_name as Category, EXTRACT(YEAR FROM ORDER_PURCHASE_TIMESTAMP) as Year from JYOTIK.OLIST_ORDER_ITEM item, JYOTIK.OLIST_PRODUCT pdt, JYOTIK.OLIST_ORDER order1 WHERE item.product_id = pdt.product_id and item.order_id = order1.order_id) group by category, Year Order By Year, Category ASC";
//		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PdtCategorySalesPerYear.class));
//	}
	public List<PdtCategorySalesPerMonth> pdtCategoryshowSalesVsMonth()
	{
		String sql="SELECT t1.Year, t1.Month, t1.Category, t1.Sales FROM (SELECT Year, Month, Category, SUM(PRICE) AS Sales from (SELECT item.PRICE, pdt.product_category_name as Category, EXTRACT(YEAR FROM ORDER_PURCHASE_TIMESTAMP) as Year, EXTRACT(MONTH FROM ORDER_PURCHASE_TIMESTAMP) as Month from JYOTIK.OLIST_ORDER_ITEM item, JYOTIK.OLIST_PRODUCT pdt, JYOTIK.OLIST_ORDER order1 WHERE item.product_id = pdt.product_id and item.order_id = order1.order_id) group by category, Year, Month Order By Year, Month, category ASC) t1, (SELECT * FROM (SELECT Category, SUM(PRICE) AS Sales from (SELECT item.PRICE, pdt.product_category_name as Category, EXTRACT(YEAR FROM ORDER_PURCHASE_TIMESTAMP) as Year from JYOTIK.OLIST_ORDER_ITEM item, JYOTIK.OLIST_PRODUCT pdt, JYOTIK.OLIST_ORDER order1 WHERE item.product_id = pdt.product_id and item.order_id = order1.order_id) group by category ORDER BY Sales DESC) WHERE ROWNUM < 13) t2 WHERE t1.Category = t2.Category";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PdtCategorySalesPerMonth.class));
	}
}