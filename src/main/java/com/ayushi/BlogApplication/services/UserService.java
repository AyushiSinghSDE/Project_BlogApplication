package com.ayushi.BlogApplication.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ayushi.BlogApplication.payloads.UserDto;

@Service
public interface UserService {
	
	UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto userDto, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);

}
