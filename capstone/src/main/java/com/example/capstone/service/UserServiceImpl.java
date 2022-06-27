package com.example.capstone.service;

//import java.util.Arrays;
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.example.capstone.controller.UserRegistrationDto;
//import com.example.capstone.entity.Role;
//import com.example.capstone.entity.UserEntity;
//import com.example.capstone.repository.UserRepository;
//
//
//@Service
//public class UserServiceImpl implements UserService{
//
//	@Autowired
//	UserRepository userRepo;
//	
//	  @Lazy
//	   @Autowired
//	   private BCryptPasswordEncoder passwordEncoder;
//	
//	
//
//	
//	   public UserEntity save(UserRegistrationDto registration){
//	       UserEntity user = new UserEntity();
//	       user.setName(registration.getName());
//	       user.setEmail(registration.getEmail());
//	       user.setPassword(passwordEncoder.encode(registration.getPassword()));  
//	     //if plan on using roles
//	       user.setRoles(Arrays.asList(new Role("User")));
//	       return userRepo.save(user);
//	   }
//
//	@Override
//	public UserEntity findByEmail(String email) {
//		return userRepo.findByEmail(email);
//		
//	}
//
////	   @Override
////	   public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
////	       UserEntity user = userRepo.findByEmail(email);
////	       if (user == null){
////	           throw new UsernameNotFoundException("Invalid username or password.");
////	       }
////	       return new org.springframework.security.core.userdetails.User(user.getEmail(),
////	               user.getPassword(),
////	               mapRolesToAuthorities(user.getRoles()));
////	       
////	      
////	   }
//	
//	//looks like Spring  use this method to verify user
////	   @Override
////	   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
////	       UserEntity user = userRepo.findByEmail(email);
////	       if (user == null){
////	           throw new UsernameNotFoundException("Invalid username or password.");
////	       }
////	       return new org.springframework.security.core.userdetails.User(user.getEmail(),
////	               user.getPassword(),
////	               mapRolesToAuthorities(user.getRoles()));
////	   }
//
//		   
//	
//	   private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//	       return roles.stream()
//	               .map(role -> new SimpleGrantedAuthority(role.getName()))
//	               .collect(Collectors.toList());
//	   }
//
//
//	   @Override
//	   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//	       UserEntity user = userRepo.findByEmail(email);
//	       if (user == null){
//	    	   System.out.println(userRepo.findByEmail(email));
//	           throw new UsernameNotFoundException("Invalid Email or password.");
//	       }
//	       return new org.springframework.security.core.userdetails.User(user.getEmail(),
//	               user.getPassword(),
//	               mapRolesToAuthorities(user.getRoles()));
//	   }
//	
//
//
//	   
//	
//}

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.capstone.controller.UserRegistrationDto;
import com.example.capstone.entity.CartEntity;
import com.example.capstone.entity.CartItem;
import com.example.capstone.entity.ItemEntity;
import com.example.capstone.entity.Role;
import com.example.capstone.entity.UserEntity;
import com.example.capstone.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Lazy
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserEntity findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public UserEntity save(UserRegistrationDto registration) {
		UserEntity userT = new UserEntity();
		userT.setName(registration.getName());
		userT.setEmail(registration.getEmail());
		userT.setPassword(passwordEncoder.encode(registration.getPassword()));
		userT.setRoles(Arrays.asList(new Role("USER")));
		return userRepository.save(userT);
	}

	public void saveUser(UserEntity user) {
		userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByEmail(email);
		if (user == null) {
			System.out.println(userRepository.findByEmail(email));

			throw new UsernameNotFoundException("Invalid email or password.");
		}
		System.out.println(userRepository.findByEmail(email));
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
