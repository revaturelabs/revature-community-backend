package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="post")
@Getter @Setter @NoArgsConstructor
public class Posts {
		
		@Id
		@Column(name = "post_id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		
		@Column(name = "title")
		private String title;
		
		@Column(name = "content")
		private String content;
		

		@ManyToOne(fetch = FetchType.EAGER, optional = false)
	    @JoinColumn(name = "id", nullable = false)
		private Location location; 

		
		@Enumerated(EnumType.STRING)
		@Column(name = "category_type")
		private CategoryType categoryType;

		public Posts() {
			super();
		}
		

		public Posts(int id, String title, String content, Location location, CategoryType categoryType) {
			super();
			this.id = id;
			this.title = title;
			this.content = content;
			this.location = location;
			this.categoryType = categoryType;
		}



		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Location getLocation() {
			return location;
		}

		public void setLocation(Location location) {
			this.location = location;
		}

		public CategoryType getCategoryType() {
			return categoryType;
		}

		public void setCategoryType(CategoryType categoryType) {
			this.categoryType = categoryType;
		} 
		
		
		
		

		
		
		
		
}
