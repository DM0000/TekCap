package com.example.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.capstone.entity.ItemEntity;
import com.example.capstone.service.ItemServiceImpl;

@Controller
@RequestMapping(path = "/total")
public class TotalController {

	@Autowired
	ItemServiceImpl itemServiceImpl;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public String getItems(Model model) {
		List<ItemEntity> items = itemServiceImpl.findByMoreThanZero();
		model.addAttribute("items", items);

		return "total";
	}

}
