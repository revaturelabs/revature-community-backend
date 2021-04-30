package com.revature.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import com.revature.exceptions.ResourceNotFoundException;

import com.revature.models.UserRoles;
import com.revature.repositories.UserRoleRepository;

@Service
public class UserRoleService {

	@Autowired
	UserRoleRepository userRoleRepo;

	// use to get all the userRoles from db
	public List<UserRoles> findAll() {

		List<UserRoles> userRoles = userRoleRepo.findAll();

		return userRoles;
	}

	// use to add a new userRole to the db
	public UserRoles save(UserRoles userRole) {
		UserRoles u = userRoleRepo.save(userRole);
		return u;

	}

	// use to remove a userRole from the db
	public Map<String, Boolean> remove(int id) throws ResourceNotFoundException {

		UserRoles userRoleToDel = userRoleRepo.findOne(Example.of(new UserRoles(id)))
				.orElseThrow(() -> new ResourceNotFoundException("UserRole not found"));

		userRoleRepo.delete(userRoleToDel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);

		return response;
	}

	public UserRoles findOne(int id) throws ResourceNotFoundException {
		return userRoleRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserRole not found"));
	}

	public UserRoles add(UserRoles userRole) throws ResourceNotFoundException {
		Example<UserRoles> userRoleEx = Example.of(userRole);
		UserRoles userRoleToAdd = userRoleRepo.findOne(userRoleEx).orElseThrow(() -> new ResourceNotFoundException("UserRole not found"));
		return userRoleToAdd;
	}

}