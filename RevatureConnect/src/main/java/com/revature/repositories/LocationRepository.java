package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
	
	/*@Query(value="select * from locations where category= :cat, nativeQuery=true")
	List<Location> findAllByCategory(@Param("cat") String category);*/
}

