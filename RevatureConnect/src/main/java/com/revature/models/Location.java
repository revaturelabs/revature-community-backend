package com.revature.models;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "locations")
@NoArgsConstructor
public @Data class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String location;

	public Location(String location) {
		this.location = location;
	}
	
	public Location(Integer id, String location) {
		this.id = id;
		this.location = location;
	}





	
}
