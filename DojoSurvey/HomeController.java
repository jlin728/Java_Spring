package com.jihfan.springSurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String submit(HttpSession session, @RequestParam(value = "first") String first, @RequestParam(value = "last") String last,
			@RequestParam(value = "location") String location, @RequestParam(value = "lang") String lang,
			@RequestParam(value = "comment") String comment) {

		session.setAttribute("first", first);
		session.setAttribute("last", last);
		session.setAttribute("location", location);
		session.setAttribute("lang", lang);
		session.setAttribute("comment", comment);

		return "redirect:/result";
	}

	@RequestMapping("/result")
	  public String result() {
		return "result.jsp";
	}

}
