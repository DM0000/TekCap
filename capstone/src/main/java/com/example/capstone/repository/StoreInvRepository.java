package com.example.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.capstone.entity.CartEntity;
import com.example.capstone.entity.StoreInvEntity;

@Repository
public interface StoreInvRepository extends JpaRepository<StoreInvEntity, Long>{

	

	
}
