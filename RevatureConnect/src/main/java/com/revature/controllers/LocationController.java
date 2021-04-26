package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/newlocation")
	public ResponseEntity<Location> newLocation(@RequestBody Location location){
		
		Location test;
		test = locServ.save(location);
		System.out.println(test);
		
		return new ResponseEntity<>(test, HttpStatus.OK);
	}

		
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<List<Location>> removeLoc1ation(@PathVariable ("id") String id) { 
		return new ResponseEntity<>(locServ.remove(id), HttpStatus.OK); 

	}
	
}
