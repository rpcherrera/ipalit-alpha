package com.rpcherrera.ipalit.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rpcherrera.ipalit.entity.Blog;
import com.rpcherrera.ipalit.entity.Feedback;
import com.rpcherrera.ipalit.entity.User;
import com.rpcherrera.ipalit.entity.Wishlist;
import com.rpcherrera.ipalit.service.BlogService;
import com.rpcherrera.ipalit.service.FeedbackService;
import com.rpcherrera.ipalit.service.UserService;
import com.rpcherrera.ipalit.service.WishlistService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private BlogService blogService;

	@Autowired
	private WishlistService wishlistService;
	
	@Autowired
	private FeedbackService feedbackService;

	@ModelAttribute("blog")
	public Blog constructItem(){
		return new Blog();
	}

	@ModelAttribute("wish")
	public Wishlist constructWish(){
		return new Wishlist();
	}

	@RequestMapping("/account")
	public String account(Model model, Principal principal){
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithBlogs(name));
		return "account";
	}

	@RequestMapping(value="/account", method=RequestMethod.POST)
	public String doAddBlog(Model model, @Valid @ModelAttribute("blog") Blog blog, Principal principal, BindingResult result){
		
		if(result.hasErrors()){
			return account(model, principal);
		}
		String name = principal.getName();
		blogService.save(blog, name);
		return "redirect:/account.html";
	}

	@RequestMapping("/blog/remove/{id}")
	public String removeBlog(@PathVariable int id){
		Blog blog = blogService.findOne(id);
		blogService.delete(blog);
		return "redirect:/account.html";
	}

	@RequestMapping("/acct")
	public String acct(Model model, Principal principal){
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithWish(name));
		return "account";
	}

	@RequestMapping(value={"/acct"}, method=RequestMethod.POST)
	public String doAddWish(Model model, @ModelAttribute("wish") Wishlist wish, Principal principal, BindingResult result){
		if(result.hasErrors()){
			return acct(model, principal);
		}
		String name = principal.getName();
		wishlistService.save(wish, name);
		return "redirect:/account.html";
	}
	
	@RequestMapping("/wish/remove/{id}")
	public String removeWishlist(@PathVariable int id){
		Wishlist wishlist = wishlistService.findOne(id);
		wishlistService.delete(wishlist);
		return "redirect:/account.html";
	}
	
}
