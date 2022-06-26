package com.example.capstone.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstone.entity.CartEntity;
import com.example.capstone.entity.CartItem;
import com.example.capstone.entity.ItemEntity;
import com.example.capstone.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

@Autowired
CartRepository cartRepository;
	
	
  public void save(CartEntity cart) {
	  cartRepository.save(cart);
  }
  
  public void removeItemChk( CartEntity cart) {
	  for(CartItem cItem:cart.getItems()) {
	  if(cItem.getQuantity()<=0) {
		  cart.getItems().remove(cItem);
		 cartRepository.save(cart);
	  }
	  }
  }
  
  
public List<ItemEntity> cartToItems(CartEntity cart){
	List<ItemEntity>iList=new ArrayList<ItemEntity>();
			for(CartItem cItem: cart.getItems()){
				iList.add(cItem.getItem());
			}
	
	
	
	return iList;
	
}
  
}
