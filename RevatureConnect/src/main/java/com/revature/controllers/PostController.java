package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Posts;
import com.revature.repositories.PostRepository;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostRepository postRepository;

	@GetMapping("/")
	public ResponseEntity<List<Posts>> getAllPost() {

		List<Posts> postList = postRepository.findAll();

		return new ResponseEntity<List<Posts>>(postList, HttpStatus.OK);

	}
	
	@PostMapping("/addPost")
	public ResponseEntity<Posts> addPost(@RequestBody Posts post){
		
		Posts newPost = postRepository.save(post);
		
		return ResponseEntity.ok().body(newPost);
		
	}
	
	

}
