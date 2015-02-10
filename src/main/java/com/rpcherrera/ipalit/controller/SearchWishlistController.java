package com.rpcherrera.ipalit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rpcherrera.ipalit.entity.Wishlist;
import com.rpcherrera.ipalit.service.WishlistService;

@Controller
public class SearchWishlistController {
	private List<Wishlist> wishList = new ArrayList<Wishlist>();
	private String valuemeal = "";
	
	@Autowired
	private WishlistService wishlistService;
	
	
	@ModelAttribute("wish")
	public Wishlist constructItem(){
		return new Wishlist();
	}
	
	@RequestMapping(value="/searchwish", method=RequestMethod.GET)
	public String loadHome(Model model){
		//System.out.println(blogList.size());
		model.addAttribute("asdf", valuemeal);
		model.addAttribute("checkedtrade", "");
		model.addAttribute("checkedwish", "checked");
		model.addAttribute("wishy", wishList);
		return "searchwish";
	}
	
	@RequestMapping(value="/searchwish", method=RequestMethod.POST)
	public String search(Model model, @Valid @ModelAttribute("wish") Wishlist wishlist, BindingResult result){
		System.out.println(wishlist.getWishlistName());
		wishList.clear();
		List <Wishlist> wish = wishlistService.findByWishlistName(wishlist.getWishlistName());;
		for(Wishlist sample: wish){
			wishList.add(sample);
		}
		valuemeal = wishlist.getWishlistName().toString();
		return "redirect:/searchwish.html";
	}
	
}
