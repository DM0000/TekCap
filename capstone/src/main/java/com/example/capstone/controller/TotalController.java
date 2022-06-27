package com.example.capstone.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.capstone.entity.CartItem;
import com.example.capstone.entity.ItemEntity;
import com.example.capstone.entity.StoreEntity;
import com.example.capstone.entity.UserEntity;
import com.example.capstone.service.CartServiceImpl;
import com.example.capstone.service.ItemServiceImpl;
import com.example.capstone.service.StoreInvServiceImpl;
import com.example.capstone.service.StoreServiceImpl;
import com.example.capstone.service.UserServiceImpl;

@Controller
@RequestMapping
public class TotalController {

	@Autowired
	ItemServiceImpl itemServiceImpl;

	@Autowired
	StoreServiceImpl storeServiceImpl;

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	StoreInvServiceImpl storeInvServiceImpl;

	@Autowired
	CartServiceImpl cartServiceImpl;

	@RequestMapping(path = "/total", method = RequestMethod.GET)
	
	public String getItems(Model model, Authentication authentication) {
		UserEntity userT = userServiceImpl.findByEmail(authentication.getName());
		HashMap<String, String> storeTotal = storeInvServiceImpl.storeTotal(userT.getCart());
		List<ItemEntity> items = cartServiceImpl.cartToItems(userT.getCart());
		List<CartItem> userCart = userT.getCart().getItems();

		System.out.println(storeTotal.toString());
		model.addAttribute("storetotal", storeTotal);
		model.addAttribute("items", items);

		return "/total";
	}

	@GetMapping("/invchk/{name}")
	public String inventoryCheck(@PathVariable("name") String name, RedirectAttributes redirectAttributes,
			Authentication authentication) {

		UserEntity userT = userServiceImpl.findByEmail(authentication.getName());

		List<ItemEntity> userCart = cartServiceImpl.cartToItems(userT.getCart());

		List<ItemEntity> items = storeInvServiceImpl.storeInvToItems(name);

		ArrayList<String> missingItems = new ArrayList<>();
		for (ItemEntity item : userCart) {
			if (!items.contains(item)) {

				missingItems.add(item.getName());
			}

		}

		if (!missingItems.isEmpty()) {
			redirectAttributes.addFlashAttribute("message",
					"Missing " + (missingItems.size()) + " items, they are " + missingItems.toString());
		} else {
			redirectAttributes.addFlashAttribute("message", "No Items Missing");
		}
		return "redirect:/total";
	}

}
