package com.rpcherrera.ipalit.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rpcherrera.ipalit.entity.Feedback;
import com.rpcherrera.ipalit.service.FeedbackService;
import com.rpcherrera.ipalit.service.UserService;

@Controller
@RequestMapping("/profile")
public class ViewProfileController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private FeedbackService feedbackService;
	
	@RequestMapping
	public String users(Model model){
		model.addAttribute("users", userService.findAll());
		return "users";
	}
	
	@RequestMapping("/{id}")
	public String userDetails(Model model, @PathVariable int id){
		model.addAttribute("user", userService.findOneWithBlogs(id));
//		model.addAttribute("user", userService.findOneWithWish(id));
		return "pubview-user-account";
	}
	
	@ModelAttribute("feed")
	public Feedback constructFeedback(){
		return new Feedback();
	}
	
	@RequestMapping("/feed")
	public String oohFeed(Model model, Principal principal){
		String name = principal.getName();
		model.addAttribute("feed", userService.findOneWithFeeds(name));
		return "pubview-user-account";
	}
	
	@RequestMapping(value={"/feed"}, method=RequestMethod.POST)
	public String doAddFeedback(Model model, @ModelAttribute("feed") Feedback feed, Principal principal, BindingResult result){
		if(result.hasErrors()){
			return oohFeed(model, principal);
		}
		String name = principal.getName();
		feedbackService.save(feed, name);
		return "feed";
	}
}
