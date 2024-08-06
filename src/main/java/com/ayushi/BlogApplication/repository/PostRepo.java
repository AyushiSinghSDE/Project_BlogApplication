package com.ayushi.BlogApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushi.BlogApplication.entities.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer>{

}
