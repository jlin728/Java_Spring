package com.jihfan.loginreg.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jihfan.loginreg.models.User;
import com.jihfan.loginreg.services.UserService;
import com.jihfan.loginreg.validator.UserValidator;


@Controller
public class UserController {
	
    private UserService userService;
    private UserValidator userValidator;
    
    
    public UserController (UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;    
    }

    
    @RequestMapping("/register")
    public String registerForm(@Valid @ModelAttribute("user") User user) {		// Added "@Valid @ModelAttribute("user") User user" to Login so that both can be viewed on one page
        return "login.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        userValidator.validate(user, result);
    	if (result.hasErrors()) {
            return "login.jsp";
        }
    	
    	if(userService.findByEmail(user.getEmail() ) !=null	) {
    		model.addAttribute("emailError", "Email already exists!");
    		return "login.jsp";
    	}
    	if(userService.findByUsername(user.getUsername() ) !=null ) {
    		model.addAttribute("usernameError", "Username already taken!");
    		return "login.jsp";
    	}
    	    	
    	//	userService.saveUserWithAdminRole(user);
    	//  userService.saveWithUserRole(user);
    	//  return "redirect:/login";

    	// Make First User admin    	
    	if(userService.all().size() < 1) {
    		userService.saveAdmin(user);
    	} else {
    		userService.saveUser(user);
    	}
    	
        return "redirect:/login";
    }
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {				// Principal is secure sessions	/home is a must-have Spring default
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "home.jsp"; 
    }
    
//    @RequestMapping("/login")
//    public String login() {
//        return "login.jsp";
//    }
    
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model, @Valid @ModelAttribute("user") User user) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "login.jsp";
    }
    
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "admin.jsp";
    }

        

	

    

	    
	
	
	
}
