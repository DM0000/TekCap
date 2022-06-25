package com.example.capstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstone.entity.StoreEntity;
import com.example.capstone.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	StoreRepository storeRepo;
	
public Optional<StoreEntity> findById(Long id) {
	return storeRepo.findById(id);
}
	
	public List<StoreEntity> findAllStores(){
		return storeRepo.findAll();
		
	}
	
	
	 public Optional<StoreEntity> findByName(String name){
		 return storeRepo.findByName(name);
	 }
	 
}
