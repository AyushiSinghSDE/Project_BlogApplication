package com.ayushi.BlogApplication.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ayushi.BlogApplication.payloads.PostDto;

@Service
public interface PostService {
	
	PostDto createPost(PostDto postDto);
	PostDto updatePost(PostDto postDto, int postId);
	PostDto getPostById(int postId);
	List<PostDto> getAllPosts();
	void deletePost(int postId);

}
