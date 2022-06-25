package com.example.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstone.entity.CartEntity;
import com.example.capstone.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

@Autowired
CartRepository cartRepository;
	
	
  public void save(CartEntity cart) {
	  cartRepository.save(cart);
  }
}
