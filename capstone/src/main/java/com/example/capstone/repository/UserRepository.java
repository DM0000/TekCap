package com.example.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.capstone.entity.ItemEntity;
import com.example.capstone.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	
	//	Optional<UserEntity> findById(Integer NUM);
//	 UserEntity findByEmail(String email);
	
		UserEntity findByEmail(String Email);
}
