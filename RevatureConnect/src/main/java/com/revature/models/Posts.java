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

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post")
@NoArgsConstructor
public @Data class Posts {

	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public Posts(String title, String content, Location locationId, CategoryType categoryType) {
		this.title = title;
		this.content = content;
		this.locationId = locationId;
		this.categoryType = categoryType;
	}
	
}
