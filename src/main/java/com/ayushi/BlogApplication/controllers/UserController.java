package com.ayushi.BlogApplication.controllers;

import java.util.List;

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

import com.ayushi.BlogApplication.payloads.UserDto;
import com.ayushi.BlogApplication.services.UserService;

@RestController
@RequestMapping("/blog/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<UserDto> createuser(@RequestBody UserDto userDto)
	{
		UserDto createdUserDto= userService.createUser(userDto);
		return new ResponseEntity<UserDto>(createdUserDto, HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{userid}")
	public ResponseEntity<UserDto> updateuser(@RequestBody UserDto userDto, @PathVariable Integer userId)
	{
		UserDto updateUserDto= userService.updateUser(userDto, userId);
		return new ResponseEntity<UserDto>(updateUserDto, HttpStatus.OK);
	}
	
	
	@GetMapping("/show/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId)
	{
		UserDto userDto= userService.getUserById(userId);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	
	
	@GetMapping("/show/all")
	public ResponseEntity<List<UserDto>> getAllusers()
	{
		List<UserDto> userDtos= userService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(userDtos, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer userId)
	{
		userService.deleteUser(userId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
