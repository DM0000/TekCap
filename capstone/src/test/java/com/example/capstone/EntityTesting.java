package com.example.capstone;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.capstone.entity.CartEntity;
import com.example.capstone.entity.UserEntity;


@SpringBootTest
public class EntityTesting {

	
	
	@Test
	public void testUserEntityName() {
		String testname="nameShouldMatchThis";
		UserEntity testUser=new UserEntity();
		testUser.setName(testname);
		
		System.out.println("Test name setter and getter");
		assertEquals(testname,testUser.getName());
	}
	
	
	@Test
	public void testUserEntityEmail() {
		String testname="Email@ShouldMatchThis";
		UserEntity testUser=new UserEntity();
		testUser.setEmail(testname);
		
		System.out.println("Test email setter and getter");
		assertEquals(testname,testUser.getEmail());
	}
	
	@Test
	public void testUserEntityCart() {
		CartEntity testCart=new CartEntity();
		UserEntity testUser=new UserEntity();
		testUser.setCart(testCart);
		
		System.out.println("Test cart setter and getter");
		assertEquals(testCart,testUser.getCart());
	}
	
	
	
	
	
}
