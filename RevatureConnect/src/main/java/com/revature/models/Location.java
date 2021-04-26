package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Locations")
public  class Location {
	
	private int id;
	private String location;
	
	public Location() {}
	public Location(int id, String location) {
		this.id=id;
		this.location=location;
	}
	

}
