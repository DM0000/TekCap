package com.example.capstone.service;

import java.util.List;
import java.util.Optional;

import com.example.capstone.entity.StoreEntity;

public interface StoreService {

	
	Optional<StoreEntity> findById(Long id) ;
	
	List<StoreEntity> findAllStores();
	
	Optional<StoreEntity> findByName(String name);
}
