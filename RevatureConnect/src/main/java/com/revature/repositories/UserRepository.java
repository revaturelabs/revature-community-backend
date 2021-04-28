package com.revature.repositories;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
=======
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
>>>>>>> d46dc2b69031e741d82382c6fbd462d00baa6969
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
<<<<<<< HEAD
public interface UserRepository extends JpaRepository<User, Integer>{
	
}
=======
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value="select * from user where user_id=:userId", nativeQuery=true)
	User findUser(@Param("userId") Integer user_id);
}
>>>>>>> d46dc2b69031e741d82382c6fbd462d00baa6969
