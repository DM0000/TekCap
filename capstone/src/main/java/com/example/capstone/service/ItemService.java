package com.example.capstone.service;

import java.util.List;
import java.util.Optional;

import com.example.capstone.entity.ItemEntity;

public interface ItemService{
	
	
	public List<ItemEntity> findAllItems();
	
	
	Optional<ItemEntity> findById(Long id);
	
}
