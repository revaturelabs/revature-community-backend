package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "response")
public class Response {

	private long id;
	private String content;
	private long postId;
	
	public Response() {
		
	}
	
	public Response(String content, long postId) {
		this.content = content;
		this.postId = postId;
	}
	
	
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
   public long getId() {
    	return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "content", columnDefinition = "TEXT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "postId")
    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

	@Override
	public String toString() {
		return "Response [id=" + id + ", content=" + content + ", postId=" + postId + "]";
	}

    
}