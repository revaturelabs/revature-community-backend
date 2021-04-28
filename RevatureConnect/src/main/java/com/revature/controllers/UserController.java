package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserService userServ;

	
	@PostMapping("/addUser")
	public ResponseEntity<User> addPost(@RequestBody User user){
		
		User newUser = userRepo.save(user);
		
		return ResponseEntity.ok().body(newUser);
	}
	
	@PostMapping("/verification")
	public User login(@RequestBody User loginUser) throws UserNotFoundException {
		User user = userServ.verification(loginUser);
		return user;
	}
	
	
}
