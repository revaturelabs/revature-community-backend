package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}