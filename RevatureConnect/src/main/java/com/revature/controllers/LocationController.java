package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Location;
import com.revature.service.LocationService;

@RestController
public class LocationController {

	@Autowired
	LocationService locServ;
	@GetMapping("/locations")
	public ResponseEntity<List<Location>> getAllLocations(){
		
		List <Location> locations = locServ.findAll();
		
		return new ResponseEntity<>(locations, HttpStatus.OK);
		
	}
	
}
