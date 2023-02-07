package com.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.dto.UserDTO;
import com.application.exception.ResourceNotFoundException;
import com.application.model.User;
import com.application.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepo;
	
	
	@Override
	public UserDTO createUser(UserDTO userdto) {
		User user = this.dtoToUser(userdto);
		
		User savedUser = userRepo.save(user);
		return this.userTodto(savedUser);
		
	}

	@Override
	public UserDTO updateUser(UserDTO userdto, Integer userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
		
		user.setFirstName(userdto.getFirstName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setGender(userdto.getGender());
		
		User updated_user = userRepo.save(user);
		
		UserDTO user_dto = this.userTodto(updated_user);
		return user_dto;
		
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		
		User user =  userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
		
		return this.userTodto(user);
	}

	@Override
	public List<UserDTO> getAllUser() {
		
		List<User> users=userRepo.findAll();
		
		List<UserDTO> user_dtos = users.stream().map(user -> this.userTodto(user)).collect(Collectors.toList());
		return user_dtos;
	}

	@Override
	public UserDTO deleteUser(Integer userId) {
		User user =userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user","id",userId));
		userRepo.delete(user);
		
		return this.userTodto(user);
	}
	
	
	private User dtoToUser(UserDTO userdto) {
		
		User user = new User();
		user.setId(userdto.getId());
		user.setFirstName(userdto.getFirstName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setGender(userdto.getGender());
		
		return user;
	}
	private UserDTO userTodto(User user) {
		
		UserDTO userdto = new UserDTO();
		user.setId(userdto.getId());
		user.setFirstName(userdto.getFirstName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setGender(userdto.getGender());
		
		return userdto;
	}

}
