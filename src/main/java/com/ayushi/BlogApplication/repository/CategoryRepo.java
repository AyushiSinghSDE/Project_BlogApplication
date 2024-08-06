package com.ayushi.BlogApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushi.BlogApplication.entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
