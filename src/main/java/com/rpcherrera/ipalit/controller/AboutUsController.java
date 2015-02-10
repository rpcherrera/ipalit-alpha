package com.rpcherrera.ipalit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutUsController {

	@RequestMapping("/aboutus")
	public String about(){
		return "aboutus";
	}
}
