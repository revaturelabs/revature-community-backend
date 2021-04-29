package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.revature.models.Location;
import com.revature.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
// }
// import com.revature.models.User;

// @Repository
// public interface UserRepository extends JpaRepository<User, Integer> {
	
// 	@Query(value="select * from user where user_id=:userId", nativeQuery=true)
// 	User findUser(@Param("userId") Integer user_id);
}

