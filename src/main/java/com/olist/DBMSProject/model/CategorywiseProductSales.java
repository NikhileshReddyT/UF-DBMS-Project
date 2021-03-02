package com.olist.DBMSProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategorywiseProductSales 
{
	@Id
	@GeneratedValue
	public double Sales;
	public String Category;

	public  CategorywiseProductSales() {}
	
	public void setSALES(Double Sales)
	{
		this.Sales = Sales;
	}
	
	public void setCategory(String Category)
	{
		this.Category = Category;
	}
	
	public double getSales()
	{
		return Sales;
	}
	
	public String getCategory()
	{
		return Category;
	}	
}