package com.jihfan.controllerspractice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
	@RequestMapping("/")			
	public String index () {
		return "forward:index.html";		// removes the [dot]html from the address bar--- even though I didn't have it without the forward
	}
	
	@RequestMapping("/world")			// routing will look like /hello/world
	public String world() {
		return "Class level annotations are cool too";
	}	
}
