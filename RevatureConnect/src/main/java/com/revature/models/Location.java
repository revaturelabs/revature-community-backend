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
	@GeneratedValue(strategy = GenerationType.AUTO)
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

}
