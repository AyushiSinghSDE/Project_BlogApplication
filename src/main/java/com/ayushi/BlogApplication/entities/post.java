package com.ayushi.BlogApplication.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	private String postTitle;
	private String postContent;
	private Date postDate;
	
	@ManyToOne
	private User user;

	@ManyToOne
	private Category category;
}
