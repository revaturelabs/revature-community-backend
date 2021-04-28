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
@Table(name = "Users")
@NoArgsConstructor
public @Data class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique = true)
	private String email;
	
	private String username;
	private String password;
	
<<<<<<< HEAD
//	public User() {
//		
//	}
//	
	public User(Integer userId, String username, String password) {
		super();
		this.userId = userId;
=======
	public User(String email) {
		this.email = email;

	}
	
	public User(Integer id, String email, String username, String password) {
		this.id = id;
		this.email = email;
>>>>>>> 3d0d8017a8bc115fc215cbfeff1e169d61211735
		this.username = username;
		this.password = password;
	}

 // Gabe's team's work. See Jameson for notes.
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Entity
// @Table(name = "user")
// @Getter @Setter @NoArgsConstructor
// public @Data class User {
	
// 	@Id
// 	@Column(name = "user_id")
// 	@GeneratedValue(strategy=GenerationType.IDENTITY)
// 	private Integer userId;
	
// 	@Column(name = "username")
// 	private String username;
	
// 	@Column(name = "password")
// 	private String password;
	
// 	public User() {
		
// 	}
	
// 	public User(Integer userId, String username, String password) {
// 		super();
// 		this.userId = userId;
// 		this.username = username;
// 		this.password = password;
// 	}

// 	public Integer getUserId() {
// 		return userId;
// 	}

// 	public void setUserId(Integer userId) {
// 		this.userId = userId;
// 	}

// 	public String getUsername() {
// 		return username;
// 	}

// 	public void setUsername(String username) {
// 		this.username = username;
// 	}

// 	public String getPassword() {
// 		return password;
// 	}

// 	public void setPassword(String password) {
// 		this.password = password;
// 	}
	
	


}
