package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="post")
@Getter @Setter @NoArgsConstructor
public class Posts {
		
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		
		@Column(name = "title")
		private String title;
		
		@Column(name = "content")
		private String content;
		
		@Column(name = "location_id")
		private String locationId; 
		
		@Column(name = "category_id")
		private String categoryId; 
		
		
		
		
}
