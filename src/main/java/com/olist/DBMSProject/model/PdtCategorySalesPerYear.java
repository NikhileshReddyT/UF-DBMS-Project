package com.olist.DBMSProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PdtCategorySalesPerYear 
{
	@Id
	@GeneratedValue
	public double Sales;
	public String Product_Category;
	public int Year;

	public  PdtCategorySalesPerYear() {}
	
	public void setSALES(Double Sales)
	{
		this.Sales = Sales;
	}
	
	public void setProduct_Category(String Product_Category)
	{
		this.Product_Category = Product_Category;
	}
	
	public void setYear(Integer Year)
	{
		this.Year = Year;
	}
	
	public double getSales()
	{
		return Sales;
	}
	
	public String getProduct_Category()
	{
		return Product_Category;
	}	
	
	public int getYear()
	{
		return Year;
	}
}