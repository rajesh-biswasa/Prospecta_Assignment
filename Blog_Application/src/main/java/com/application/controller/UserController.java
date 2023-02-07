package com.application.controller;

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

import com.application.dto.UserDTO;
import com.application.service.UserService;
import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user/register")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto){
		
		UserDTO user_dto = userService.createUser(userDto);
		
		return new ResponseEntity<UserDTO>(user_dto, HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user_dto, @PathVariable Integer userId){
		UserDTO updated_user = userService.updateUser(user_dto, userId);
		
		return new ResponseEntity<UserDTO>(updated_user, HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable Integer userId){
		
		UserDTO deleted_user = userService.deleteUser(userId);
		
		return new ResponseEntity<UserDTO>(deleted_user, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUserDetails(){
		
		List<UserDTO> all_user = userService.getAllUser();
		
		return new ResponseEntity<List<UserDTO>>(all_user, HttpStatus.OK);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getUserDetails(@PathVariable Integer userId){
		
		UserDTO user_dto = userService.getUserById(userId);
		
		return new ResponseEntity<>(user_dto, HttpStatus.OK);
	}
	
	
}
