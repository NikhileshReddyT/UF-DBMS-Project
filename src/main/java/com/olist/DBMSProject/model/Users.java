package com.olist.DBMSProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String password;
	private String email;
	
//	@Override
//	public String toString()
//	{
//		return "{" + "id='" + getId() + "'" + 
//				", name='" + getName() + "'" + 
//				", email='" + getEmail() + "'" +
//				", password='" + getPassword() + "'" + 
//				"}";
//	}

	public Users() {}
	
	public Users(String name, String password)
	{
		this.name = name;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pasword) {
		this.password = pasword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}