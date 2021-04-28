package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService{

	@Autowired 
	UserRepository userRepo;
	
	public User verification(User loginUser) throws UserNotFoundException {
		Example<User> userEx = Example.of(loginUser);
		User user = userRepo.findOne(userEx).orElseThrow(() -> new UserNotFoundException("Invalid username or password. Please try again."));
		return user;
	}
	
}