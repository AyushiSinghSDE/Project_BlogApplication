package com.ayushi.BlogApplication.payloads;

import java.util.Date;

import lombok.Data;

@Data
public class PostDto {

	private String postTitle;
	private String postContent;
	private Date postDate;
	
}
