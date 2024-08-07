package com.ayushi.BlogApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushi.BlogApplication.entities.Category;
import com.ayushi.BlogApplication.entities.Post;
import com.ayushi.BlogApplication.entities.User;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	List<Post> findPostTitleContaining(String postTitle);

}
