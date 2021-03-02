package com.olist.DBMSProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PdtCategorySalesPerMonth 
{
	@Id
	@GeneratedValue
	public double Sales;
	public String Category;
	public int Year;
	public int Month;

	public  PdtCategorySalesPerMonth() {}
	
	public void setSales(Double Sales)
	{
		this.Sales = Sales;
	}
	
	public void setCategory(String Category)
	{
		this.Category = Category;
	}
	
	public void setYear(Integer Year)
	{
		this.Year = Year;
	}
	
	public void setMonth(Integer Month)
	{
		this.Month = Month;
	}
	
	public double getSales()
	{
		return Sales;
	}
	
	public String getCategory()
	{
		return Category;
	}	
	
	public int getYear()
	{
		return Year;
	}
	
	public int getMonth()
	{
		return Month;
	}
}