package com.olist.DBMSProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TotalSalesPerMonth
{
	@Id
	@GeneratedValue
	public double Monthwise_Sales;
	public int Years;
	public int Months;

	public TotalSalesPerMonth() {}
	
	public void setMonthwise_Sales(Double Monthwise_Sales)
	{
		this.Monthwise_Sales = Monthwise_Sales;
	}
	
	public void setYear(Integer Years)
	{
		this.Years = Years;
	}
	
	public void setMonths(Integer Months)
	{
		this.Months = Months;
	}
	
	public double getMonthwise_Sales()
	{
		return Monthwise_Sales;
	}
	
	public int getMonths()
	{
		return Months;
	}
	
	public int getYears()
	{
		return Years;
	}	
}