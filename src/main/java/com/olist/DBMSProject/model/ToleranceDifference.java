package com.olist.DBMSProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToleranceDifference {
	@Id
	@GeneratedValue
	public String X;
	public String getX() {
		return X;
	}

	public void setX(String X) {
		this.X = X;
	}

	public double Y;
	
	public double getY() {
		return Y;
	}

	public void setY(double Y) {
		this.Y = Y;
	}

	public ToleranceDifference() {}

	
}