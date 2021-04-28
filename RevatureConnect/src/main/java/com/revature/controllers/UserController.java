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
import com.revature.models.User;
import com.revature.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userServ;

	@GetMapping(path = "/", produces = "application/json")
	public List<User> getAllUsers() {

		return userServ.findAll();

	}
	
	@GetMapping(path="/{id}",produces="application/json")
	public User getUserById(@PathVariable(value="id")int id) throws ResourceNotFoundException {
		return userServ.findOne(id);
	}


	@PostMapping(path = "/add/{name}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createNewUser(@PathVariable(value = "name") String emailUser) {
		User userToSave = new User(emailUser);
	
		User userSaved = userServ.save(userToSave);

		//creating path to the user that was saved
		URI userURI = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(userSaved.getId())
				.toUri();
		
		//sending the path to the user in the response rather than the user obj itself
		//if you need to access the user after creating it, you can make a quick get request using this URI
		//If it turns out we are always immediately using the user object in the front end we can change this method
		return ResponseEntity.created(userURI).build();
	}

	@DeleteMapping("/remove/{name}")
	public Map<String, Boolean> removeUser(@PathVariable("email") String email) throws ResourceNotFoundException {
		return userServ.remove(email);

	}

}

