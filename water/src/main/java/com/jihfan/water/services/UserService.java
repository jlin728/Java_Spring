package com.jihfan.water.services;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jihfan.water.models.User;
import com.jihfan.water.repositories.UserRepo;

@Service
public class UserService {
	private UserRepo userRepo;
	private BCryptPasswordEncoder bcrypt;
	
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
		this.bcrypt = encoder();
	}
	
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	//HELPER METHODS
	// helper method to make comparing passwords easier
	public boolean isMatch(String password, String dbPassword) {
		if(bcrypt.matches(password, dbPassword)) {
			return true;
		} else {
			return false;
		}
	}
	
	// keeps user in session and tracks you that way
	public void login(HttpSession s, long id) {s.setAttribute("id", id);}
	
	public void logout(HttpSession s) {s.setAttribute("id",  null);}
	
	public String redirect() {return "redirect: /users/new";}
	
	// check if user is in session
	public boolean isValid (HttpSession session) {
		if(session.getAttribute("id") == null) {return false;}
		else {return true;}
	}
	
	public User create(User user) {
		user.setPassword(bcrypt.encode(user.getPassword()));
		return this.userRepo.save(user);
	}

	public ArrayList<User> all(){
		return (ArrayList<User>) this.userRepo.findAll();
	}
	
	public User find(long id) {
		return (User) this.userRepo.findById(id).orElse(null);
	}

	public User findByEmail(String email) {
		return (User) this.userRepo.findByEmail(email);
	}
	
	public void update(User user) {
		this.userRepo.save(user);
	}
	
	public void destroy(long id) {
		this.userRepo.deleteById(id);
	}

}
