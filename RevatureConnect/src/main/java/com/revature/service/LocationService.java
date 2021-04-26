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
	
	public Location save(Location location) {
		Location loc = locRepo.save(location);
		return loc;
	}

	public List<Location> remove(String location) { 
		locRepo.deleteById(location);
		return locRepo.findAll(); 

	}
	
	/*public List<Post> findAllByCategory(String category) {
		List<Post> posts = locRepo.findAllByCategory(category);
		return posts;
	}*/
	
	
	
}
