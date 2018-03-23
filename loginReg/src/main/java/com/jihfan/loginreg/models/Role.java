package com.jihfan.loginreg.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="roles")
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GeneratedValue gave me the error "Could not read hi value... populate hibernate_sequence
    private Long id;
    
	@Size(min = 1, max = 255)
	private String name;
    
	@ManyToMany(mappedBy = "roles")
    private List<User> users;
	
    
    //CONSTRUCTORS
    public Role() {
    }
    
    
    //GETTERS SETTERS

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public List<User> getUsers() {
        return users;
    }
    




}