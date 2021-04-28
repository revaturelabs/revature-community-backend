package com.revature.controllers;

import java.net.URI;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Location;
import com.revature.models.Posts;
import com.revature.service.LocationService;

@RestController
@CrossOrigin("*")
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	LocationService locServ;

	@GetMapping(path = "/", produces = "application/json")
	public List<Location> getAllLocations() {

		return locServ.findAll();

	}


	@PostMapping(path = "/add/{name}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createNewLocation(@PathVariable(value = "name") String nameLoc) {
		Location locToSave = new Location(nameLoc);
		Location locSaved = locServ.save(locToSave);

		URI locationURI = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(locSaved.getLocationId())
				.toUri();
		
		//sending the path to the location in the response rather than the location obj itself
		//if you need to access the location after creating it, you can make a quick get request using this URI
		//If it turns out we are always immediately using the location object in the front end we can change this method
		return ResponseEntity.created(locationURI).build();
	}

	@DeleteMapping("/remove/{name}")
	public Map<String, Boolean> removeLocation(@PathVariable("name") String name) throws ResourceNotFoundException {
		return locServ.remove(name);

	}
	
	@GetMapping("/locations/{location}")
	public ResponseEntity<List<Posts>> getPostsByLocationId(@PathVariable("location")  Location location) {
		return new ResponseEntity<>(locServ.getAllPostsByLocationId(location), HttpStatus.OK);
	}

}

