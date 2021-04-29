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
@Table(name = "response")
@NoArgsConstructor
public @Data class Response {


	public Response(String content, Integer postId, Integer userId) {

		this.content = content;
		this.postId = postId;
		this.userId = userId;
	}

	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
    
    @Column(name = "postId")
    private Integer postId;

    @Column(name = "userId")
    private Integer userId;

    
}