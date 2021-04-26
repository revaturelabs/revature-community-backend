package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Locations")
public @Data class Location {

	@Id
<<<<<<< HEAD
	private String location;
	
=======
	@GeneratedValue(strategy = GenerationType.AUTO)
>>>>>>> 4d701f44cc1c8d5a40a240ed859f70d3a91b8586
	private int id;
	private String location;

	public Location() {
	}

	public Location(int id, String location) {
		this.id = id;
		this.location = location;
	}

	public Location(String name) {
		this.location = name;
	}
<<<<<<< HEAD
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
=======
>>>>>>> 4d701f44cc1c8d5a40a240ed859f70d3a91b8586

}
