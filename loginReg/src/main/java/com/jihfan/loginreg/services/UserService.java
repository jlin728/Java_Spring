package com.jihfan.loginreg.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jihfan.loginreg.models.User;
import com.jihfan.loginreg.models.Role;
import com.jihfan.loginreg.repositories.RoleRepo;
import com.jihfan.loginreg.repositories.UserRepo;
	
	@Service
	public class UserService {
	    private UserRepo UserRepo;
	    private RoleRepo RoleRepo;
	    private BCryptPasswordEncoder bcrypt;
	    
	    public UserService(UserRepo UserRepo, RoleRepo RoleRepo, BCryptPasswordEncoder bcrypt)     {
	        this.UserRepo = UserRepo;
	        this.RoleRepo = RoleRepo;
	        this.bcrypt = bcrypt;
	    
	        init();
	    }
	    

//		To auto create roles in case we have to drop schemas 
	    public void init() {
	    	if(RoleRepo.findAll().size() < 1);
	    		Role user = new Role();
	    		user.setName("ROLE_USER");
	    		
	    		Role admin = new Role();
	    		admin.setName("ROLE_ADMIN");

//	    		Role superAdmin = new Role();
//	    		admin.setName("ROLE_SUPERADMIN");
	    		
	    		RoleRepo.save(user);
	    		RoleRepo.save(admin);
	    		//RoleRepo.save(superAdmin);
	    }
	    
	    public void saveUser(User user) {							//	Takes an User Object
	        user.setPassword(bcrypt.encode(user.getPassword()));	//	Sets & Encodes password
	        user.setRoles(RoleRepo.findByName("ROLE_USER"));		//	Sets Role(s)
	        UserRepo.save(user);
	    }
	      
	    public void saveAdmin(User user) {
	        user.setPassword(bcrypt.encode(user.getPassword()));	
	        user.setRoles(RoleRepo.findByName("ROLE_ADMIN"));	
	        UserRepo.save(user);
	    }    
	    
	    public User findByUsername(String username) {				// Takes a Username and finds it in Repo
	        return UserRepo.findByUsername(username);
	    }
	    
	    public User findByEmail(String email) {
	    	return UserRepo.findByEmail(email);
	    }
	    
	    public List<User> all(){
	    	return (List<User>)UserRepo.findAll();
	    }
}
