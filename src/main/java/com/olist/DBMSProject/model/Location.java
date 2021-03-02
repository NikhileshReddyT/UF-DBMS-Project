package com.olist.DBMSProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
	@Id
	@GeneratedValue
	public double lat;
	public double getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public double lng;
	
	public double getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}

	public Location() {}

	
}