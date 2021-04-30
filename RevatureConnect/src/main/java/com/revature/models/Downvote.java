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
@Table(name = "downvote")
@NoArgsConstructor
public @Data class Downvote {

	public Downvote(Posts postId, User userId) {
		this.postId = postId;
		this.userId = userId;
	}
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "post_id", referencedColumnName="post_Id", nullable=false, insertable=false, updatable=false)
    @Column(name = "postId")
    private Posts postId;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "userId", referencedColumnName="userId", nullable=false, insertable=false, updatable=false)
    @Column(name = "userId")
    private User userId;
	
}
