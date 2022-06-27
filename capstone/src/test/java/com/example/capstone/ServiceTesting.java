package com.example.capstone;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.capstone.entity.CartEntity;
import com.example.capstone.entity.ItemEntity;
import com.example.capstone.entity.UserEntity;
import com.example.capstone.service.CartServiceImpl;
import com.example.capstone.service.UserServiceImpl;

@SpringBootTest
@Transactional
public class ServiceTesting {

	@Autowired
	CartServiceImpl cartServiceImpl;
	
	@Autowired 
	UserServiceImpl userServiceImpl;
	
	@Test
	public void testFindCartItem() {
		UserEntity testUser=userServiceImpl.findByEmail("test@test.com");
		CartEntity testCart=testUser.getCart();
		String testItemName="Apples";
		
		ItemEntity testItem =testCart.getItems().get(0).getItem();
	
cartServiceImpl.save(testCart);
	    assertEquals( testItemName, cartServiceImpl.findCartItem(testCart, testItem).getItem().getName()) ;
		
	}
	

}
