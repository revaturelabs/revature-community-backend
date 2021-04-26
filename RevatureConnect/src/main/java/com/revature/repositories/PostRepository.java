package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Posts;

public interface PostRepository extends JpaRepository<Posts, Integer> {

}
