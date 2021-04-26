package com.revature.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> 4d701f44cc1c8d5a40a240ed859f70d3a91b8586
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Location;
import com.revature.service.LocationService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class LocationController {

	@Autowired
	LocationService locServ;
	
	@PostMapping("/locaions/addnew")
	public ResponseEntity<Location> addLocation(@RequestBody Location location) { 
		locServ.save(location); 
		return new ResponseEntity<>(location, HttpStatus.OK); 
	}
	
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
