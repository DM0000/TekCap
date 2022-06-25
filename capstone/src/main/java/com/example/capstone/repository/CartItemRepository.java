package com.example.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.capstone.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
