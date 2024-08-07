package com.ayushi.BlogApplication.controllers;

import java.util.List;

import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayushi.BlogApplication.payloads.PostDto;
import com.ayushi.BlogApplication.services.PostService;

@RestController
@RequestMapping("blog/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	@PostMapping("/{userId}/{categoryId}")
	public ResponseEntity<PostDto> createpost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId )
	{
		PostDto newPostDto= postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(newPostDto,HttpStatus.OK);
	}
	
	
	@PutMapping("/{postId}")
	public ResponseEntity<PostDto> updatepost(@RequestBody PostDto postDto, @PathVariable Integer postId)
	{
		PostDto newPostDto= postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(newPostDto, HttpStatus.OK);
	}
	
	
	@GetMapping("/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId)
	{
		PostDto newPostDto= postService.getPostById(postId);
		return new ResponseEntity<PostDto>(newPostDto, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId)
	{
		List<PostDto> newpPostDtos= postService.getPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(newpPostDtos, HttpStatus.OK);
	}
	
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId)
	{
		List<PostDto> newpPostDtos= postService.getPostByuser(userId);
		return new ResponseEntity<List<PostDto>>(newpPostDtos, HttpStatus.OK);
	}
	
	
	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPostByKeyword(@PathVariable String keyword)
	{
		List<PostDto> newPostDtos= postService.searchByTitle(keyword);
		return new ResponseEntity<List<PostDto>>(newPostDtos,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<PostDto>> getAllPost()
	{
		List<PostDto> postDtos= postService.getAllPosts();
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{postId}")
	public ResponseEntity<Void> deletepost(@PathVariable Integer postId)
	{
		postService.deletePost(postId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
