package com.example.capstone.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
  
  public void removeItemChk(CartEntity CART,CartItem cItem) {
	
		  if(cItem.getQuantity()<=0) {
			  CART.getItems().remove(cItem);
			  cartRepository.save(CART);
		  } 
	  
	  }
  
  public CartItem findCartItem(CartEntity cart, ItemEntity item){
	 CartItem tempCItem = null;
	  for(CartItem cItem:cart.getItems()) {
		  if(cItem.getItem()==item) {
			  tempCItem=cItem;
		  }
	  }
	  return tempCItem;
  }
  
  
  
  
public List<ItemEntity> cartToItems(CartEntity cart){
	List<ItemEntity>iList=new ArrayList<ItemEntity>();
			for(CartItem cItem: cart.getItems()){
				if(cItem.getQuantity()>0)
				iList.add(cItem.getItem());
			}
	
	
	
	return iList;
	
}
  
}
