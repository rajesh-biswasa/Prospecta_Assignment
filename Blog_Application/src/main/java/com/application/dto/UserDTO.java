package com.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String gender;
	private Integer age;

}
