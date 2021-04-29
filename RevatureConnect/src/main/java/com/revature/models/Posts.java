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
	    @JoinColumn(name = "location_id", nullable = false)
		private Location locationId;
		
		@Enumerated(EnumType.STRING)
		@Column(name = "category_type")
		private CategoryType categoryType; 

		public Posts(Location locationId) {
			this.locationId = locationId;
		}
		
		
		
}
