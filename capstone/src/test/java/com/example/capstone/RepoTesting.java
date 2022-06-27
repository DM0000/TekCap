package com.example.capstone;


import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.capstone.entity.ItemEntity;
import com.example.capstone.entity.StoreEntity;
import com.example.capstone.entity.UserEntity;
import com.example.capstone.repository.ItemRepository;
import com.example.capstone.repository.StoreRepository;
import com.example.capstone.repository.UserRepository;


@SpringBootTest
public class RepoTesting {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ItemRepository itemRepo;
	
	@Autowired
	StoreRepository storeRepo;
	

	
	
	@Test
	public void findUserByEmail() {
		String testEmail1="test@test.test";
	
		UserEntity testUser=new UserEntity();
		testUser.setEmail(testEmail1);
		userRepo.save(testUser);
		
		System.out.println(testUser.getEmail());
		assertEquals( "test@test.test",userRepo.findByEmail(testEmail1).getEmail());
		System.out.println("test user find by email");
		userRepo.delete(testUser);
	
	}
	
	@Test
	 public void testFindItemByName(){
		String itemName="itemTestName";
		
		ItemEntity testItem=new  ItemEntity();
		testItem.setName(itemName);
		itemRepo.save(testItem);
	
		assertEquals( "itemTestName",itemRepo.findByName(itemName).orElseThrow().getName());
		System.out.println("test item find by name");
		itemRepo.delete(testItem);
		
		
	}
		@Test
		public void testFindStoreByname() {
			String storeName="storeTestName";
			StoreEntity testStore=new StoreEntity();
			
			testStore.setName(storeName);
			storeRepo.save(testStore);
			
			assertEquals( "storeTestName",storeRepo.findByName(storeName).orElseThrow().getName());
			System.out.println("test store find by name");
			storeRepo.delete(testStore);
		
			
			
			
		}
	
	
	
	
}
