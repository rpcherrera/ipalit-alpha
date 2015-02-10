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

import com.rpcherrera.ipalit.entity.Blog;
import com.rpcherrera.ipalit.service.BlogService;

@Controller
public class SearchController {
	private List<Blog> blogList = new ArrayList<Blog>();
	private String valuemeal = "";
	
	@Autowired
	private BlogService blogService;
	
	
	@ModelAttribute("blog")
	public Blog constructItem(){
		return new Blog();
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String loadHome(Model model){
		model.addAttribute("asdf", valuemeal);
		model.addAttribute("checkedtrade", "checked");
		model.addAttribute("checkedwish", "");
		model.addAttribute("bluga", blogList);
		return "search";
	}
	
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(Model model, @Valid @ModelAttribute("blog") Blog blog, BindingResult result){
		System.out.println(blog.getItemname());
		blogList.clear();
		List <Blog> blogs = blogService.findByItemname(blog.getItemname());
		for(Blog sample: blogs){
			blogList.add(sample);
		}
		valuemeal = blog.getItemname().toString();
		
		return "redirect:/search.html";
	}
	
	
}
