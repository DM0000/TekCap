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
		
		
		public void add(CartItem cItem) {
			cItem.setQuantity(cItem.getQuantity()+1);
			cartItemRepository.save(cItem);
		}
		
		
		public void remove(CartItem cItem) {
			cItem.setQuantity(cItem.getQuantity()-1);
			cartItemRepository.save(cItem);
		}
		
		
}
