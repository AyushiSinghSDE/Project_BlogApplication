package com.ayushi.BlogApplication.payloads;

import java.util.Date;

import lombok.Data;

@Data
public class PostDto {

	private Integer postId;
	private String postTitle;
	private String postContent;
	private Date postDate;
	
	private UserDto user;
	private CategoryDto category;
	
}
