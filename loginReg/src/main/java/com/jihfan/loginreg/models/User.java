package com.jihfan.loginreg.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.jihfan.loginreg.models.Role;

@Entity
//@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue gave me the error "Could not read hi value... populate hibernate_sequence
    private Long id;
    
    @ManyToMany(fetch = FetchType.EAGER)		//platform uses EAGER --- I changed it to LAZY, is that why I'm getting the problem above? 
    @JoinTable(
        name = "users_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
    
    @Email							// Email REGEX validation!! Woo-Hoo!
    @Size(min = 3, max = 255)
    private String email;
    
    @Size(min = 3, max = 255)
    private String username;
    
    @Size(min = 3, max = 255)
    private String password;
    
    @Transient
    private String confirm;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="MM:dd:yyy HH:mm")
    private Date createdAt;
    @DateTimeFormat(pattern="MM:dd:yyy HH:mm")
    private Date updatedAt;
   
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    // CONSTRUCTORS
    public User() {
    }

    //GETTERS SETTERS
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    public String getEmail () {
    	return email;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getConfirm() {
        return confirm;
    }
    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    

    
    
}