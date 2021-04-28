package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Users")
@NoArgsConstructor
public @Data class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique = true, nullable=false)
	private String email;
	@Column(nullable=false)
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
	@Column(name = "pass", columnDefinition = "bytea", nullable=false)
	private String password;
	
	public User(String email) {
		this.email = email;

	}
	
	public User(String email, String password) {
		this.email=email;
		this.password=password;
	}
	public User(String email, String username, String password) {
		this.email = email;
		this.username = username;
		this.password = password;
	}
}
