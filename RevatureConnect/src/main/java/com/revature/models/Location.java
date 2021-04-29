package com.revature.models;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String city;
	
	private String state; 

	public Location(String city, String state) {
		this.city = city;
		this.state = state; 
	}

	public Location(Integer id, String city, String state) { 
		this.id = id; 
		this.city = city; 
		this.state = state; 
	}

	//ignore this
	public Location(int i, String state2) {
		// TODO Auto-generated constructor stub
	}

	public Location(String string) {
		// TODO Auto-generated constructor stub
	}

}
