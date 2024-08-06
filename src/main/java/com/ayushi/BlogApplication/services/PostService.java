package com.ayushi.BlogApplication.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ayushi.BlogApplication.payloads.PostDto;

@Service
public interface PostService {
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	PostDto updatePost(PostDto postDto, Integer postId);
	PostDto getPostById(Integer postId);
	List<PostDto> getAllPosts();
	void deletePost(Integer postId);

}
