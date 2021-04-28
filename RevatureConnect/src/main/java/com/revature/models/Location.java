package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {

	@Id
	@Column(name = "location_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int locationId;
	
	@Column(name = "location_name")
	private String locationName;
	
	public Location() {
	}

	public Location(int locationId, String locationName) {
		this.locationName = locationName;
		this.locationId = locationId;
	}
	
	public Location(String locationName) {
		this.locationName = locationName;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
