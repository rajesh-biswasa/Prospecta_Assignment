package com.app.service;

import com.app.dto.UserDto;
import com.app.model.User;

public interface UserService {
	
	public User registration(User userDetails);
	
	public User login(UserDto userDto);

}
