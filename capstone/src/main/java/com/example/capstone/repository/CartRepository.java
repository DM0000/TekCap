package com.example.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.capstone.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

	
	
}
