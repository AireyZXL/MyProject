package com.kubuy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	@RequestMapping("/redpacket")
	public String redpacket(){
		return "redpacket";
	}
	

}
