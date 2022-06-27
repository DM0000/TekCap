package com.example.capstone.service;

import java.util.List;

import com.example.capstone.entity.CartEntity;
import com.example.capstone.entity.CartItem;
import com.example.capstone.entity.ItemEntity;

public interface CartService {

	void save(CartEntity cart);

	void removeItemChk(CartEntity CART, CartItem cItem);

	CartItem findCartItem(CartEntity cart, ItemEntity item);
	
	List<ItemEntity> cartToItems(CartEntity cart);

}
