package com.revature.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.ResourceNotFoundException;
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
	
	@PostMapping("/locationspost/{name}")
	public ResponseEntity<Location> createNewLocation(@PathVariable(value="name") String nameLoc){
		Location locToSave = new Location(nameLoc);
		Location locSaved = locServ.save(locToSave);
		
		return new ResponseEntity<>(locSaved, HttpStatus.OK);
	}
		
	@DeleteMapping("/remove/{name}")
	public Map<String, Boolean> removeLoc1ation(@PathVariable ("name") String name) throws ResourceNotFoundException { 
		return locServ.remove(name);

	}
	
}
