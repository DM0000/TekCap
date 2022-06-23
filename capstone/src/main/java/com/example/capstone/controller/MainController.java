package com.example.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.capstone.entity.ItemEntity;
import com.example.capstone.entity.UserEntity;
import com.example.capstone.service.ItemServiceImpl;
import com.example.capstone.service.UserService;
import com.example.capstone.service.UserServiceImpl;

@Controller
public class MainController {

	@Autowired
	private ItemServiceImpl itemServiceImpl;
//	@Autowired
//private UserServiceImpl userServiceImpl;
	List<ItemEntity> ShopList;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping("/user")
	public String userIndex() {
		return "user/index";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	// get all items and list
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String getItems(Model model) {
		List<ItemEntity> items = itemServiceImpl.findAllItems();
		model.addAttribute("items", items);
//		model.addAttribute("userInfo", new UserEntity());

		return "list";
	}

	@GetMapping("/list/{name}")
	public String addItem(@PathVariable("name") String name, RedirectAttributes redirectAttributes) {
		System.out.println(name + " added");
		itemServiceImpl.addQuantity(name);
		redirectAttributes.addFlashAttribute("message", name + " added!");

		return "redirect:/list";
	}

	@GetMapping("/reset")
	public String reset(RedirectAttributes redirectAttributes) {
		itemServiceImpl.resetItems();
		redirectAttributes.addFlashAttribute("message", "List Reset");
		return "redirect:/list";
	}

	@GetMapping("/list1/{name}")
	public String removeItem(@PathVariable("name") String name, RedirectAttributes redirectAttributes) {
		System.out.println(name + " removed");
		itemServiceImpl.lowerQuantity(name);
		redirectAttributes.addFlashAttribute("message", name + " removed!");

		return "redirect:/list";
	}

}