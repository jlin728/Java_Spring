package com.jihfan.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class portfoliocontroller {
	@RequestMapping("/")
	public String index () {
		return "index.html";
	}
	
	@RequestMapping("/me")
	public String me () {
		return "me.html";
	}
	
	@RequestMapping("/projects")
	public String projects () {
		return "projects.html";
	}
}
