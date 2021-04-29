package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="upvote")
@NoArgsConstructor
public @Data class Upvote {

	@Id
	@Column(name = "upvoteId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer upvoteId;
	
	@Column(name = "postId")
	private Integer postId;
	
	@Column(name = "userId")
	private Integer userId;
	
	public Upvote(Integer postId, Integer userId) {
		this.postId = postId;
		this.userId = userId;
	}
}
