package com.jihfan.water.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jihfan.water.models.User;
import com.jihfan.water.services.UserService;

@Controller
//@RequestMapping("/**") 

public class RouteController {
	private UserService uS;

	public RouteController(UserService uS) {
		this.uS = uS;
	}

	// If route does not exist, redirect to login if not in session, else dashboard.

	@RequestMapping("")
	public String index(HttpServletRequest req, HttpSession s) {
		if (!uS.isValid(s)) {
			return "redirect:/users/new";
		} else {
			User user = uS.find((long) s.getAttribute("id"));

			if (user.isHost()) {
				return "redirect:/listings/host";
			} else {
				return "redirect:/listings";
			}
		}
	}

}
