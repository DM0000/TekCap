package com.example.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.capstone.entity.CartEntity;
import com.example.capstone.entity.CartItem;
import com.example.capstone.entity.ItemEntity;
import com.example.capstone.entity.UserEntity;
import com.example.capstone.service.CartItemServiceImpl;
import com.example.capstone.service.CartServiceImpl;
import com.example.capstone.service.ItemServiceImpl;
import com.example.capstone.service.UserServiceImpl;

@Controller
public class ListController {

	@Autowired
	private ItemServiceImpl itemServiceImpl;

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	CartItemServiceImpl cartItemServiceImpl;

	@Autowired
	CartServiceImpl cartServiceImpl;

	// get all items and list
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String getItems(Model model) {
		List<ItemEntity> items = itemServiceImpl.findAllItems();
		model.addAttribute("items", items);
//		model.addAttribute("userInfo", new UserEntity());

		return "list";
	}

	@GetMapping("/list/{id}")
	public String addItem(@PathVariable("id") Long id, Authentication authentication,
			RedirectAttributes redirectAttributes) {
		ItemEntity item = itemServiceImpl.findById(id).orElseThrow();
		UserEntity userT = userServiceImpl.findByEmail(authentication.getName());
		CartEntity userCart = userT.getCart();
		if (userCart == null) {

			userCart = new CartEntity();
			cartServiceImpl.save(userCart);
			userT.setCart(userCart);
			userServiceImpl.saveUser(userT);
		}
		
		CartItem tempCartItem=new CartItem(item);
		for(CartItem c:userCart.getItems()) {
			if (c.getItem()==item) {
				tempCartItem=c;
			}else{
				
			}
		}
		
		if (!userCart.getItems().contains(tempCartItem) ) {

			cartItemServiceImpl.save(tempCartItem);
			userCart.getItems().add(tempCartItem);
			cartServiceImpl.save(userCart);
		}
		if (userCart.getItems().contains(tempCartItem)) {

			tempCartItem.setQuantity(tempCartItem.getQuantity()+1);
		
			cartItemServiceImpl.save(tempCartItem);
		}

		System.out.println(item.getName() + " added");
		redirectAttributes.addFlashAttribute("message", item.getName() + " added!");
		return "redirect:/list";
	}

	@GetMapping("/reset")
	public String reset(RedirectAttributes redirectAttributes, Authentication authentication) {

		userServiceImpl.findByEmail(authentication.getName()).getCart().getItems().clear();
		redirectAttributes.addFlashAttribute("message", "List Reset");
		return "redirect:/list";
	}

	@GetMapping("/list1/{id}")
	public String removeItem(@PathVariable("id") Long id, RedirectAttributes redirectAttributes,
			Authentication authentication) {
		ItemEntity ritem = itemServiceImpl.findById(id).orElseThrow();
		System.out.println(ritem.getName() + " removed");

		redirectAttributes.addFlashAttribute("message", ritem.getName() + " removed!");

		return "redirect:/list";
	}

}
