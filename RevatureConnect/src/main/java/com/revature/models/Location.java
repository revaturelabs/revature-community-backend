package com.revature.models;

import javax.persistence.Entity;

import lombok.Data;

@Entity
public @Data class Location {
	
	private int id;
	private String location;
	
	public Location() {}
	public Location(int id, String location) {
		this.id=id;
		this.location=location;
	}
	

}
