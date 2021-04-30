package com.revature.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import com.revature.exceptions.ResourceNotFoundException;

import com.revature.models.Role;
import com.revature.models.RoleTitle;
import com.revature.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepo;

	// use to get all the roles from db
	public List<Role> findAll() {

		List<Role> roles = roleRepo.findAll();

		return roles;
	}

	// use to add a new role to the db
	public Role save(Role role) {
		Role u = roleRepo.save(role);
		return u;

	}

	// use to remove a role from the db
	public Map<String, Boolean> remove(RoleTitle name) throws ResourceNotFoundException {

		Role roleToDel = roleRepo.findOne(Example.of(new Role(name)))
				.orElseThrow(() -> new ResourceNotFoundException("Role not found"));

		roleRepo.delete(roleToDel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);

		return response;
	}

	public Role findOne(int id) throws ResourceNotFoundException {
		return roleRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
	}

	public Role add(Role role) throws ResourceNotFoundException {
		Example<Role> roleEx = Example.of(role);
		Role roleToAdd = roleRepo.findOne(roleEx).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
		return roleToAdd;
	}

}