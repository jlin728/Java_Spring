package com.jihfan.loginreg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jihfan.loginreg.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
 
	User findByUsername(String username);
	
	User findByEmail(String email);

}