package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/allUsers")
	public List<User> getAllUsers(){
		return userServ.getAllUsers();
	}
	
	@GetMapping("/login/{id}")
	public User userLogin(@PathVariable(value = "id") Integer id) {
		return userServ.getUser(id);
	}
	
	@GetMapping("/userLogin/{id}")
	public Boolean usrlg(@PathVariable(value = "id") Integer id) {
		User user = userServ.getUser(id);
		String username = user.getUsername();
		String password = user.getPassword();
		
		String inputUsername = "";
		String inputPassword = "";
		
		if(username == inputUsername && password == inputPassword) {
			System.out.println("Login was succesful");
			return true;
		}
		System.out.println("Unable to login");
		return false;
	}
	
	@PostMapping("/verification")
	public User login(@RequestBody User loginUser) throws UserNotFoundException {
		User user = userServ.verification(loginUser);
		return user;
	}
	
	
}
