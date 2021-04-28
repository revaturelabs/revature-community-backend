package com.revature.service;

import java.util.List;

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
	
	public List<User> getAllUsers(){
		List<User> users = userRepo.findAll();
		return users;
	}
	
	public User getUser(Integer userId) {
		User user = userRepo.findUser(userId);
		System.out.println(userId);
		System.out.println(user.getUserId());
		return user;
	}
	
}