package com.olist.DBMSProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SeasonAnalysis {
	@Id
	@GeneratedValue
	public int year;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getProduct_category_name_english() {
		return product_category_name_english;
	}
	public void setProduct_category_name_english(String product_category_name_english) {
		this.product_category_name_english = product_category_name_english;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int month;
	public String product_category_name_english;
	public String season;
	public int count,total;
	

}
