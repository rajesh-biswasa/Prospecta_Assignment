package com.application.model;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	enum Categories{
		Technology, Art, Sports
	}
	
	private String content;
	private LocalDateTime timeStamp;
}
