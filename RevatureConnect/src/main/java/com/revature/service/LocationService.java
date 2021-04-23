package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Location;
import com.revature.repositories.LocationRepository;

@Service
public class LocationService{

	@Autowired 
	LocationRepository locRepo;
	
	public List<Location> findAll(){
		
		List<Location> locations = locRepo.findAll();
		
		return locations;
	}
	
	
	
}
