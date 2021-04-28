package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.Location;
import com.revature.models.Posts;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
	
	/*@Query(value="select * from locations where category= :cat, nativeQuery=true")
	List<Location> findAllByCategory(@Param("cat") String category);*/
	
	@Query(value = "SELECT * FROM posts WHERE location = :locationId", nativeQuery = true)
	List<Posts> getAllPostsByLocationId(@Param("location_id") int locationId);
	
	@Query(value = "SELECT * FROM posts WHERE category_id = :categoryId", nativeQuery = true)
	List<Posts> getAllPostsByCategoryId(@Param("category_id") int categoryId);
}

