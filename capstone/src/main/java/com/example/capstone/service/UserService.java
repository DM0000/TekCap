package com.example.capstone.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.capstone.controller.UserRegistrationDto;
import com.example.capstone.entity.UserEntity;

public interface UserService  extends UserDetailsService{
	 UserEntity findByEmail(String email);
	   
	UserEntity save(UserRegistrationDto registration);


	  
	
	   

}
