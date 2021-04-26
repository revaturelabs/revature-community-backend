package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Locations")
public @Data class Location {
	
	@Id
	private String location;
	private int id;
	
	
	public Location() {}
	public Location(int id, String location) {
		this.id=id;
		this.location=location;
	}
	

}
