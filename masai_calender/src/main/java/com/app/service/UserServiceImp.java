package com.app.service;

import com.app.dto.UserDto;
import com.app.model.User;
import com.app.repository.UserRepository;

public class UserServiceImp implements UserService {
	
	UserRepository userRepo;

	@Override
	public User registration(User userDetails) {
		
		User savedUser = userRepo.save(userDetails);
		return savedUser;
		
	}

	@Override
	public User login(UserDto userDto) {
		
		userRepo.findByMob(userDto.getMob());
	}

}
