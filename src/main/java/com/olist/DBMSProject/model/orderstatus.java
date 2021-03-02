package com.olist.DBMSProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class orderstatus {
	@Id
	@GeneratedValue
	public Integer orders;
	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public String status;
	
	
//	@Override
//	public String toString()
//	{
//		return "{" + "id='" + getId() + "'" + 
//				", name='" + getName() + "'" + 
//				", email='" + getEmail() + "'" +
//				", password='" + getPassword() + "'" + 
//				"}";
//	}

	public orderstatus() {}
	
//	public orderstatus(String name, String password)
//	{
//		this.name = name;
//		this.password = password;
//	}
	


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}