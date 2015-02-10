package com.rpcherrera.ipalit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rpcherrera.ipalit.service.BlogService;

@Controller
@RequestMapping("/items")
public class TradablesController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping
	public String tradables(Model model){
		model.addAttribute("tradables", blogService.findAllBlogs());
		return "items";
	}
	
	@RequestMapping("/{id}")
	public String itemDetails(Model model, @PathVariable int id){
		model.addAttribute("item", blogService.findOneBlog(id));
		return "item-detail";
	}
}
