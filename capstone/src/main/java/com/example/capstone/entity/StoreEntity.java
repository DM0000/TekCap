package com.example.capstone.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class StoreEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String name;
	@ManyToMany
	private List<ItemEntity> Inventory;
	
	
	public StoreEntity(String name) {
		this.name = name;
		
	}
public List<ItemEntity> getInventory() {
		return Inventory;
	}
	public void setInventory(List<ItemEntity> inventory) {
		Inventory = inventory;
	}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


 
 
 
}