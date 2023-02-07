package com.application.service;

import java.util.List;

import com.application.dto.UserDTO;

public interface UserService {
	
	UserDTO createUser(UserDTO userdto);
	UserDTO updateUser(UserDTO userdto, Integer userId);
	UserDTO getUserById(Integer userId);
	
	List<UserDTO> getAllUser();
	
	UserDTO deleteUser(Integer userId);
}
