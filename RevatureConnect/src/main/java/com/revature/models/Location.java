package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "locations")
@NoArgsConstructor
public @Data class Location {


	private String location;

	public Location(String location) {
		this.location = location;
	}
}
