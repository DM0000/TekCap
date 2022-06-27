package com.example.capstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstone.entity.CartItem;
import com.example.capstone.entity.ItemEntity;
import com.example.capstone.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

	
	@Autowired
	private ItemRepository itemRepo;
	
	
	public List<ItemEntity> findAllItems() {
		// TODO Auto-generated method stub
		return itemRepo.findAll();
	}
		

	
	
	public Optional<ItemEntity> findById(Long id) {
		return itemRepo.findById(id);
	}


}
