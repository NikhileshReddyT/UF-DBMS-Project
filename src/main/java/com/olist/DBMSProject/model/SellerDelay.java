package com.olist.DBMSProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SellerDelay {
	@Id
	@GeneratedValue	
	public String sellerId;
	public double para;
	public int delayCount;
	public double delayTime;
	
	
	public SellerDelay() {}
	
	public String getSellerId()
	{
		return this.sellerId;
	}
	
	public void setSellerId(String sellerId)
	{
		this.sellerId = sellerId;
	}
	
	public int getDelayCount()
	{
		return this.delayCount;
	}
	
	public void setDelayCount(int delayCount)
	{
		this.delayCount = delayCount;
	}
	
	public double getDelayTime()
	{
		return this.delayTime;
	}
	
	public void setDelayTime(double delayTime)
	{
		this.delayTime = delayTime;
	}

	public double getPara() {
		return para;
	}

	public void setPara(double para) {
		this.para = para;
	}
}
