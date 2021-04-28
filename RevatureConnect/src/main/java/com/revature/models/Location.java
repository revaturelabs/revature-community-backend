package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "locations")
@Getter @Setter @NoArgsConstructor
public @Data class Location {

	private String location;

	public Location(String location) {
		this.location = location;
	}
}
