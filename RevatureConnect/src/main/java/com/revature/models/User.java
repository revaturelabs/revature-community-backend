package com.revature.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Users")
@NoArgsConstructor
public @Data class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId", nullable=false)
	private Integer id;
	@Column(unique = true, nullable=false)
	private String email;
	
	@Column(name="username", nullable=false)
	private String username;
//	@ColumnTransformer(
//		    read =  "pgp_sym_decrypt(" +
//		            "    pass, " +
//		            "    'encrypt.key'" +
//		            ")",
//		    write = "pgp_sym_encrypt( " +
//		            "    ?, " +
//		            "    'encrypt.key'" +
//		            ") "
//		)
	@Column(name = "pass", nullable=false)
	private String password;
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Response> response;
	
	public User(String email) {
		this.email = email;

	}
	

	public User(String email, String password) {
		this.email=email;
		this.password=password;
	}

	public User(Integer id, String email, String username, String password) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
	}

}
