package com.example.capstone.service;

import java.util.List;

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
		cItem.setQuantity(cItem.getQuantity() + 1);
		cartItemRepository.save(cItem);
	}

	public void remove(CartItem cItem) {
		if (cItem.getQuantity() > 0) {
			cItem.setQuantity(cItem.getQuantity() - 1);
			cartItemRepository.save(cItem);
		}

	}

	public List<CartItem> findAll() {
		return cartItemRepository.findAll();
	}

}
