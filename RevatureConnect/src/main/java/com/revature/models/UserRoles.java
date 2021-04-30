package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "UserRoles")
@NoArgsConstructor
public @Data class UserRoles {
	@Id
	private int user_id;
	@Column(name="role_id")
	private Integer role_id;
	
	public UserRoles(int r) {
		this.role_id = r;
	}

	public UserRoles(int user_id, int role_id) {
		this.user_id = user_id;
		this.role_id = role_id;
	}
}
