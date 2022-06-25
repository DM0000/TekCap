package com.example.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstone.entity.CartItem;
import com.example.capstone.repository.CartItemRepository;

@Service
public class CartItemServiceImpl {

		@Autowired
		CartItemRepository cartItemRepository;
		
		public void save(CartItem cItem) {
			cartItemRepository.save(cItem);
		}
		
		
}
