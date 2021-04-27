package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Locations")
@NoArgsConstructor
public @Data class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String location;

	public Location(String name) {
		this.location = name;

	}

	public Location(Integer id, String location) {
		this.id = id;
		this.location = location;
	}
}
