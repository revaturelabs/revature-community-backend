package com.revature.service;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;
import java.util.Map;
=======
import java.util.List;
>>>>>>> d46dc2b69031e741d82382c6fbd462d00baa6969

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.revature.exceptions.ResourceNotFoundException;
=======
import com.revature.exceptions.UserNotFoundException;
>>>>>>> d46dc2b69031e741d82382c6fbd462d00baa6969
import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
<<<<<<< HEAD
public class UserService {

	@Autowired
	UserRepository userRepo;

	// use to get all the users from db
	public List<User> findAll() {

		List<User> users = userRepo.findAll();

		return users;
	}

	// use to add a new user to the db
	public User save(User user) {
		User u = userRepo.save(user);
		return u;

	}

	// use to remove a user from the db
	public Map<String, Boolean> remove(String name) throws ResourceNotFoundException {

		User userToDel = userRepo.findOne(Example.of(new User(name)))
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));

		userRepo.delete(userToDel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);

		return response;
	}

	public User findOne(int id) throws ResourceNotFoundException {
		return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
	}

}

=======
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
>>>>>>> d46dc2b69031e741d82382c6fbd462d00baa6969
