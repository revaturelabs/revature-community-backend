package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "locations")
public @Data class Location {

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

}
