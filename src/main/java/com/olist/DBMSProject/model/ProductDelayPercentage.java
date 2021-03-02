package com.olist.DBMSProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductDelayPercentage {
	@Id
	@GeneratedValue
	public int year;
	public int month;
	public double delayPercentage;
	
	public ProductDelayPercentage() {}
	
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
	public double getDelayPercentage() {
		return delayPercentage;
	}
	public void setDelayPercentage(double delayPercentage) {
		this.delayPercentage = delayPercentage;
	}
}
