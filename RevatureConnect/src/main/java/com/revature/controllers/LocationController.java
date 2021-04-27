package com.revature.controllers;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Location;
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
	
	@GetMapping(path="/{id}",produces="application/json")
	public Location getLocationById(@PathVariable(value="id")int id) throws ResourceNotFoundException {
		return locServ.findOne(id);
	}


	@PostMapping(path = "/add/{name}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createNewLocation(@PathVariable(value = "name") String nameLoc) {
		Location locToSave = new Location(nameLoc);
		Location locSaved = locServ.save(locToSave);
<<<<<<< HEAD
		
<<<<<<< HEAD
		return new ResponseEntity<>(test, HttpStatus.OK);
	}
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<List<Location>> removeLoc1ation(@PathVariable ("id") int id) { 
		return new ResponseEntity<>(locServ.remove(id), HttpStatus.OK); 
=======
=======
>>>>>>> bcf7c1cb408621e2b19e9161e008692562aa665f

		URI locationURI = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(locSaved.getId())
				.toUri();
		
		//sending the path to the location in the response rather than the location obj itself
		//if you need to access the location after creating it, you can make a quick get request using this URI
		//If it turns out we are always immediately using the location object in the front end we can change this method
		return ResponseEntity.created(locationURI).build();
	}

	@DeleteMapping("/remove/{name}")
	public Map<String, Boolean> removeLocation(@PathVariable("name") String name) throws ResourceNotFoundException {
		return locServ.remove(name);

<<<<<<< HEAD
>>>>>>> 52a89fbb8edfc76b3e22a4bc8827c804edb12ac4

=======
>>>>>>> bcf7c1cb408621e2b19e9161e008692562aa665f
	}

}

