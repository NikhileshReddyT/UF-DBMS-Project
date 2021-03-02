package com.olist.DBMSProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TotalSalesPerYear 
{
	@Id
	@GeneratedValue
	public double Sales;
	public int Year;

	public  TotalSalesPerYear() {}
	
	public void setSALES(Double Sales)
	{
		this.Sales = Sales;
	}
	
	public void setYear(Integer Year)
	{
		this.Year = Year;
	}
	
	public double getSales()
	{
		return Sales;
	}
	
	public int getYear()
	{
		return Year;
	}	
}