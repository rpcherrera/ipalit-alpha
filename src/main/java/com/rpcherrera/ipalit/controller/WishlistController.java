package com.rpcherrera.ipalit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rpcherrera.ipalit.service.WishlistService;

@Controller
@RequestMapping("/wishlists")
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;
	
	@RequestMapping
	public String wishlists(Model model){
		model.addAttribute("wishlists", wishlistService.findAllWish());
		return "wishlists";
	}
	
	@RequestMapping("/{id}")
	public String wishlistDetails(Model model, @PathVariable int id){
		model.addAttribute("wish", wishlistService.findOneWish(id));
		return "wish-detail";
	}
}
