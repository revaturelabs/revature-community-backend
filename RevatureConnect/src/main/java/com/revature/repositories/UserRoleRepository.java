package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.UserRoles;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRoles, Integer>{

}