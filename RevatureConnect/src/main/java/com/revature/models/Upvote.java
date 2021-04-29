package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
	private Posts postId;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User userId;
	
	public Upvote(Posts postId, User userId) {
		this.postId = postId;
		this.userId = userId;
	}
}
