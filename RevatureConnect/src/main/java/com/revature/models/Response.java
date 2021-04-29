package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
<<<<<<< HEAD
import lombok.NoArgsConstructor;
=======
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
>>>>>>> 3234a33e42f18d17a393a0a15834532ed13db808

@Entity
@Table(name = "response")
@NoArgsConstructor
public @Data class Response {
<<<<<<< HEAD

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    
    @Column(name = "content", columnDefinition = "TEXT")
	private String content;
    
    @Column(name = "postId")
	private long postId;
	
	
	public Response(String content, long postId) {
=======
	
	public Response(String content, long postId, long userId) {
>>>>>>> 3234a33e42f18d17a393a0a15834532ed13db808
		this.content = content;
		this.postId = postId;
		this.userId = userId;
	}
<<<<<<< HEAD
=======
	
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
>>>>>>> 3234a33e42f18d17a393a0a15834532ed13db808
    
}