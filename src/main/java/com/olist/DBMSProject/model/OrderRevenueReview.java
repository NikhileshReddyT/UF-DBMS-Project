package com.olist.DBMSProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderRevenueReview {
	@Id
	@GeneratedValue
	public int revenue;
	
	public int getRevenue() {
		return revenue;
	}
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	public String getProduct_category_name_english() {
		return product_category_name_english;
	}
	public void setProduct_category_name_english(String product_category_name_english) {
		this.product_category_name_english = product_category_name_english;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	public int orders;
	public String product_category_name_english;
	public Float rating;
	
	

}
