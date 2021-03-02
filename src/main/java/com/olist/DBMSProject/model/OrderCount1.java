package com.olist.DBMSProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderCount1 
{
	@Id
	@GeneratedValue
	public String City;
	public int ORDERNUM;

	public  OrderCount1() {}
	
	public void setCity(String City)
	{
		this.City = City;
	}
	
	public void setORDERNUM(Integer ORDERNUM)
	{
		this.ORDERNUM = ORDERNUM;
	}
	
	public String getCity()
	{
		return City;
	}
	
	public int getORDERNUM()
	{
		return ORDERNUM;
	}	
}