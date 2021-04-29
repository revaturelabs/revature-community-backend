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
@Table(name = "downvote")
@NoArgsConstructor
public @Data class Downvote {

	public Downvote(int postId, int userId) {
		this.postId = postId;
		this.userId = userId;
	}
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    
    @Column(name = "postId")
    private int postId;

    @Column(name = "userId")
    private int userId;
	
}
