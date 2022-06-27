package com.example.capstone.service;

import java.util.HashMap;
import java.util.List;

import com.example.capstone.entity.CartEntity;
import com.example.capstone.entity.ItemEntity;
import com.example.capstone.entity.StoreInvEntity;

public interface StoreInvService {

	
	
	List<StoreInvEntity> findall();
	
	List<ItemEntity> storeInvToItems(String name);
	
	
	HashMap<String, List<StoreInvEntity>> hashStores();
	
	HashMap<String, String> storeTotal(CartEntity cart);






}
