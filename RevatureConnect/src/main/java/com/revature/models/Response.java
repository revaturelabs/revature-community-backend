package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "response")
@NoArgsConstructor
public @Data class Response {
	
	public Response(String content, long postId, long userId) {
		this.content = content;
		this.postId = postId;
		this.userId = userId;
	}
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
    
    @Column(name = "postId")
    private long postId;

    @Column(name = "userId")
    private long userId;
    
}