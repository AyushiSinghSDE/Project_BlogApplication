package com.ayushi.BlogApplication.services.implementations;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.This;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ayushi.BlogApplication.entities.Category;
import com.ayushi.BlogApplication.entities.Post;
import com.ayushi.BlogApplication.entities.User;
import com.ayushi.BlogApplication.exceptions.ResourceNotFoundException;
import com.ayushi.BlogApplication.payloads.CategoryDto;
import com.ayushi.BlogApplication.payloads.PostDto;
import com.ayushi.BlogApplication.repository.CategoryRepo;
import com.ayushi.BlogApplication.repository.PostRepo;
import com.ayushi.BlogApplication.repository.UserRepo;
import com.ayushi.BlogApplication.services.PostService;

@Service
public class PostServiceImple implements PostService{

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		
		User newUser= this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "userId", userId));
		Category newCategory= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		
		Post newPost= this.modelMapper.map(postDto, Post.class);
		newPost.setPostDate(new Date());
		newPost.setUser(newUser);
		newPost.setCategory(newCategory);
		Post createdPost= postRepo.save(newPost);
		
		return this.modelMapper.map(createdPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		
		Post newPost= this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "postId", postId));
		
		newPost.setPostDate(postDto.getPostDate());
		newPost.setPostTitle(postDto.getPostTitle());
		newPost.setPostContent(postDto.getPostContent());
		newPost.setPostTitle(postDto.getPostTitle());
		
		Post updatedPost= postRepo.save(newPost);
		
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public PostDto getPostById(Integer postId) {

		Post post= this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "postId", postId));
		
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getAllPosts() {
		
		List<Post> posts= this.postRepo.findAll();
		List<PostDto> postDtos= posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public void deletePost(Integer postId) {
		
		this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "postId", postId));
		postRepo.deleteById(postId);
		
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		
		Category newCategory= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		List<Post> newPosts=this.postRepo.findByCategory(newCategory);
		List<PostDto> newPostDtos= newPosts.stream().map((newPost)->this.modelMapper.map(newPost, PostDto.class)).collect(Collectors.toList());
		return newPostDtos;
	}
	

	@Override
	public List<PostDto> getPostByuser(Integer userId) {
		
		User newUser= this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "userId", userId));
		List<Post> newPosts=this.postRepo.findByUser(newUser);
		List<PostDto> newPostDtos= newPosts.stream().map((newPost)->this.modelMapper.map(newPost, PostDto.class)).collect(Collectors.toList());
		return newPostDtos;
	}

	@Override
	public List<PostDto> searchByTitle(String keyword) {
		
		List<Post> posts= postRepo.findPostTitleContaining(keyword);
		List<PostDto>postDtos=posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}


}
