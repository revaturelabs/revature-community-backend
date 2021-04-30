package com.revature.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.models.Posts;
import com.revature.models.Upvote;
import com.revature.models.User;
import com.revature.repositories.UpvoteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UpvoteTest {

	@Autowired
	private TestEntityManager entityManager; 
	
	@Autowired
	private UpvoteRepository urepo;
	
	public Posts p = new Posts();
	public User u = new User();
	
	@Test
	public void whenFindPostById_thenReturnUpvotes() {
		//given
		Upvote upvote = new Upvote(p,u);
		entityManager.persist(upvote);
		entityManager.flush();
		
		//when
		List<Upvote> found = urepo.getUpvotesByPostId(p);
		
		for (Upvote f : found) {
		assertThat(f.getUserId()).isEqualTo(upvote.getUserId());
		}
	}
}
