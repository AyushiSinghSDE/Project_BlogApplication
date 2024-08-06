package com.ayushi.BlogApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushi.BlogApplication.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
