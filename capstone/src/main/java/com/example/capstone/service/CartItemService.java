package com.example.capstone.service;

import java.util.List;

import com.example.capstone.entity.CartEntity;
import com.example.capstone.entity.CartItem;

public interface CartItemService {

	List<CartItem>findAll();
	
	
	void removeItemChk(CartEntity CART, CartItem cItem);
	
	void add(CartItem cItem);
	
	public void save(CartItem cItem);
	
}
