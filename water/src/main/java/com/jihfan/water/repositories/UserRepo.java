package com.jihfan.water.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jihfan.water.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{
	User findByEmail(String email);
}
