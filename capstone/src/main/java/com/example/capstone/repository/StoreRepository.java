package com.example.capstone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.capstone.entity.StoreEntity;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Integer> {
	
	Optional<StoreEntity> findByName(String name);
}
