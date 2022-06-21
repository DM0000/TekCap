package com.example.capstone.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.capstone.entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

 List<ItemEntity> findByName(String name);
	
	List<ItemEntity> findByQuantityGreaterThan(Integer num);
	
	
	
};
