package com.ayushi.BlogApplication.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushi.BlogApplication.entities.User;
import com.ayushi.BlogApplication.exceptions.ResourceNotFoundException;
import com.ayushi.BlogApplication.payloads.UserDto;
import com.ayushi.BlogApplication.repository.UserRepo;
import com.ayushi.BlogApplication.services.UserService;

@Service
public class UserServiceImple implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User newUser = this.modelMapper.map(userDto, User.class);
		User createdUser=userRepo.save(newUser);
		return this.modelMapper.map(createdUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User newUser = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
		newUser.setUserName(userDto.getUserName());
		newUser.setUserEmail(userDto.getUserEmail());
		newUser.setUserpassword(userDto.getUserpassword());
		newUser.setUserAbout(userDto.getUserAbout());
		
		User createdUser= userRepo.save(newUser);
		
		return this.modelMapper.map(createdUser, UserDto.class);
		
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
		
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users= this.userRepo.findAll();
		List<UserDto> userDtos= users.stream().map((user)->this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		
		User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
		userRepo.deleteById(userId);
		
	}

}
