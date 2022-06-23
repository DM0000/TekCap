package com.example.capstone.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.capstone.entity.ItemEntity;
import com.example.capstone.entity.StoreEntity;
import com.example.capstone.service.ItemServiceImpl;
import com.example.capstone.service.StoreServiceImpl;

@Controller
@RequestMapping
public class TotalController {

	@Autowired
	ItemServiceImpl itemServiceImpl;

	@Autowired
	StoreServiceImpl storeServiceImpl;

//	@RequestMapping(path = "", method = RequestMethod.GET)
//	public String getItems(Model model) {
//		List<ItemEntity> items = itemServiceImpl.findByMoreThanZero();
//		List<StoreEntity> stores = storeServiceImpl.findAllStores();
//		
//		
//		
//		
//		model.addAttribute("stores", stores);
//		model.addAttribute("items", items);
//		model.addAttribute("pricecheck",this);
//
//		return "total";
//	} 
	
	
	@RequestMapping(path = "/total", method = RequestMethod.GET)
	public String getItems(Model model) {
		List<ItemEntity> items = itemServiceImpl.findByMoreThanZero();
		List<StoreEntity> stores = storeServiceImpl.findAllStores();
		
		
		HashMap<String, Double>storeTotal=new HashMap<String, Double>();
		storeTotal.clear();
		Double sum=0.;
		
		for (StoreEntity store:stores) {
		for(ItemEntity item: items) {
			if(store.getInventory().contains(item)) {
				sum=sum+item.getPrice();
				storeTotal.put(store.getName(), sum);
			}
		}
		}
		System.out.println(storeTotal.toString());
		model.addAttribute("storetotal", storeTotal);
//		model.addAttribute("stores", stores);
		model.addAttribute("items", items);
		

		return "/total";
	} 
	
	@GetMapping("/invchk/{name}")
	public String inventoryCheck(@PathVariable("name") String name,RedirectAttributes redirectAttributes) {
		List<ItemEntity> items = itemServiceImpl.findByMoreThanZero();
		StoreEntity store = storeServiceImpl.findByName(name).orElseThrow();
		ArrayList<String> missingItems=new ArrayList<>();
		for(ItemEntity item:items) {
			if(!store.getInventory().contains(item)) {
				
				missingItems.add(item.getName());
			}
			System.out.println("first"+missingItems.toString());
		}
		System.out.println(missingItems.toString());
		redirectAttributes.addFlashAttribute("message",
				"Missing "+(missingItems.size()+1) +" items, they are "+missingItems.toString());
		return "redirect:/total";
	}
	
//	1st attempt tryng to get total 
//	@PostMapping(")
//	public Double priceCheck(@PathVariable("id") Integer id) {
//		
//		
//		List<ItemEntity> items = itemServiceImpl.findByMoreThanZero();
//		
//		double sum=0;
//		for(ItemEntity item: items) {
//			if(store.getInventory().contains(item)) {
//				sum=sum+item.getPrice();
//			}
//		}
//		
//		return sum;
//		
//	}
	@PostMapping("/")
	public String recheckTotal(RedirectAttributes redirectAttributes) {
	List<ItemEntity> items = itemServiceImpl.findByMoreThanZero();
	List<StoreEntity> stores = storeServiceImpl.findAllStores();
	
	
	HashMap<String, Double>storeTotal=new HashMap<String, Double>();
	storeTotal.clear();
	Double sum=0.;
	
	for (StoreEntity store:stores) {
	for(ItemEntity item: items) {
		if(store.getInventory().contains(item)) {
			sum=sum+item.getPrice();
			storeTotal.put(store.getName(), sum);
		}
		
	}
	}
	System.out.println("redirect"+storeTotal.toString());
	redirectAttributes.addAttribute("storetotal", storeTotal);

	return "redirect:/total";
	
	
	
}
}
